package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Tag;
import org.jsoup.select.元素组;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 A HTML Document.

 @author Jonathan Hedley, jonathan@hedley.net */
public class 文档 extends 元素 {
    private OutputSettings outputSettings = new OutputSettings();
    private QuirksMode quirksMode = QuirksMode.noQuirks;
    private String location;
    private boolean updateMetaCharset = false;

    /**
     Create a new, empty Document.
     @param baseUri base URI of document
     @see org.jsoup.Jsoup#parse
     @see #createShell
     */
    public 文档(String baseUri) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), baseUri);
        this.location = baseUri;
    }
    
    
    public 元素 创建元素(String $标签) {
        return createElement($标签);
    }

    /**
     Create a valid, empty shell of a document, suitable for adding more elements to.
     @param baseUri baseUri of document
     @return document with html, head, and body elements.
     */
    public static 文档 createShell(String baseUri) {
        Validate.notNull(baseUri);

        文档 doc = new 文档(baseUri);
        return doc;
    }

    /**
     * Get the URL this Document was parsed from. If the starting URL is a redirect,
     * this will return the final URL from which the document was served from.
     * @return location
     */
    public String location() {
     return location;
    }
    
    /**
     Accessor to the document's {@code head} element.
     @return {@code head}
     */
    public 元素 head() {
        return findFirstElementByTagName("head", this);
    }

    /**
     Accessor to the document's {@code body} element.
     @return {@code body}
     */
    public 元素 body() {
        return findFirstElementByTagName("body", this);
    }

    /**
     Get the string contents of the document's {@code title} element.
     @return Trimmed title, or empty string if none set.
     */
    public String title() {
        // title is a preserve whitespace tag (for document output), but normalised here
        元素 titleEl = getElementsByTag("title").第一个();
        return titleEl != null ? StringUtil.normaliseWhitespace(titleEl.text()).trim() : "";
    }

    /**
     Set the document's {@code title} element. Updates the existing element, or adds {@code title} to {@code head} if
     not present
     @param title string to set as title
     */
    public void title(String title) {
        Validate.notNull(title);
        元素 titleEl = getElementsByTag("title").第一个();
        if (titleEl == null) { // add to head
            head().appendElement("title").text(title);
        } else {
            titleEl.text(title);
        }
    }

    /**
     Create a new Element, with this document's base uri. Does not make the new element a child of this document.
     @param tagName element tag name (e.g. {@code a})
     @return new element
     */
    public 元素 createElement(String tagName) {
        return new 元素(Tag.valueOf(tagName, ParseSettings.preserveCase), this.baseUri());
    }

    /**
     Normalise the document. This happens after the parse phase so generally does not need to be called.
     Moves any text content that is not in the body element into the body.
     @return this document after normalisation
     */
    public 文档 normalise() {
        元素 htmlEl = findFirstElementByTagName("html", this);
        if (htmlEl == null)
            htmlEl = appendElement("html");
        if (head() == null)
            htmlEl.prependElement("head");
        if (body() == null)
            htmlEl.appendElement("body");

        // pull text nodes out of root, html, and head els, and push into body. non-text nodes are already taken care
        // of. do in inverse order to maintain text order.
        normaliseTextNodes(head());
        normaliseTextNodes(htmlEl);
        normaliseTextNodes(this);

        normaliseStructure("head", htmlEl);
        normaliseStructure("body", htmlEl);
        
        ensureMetaCharsetElement();
        
        return this;
    }

    // does not recurse.
    private void normaliseTextNodes(元素 element) {
        List<Node> toMove = new ArrayList<>();
        for (Node node: element.childNodes) {
            if (node instanceof TextNode) {
                TextNode tn = (TextNode) node;
                if (!tn.isBlank())
                    toMove.add(tn);
            }
        }

        for (int i = toMove.size()-1; i >= 0; i--) {
            Node node = toMove.get(i);
            element.removeChild(node);
            body().prependChild(new TextNode(" "));
            body().prependChild(node);
        }
    }

    // merge multiple <head> or <body> contents into one, delete the remainder, and ensure they are owned by <html>
    private void normaliseStructure(String tag, 元素 htmlEl) {
        元素组 elements = this.getElementsByTag(tag);
        元素 master = elements.第一个(); // will always be available as created above if not existent
        if (elements.size() > 1) { // dupes, move contents to master
            List<Node> toMove = new ArrayList<>();
            for (int i = 1; i < elements.size(); i++) {
                Node dupe = elements.get(i);
                toMove.addAll(dupe.ensureChildNodes());
                dupe.remove();
            }

            for (Node dupe : toMove)
                master.appendChild(dupe);
        }
        // ensure parented by <html>
        if (!master.parent().equals(htmlEl)) {
            htmlEl.appendChild(master); // includes remove()            
        }
    }

    // fast method to get first by tag name, used for html, head, body finders
    private 元素 findFirstElementByTagName(String tag, Node node) {
        if (node.nodeName().equals(tag))
            return (元素) node;
        else {
            int size = node.childNodeSize();
            for (int i = 0; i < size; i++) {
                元素 found = findFirstElementByTagName(tag, node.childNode(i));
                if (found != null)
                    return found;
            }
        }
        return null;
    }

    @Override
    public String outerHtml() {
        return super.html(); // no outer wrapper tag
    }

    /**
     Set the text of the {@code body} of this document. Any existing nodes within the body will be cleared.
     @param text unencoded text
     @return this document
     */
    @Override
    public 元素 text(String text) {
        body().text(text); // overridden to not nuke doc structure
        return this;
    }

    @Override
    public String nodeName() {
        return "#document";
    }
    
    /**
     * Sets the charset used in this document. This method is equivalent
     * to {@link OutputSettings#charset(java.nio.charset.Charset)
     * OutputSettings.charset(Charset)} but in addition it updates the
     * charset / encoding element within the document.
     * 
     * <p>This enables
     * {@link #updateMetaCharsetElement(boolean) meta charset update}.</p>
     * 
     * <p>If there's no element with charset / encoding information yet it will
     * be created. Obsolete charset / encoding definitions are removed!</p>
     * 
     * <p><b>Elements used:</b></p>
     * 
     * <ul>
     * <li><b>Html:</b> <i>&lt;meta charset="CHARSET"&gt;</i></li>
     * <li><b>Xml:</b> <i>&lt;?xml version="1.0" encoding="CHARSET"&gt;</i></li>
     * </ul>
     * 
     * @param charset Charset
     * 
     * @see #updateMetaCharsetElement(boolean) 
     * @see OutputSettings#charset(java.nio.charset.Charset) 
     */
    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }
    
    /**
     * Returns the charset used in this document. This method is equivalent
     * to {@link OutputSettings#charset()}.
     * 
     * @return Current Charset
     * 
     * @see OutputSettings#charset() 
     */
    public Charset charset() {
        return outputSettings.charset();
    }
    
    /**
     * Sets whether the element with charset information in this document is
     * updated on changes through {@link #charset(java.nio.charset.Charset)
     * Document.charset(Charset)} or not.
     * 
     * <p>If set to <tt>false</tt> <i>(default)</i> there are no elements
     * modified.</p>
     * 
     * @param update If <tt>true</tt> the element updated on charset
     * changes, <tt>false</tt> if not
     * 
     * @see #charset(java.nio.charset.Charset) 
     */
    public void updateMetaCharsetElement(boolean update) {
        this.updateMetaCharset = update;
    }
    
    /**
     * Returns whether the element with charset information in this document is
     * updated on changes through {@link #charset(java.nio.charset.Charset)
     * Document.charset(Charset)} or not.
     * 
     * @return Returns <tt>true</tt> if the element is updated on charset
     * changes, <tt>false</tt> if not
     */
    public boolean updateMetaCharsetElement() {
        return updateMetaCharset;
    }

    @Override
    public 文档 clone() {
        文档 clone = (文档) super.clone();
        clone.outputSettings = this.outputSettings.clone();
        return clone;
    }
    
    /**
     * Ensures a meta charset (html) or xml declaration (xml) with the current
     * encoding used. This only applies with
     * {@link #updateMetaCharsetElement(boolean) updateMetaCharset} set to
     * <tt>true</tt>, otherwise this method does nothing.
     * 
     * <ul>
     * <li>An existing element gets updated with the current charset</li>
     * <li>If there's no element yet it will be inserted</li>
     * <li>Obsolete elements are removed</li>
     * </ul>
     * 
     * <p><b>Elements used:</b></p>
     * 
     * <ul>
     * <li><b>Html:</b> <i>&lt;meta charset="CHARSET"&gt;</i></li>
     * <li><b>Xml:</b> <i>&lt;?xml version="1.0" encoding="CHARSET"&gt;</i></li>
     * </ul>
     */
    private void ensureMetaCharsetElement() {
        if (updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();

            if (syntax == OutputSettings.Syntax.html) {
                元素 metaCharset = select("meta[charset]").第一个();

                if (metaCharset != null) {
                    metaCharset.attr("charset", charset().displayName());
                } else {
                    元素 head = head();

                    if (head != null) {
                        head.appendElement("meta").attr("charset", charset().displayName());
                    }
                }

                // Remove obsolete elements
                select("meta[name=charset]").remove();
            } else if (syntax == OutputSettings.Syntax.xml) {
                Node node = childNodes().get(0);

                if (node instanceof XmlDeclaration) {
                    XmlDeclaration decl = (XmlDeclaration) node;

                    if (decl.name().equals("xml")) {
                        decl.attr("encoding", charset().displayName());

                        final String version = decl.attr("version");

                        if (version != null) {
                            decl.attr("version", "1.0");
                        }
                    } else {
                        decl = new XmlDeclaration("xml", false);
                        decl.attr("version", "1.0");
                        decl.attr("encoding", charset().displayName());

                        prependChild(decl);
                    }
                } else {
                    XmlDeclaration decl = new XmlDeclaration("xml", false);
                    decl.attr("version", "1.0");
                    decl.attr("encoding", charset().displayName());

                    prependChild(decl);
                }
            }
        }
    }
    

    /**
     * A Document's output settings control the form of the text() and html() methods.
     */
    public static class OutputSettings implements Cloneable {
        /**
         * The output serialization syntax.
         */
        public enum Syntax {html, xml}

        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private Charset charset;
        private ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>(); // initialized by start of OuterHtmlVisitor
        Entities.CoreCharset coreCharset; // fast encoders for ascii and utf8

        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;
        private Syntax syntax = Syntax.html;

        public OutputSettings() {
            charset(Charset.forName("UTF8"));
        }
        
        /**
         * Get the document's current HTML escape mode: <code>base</code>, which provides a limited set of named HTML
         * entities and escapes other characters as numbered entities for maximum compatibility; or <code>extended</code>,
         * which uses the complete set of HTML named entities.
         * <p>
         * The default escape mode is <code>base</code>.
         * @return the document's current escape mode
         */
        public Entities.EscapeMode escapeMode() {
            return escapeMode;
        }

        /**
         * Set the document's escape mode, which determines how characters are escaped when the output character set
         * does not support a given character:- using either a named or a numbered escape.
         * @param escapeMode the new escape mode to use
         * @return the document's output settings, for chaining
         */
        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        /**
         * Get the document's current output charset, which is used to control which characters are escaped when
         * generating HTML (via the <code>html()</code> methods), and which are kept intact.
         * <p>
         * Where possible (when parsing from a URL or File), the document's output charset is automatically set to the
         * input charset. Otherwise, it defaults to UTF-8.
         * @return the document's current charset.
         */
        public Charset charset() {
            return charset;
        }

        /**
         * Update the document's output charset.
         * @param charset the new charset to use.
         * @return the document's output settings, for chaining
         */
        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        /**
         * Update the document's output charset.
         * @param charset the new charset (by name) to use.
         * @return the document's output settings, for chaining
         */
        public OutputSettings charset(String charset) {
            charset(Charset.forName(charset));
            return this;
        }

        CharsetEncoder prepareEncoder() {
            // created at start of OuterHtmlVisitor so each pass has own encoder, so OutputSettings can be shared among threads
            CharsetEncoder encoder = charset.newEncoder();
            encoderThreadLocal.set(encoder);
            coreCharset = Entities.CoreCharset.byName(encoder.charset().name());
            return encoder;
        }

        CharsetEncoder encoder() {
            CharsetEncoder encoder = encoderThreadLocal.get();
            return encoder != null ? encoder : prepareEncoder();
        }

        /**
         * Get the document's current output syntax.
         * @return current syntax
         */
        public Syntax syntax() {
            return syntax;
        }

        /**
         * Set the document's output syntax. Either {@code html}, with empty tags and boolean attributes (etc), or
         * {@code xml}, with self-closing tags.
         * @param syntax serialization syntax
         * @return the document's output settings, for chaining
         */
        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }

        /**
         * Get if pretty printing is enabled. Default is true. If disabled, the HTML output methods will not re-format
         * the output, and the output will generally look like the input.
         * @return if pretty printing is enabled.
         */
        public boolean prettyPrint() {
            return prettyPrint;
        }

        /**
         * Enable or disable pretty printing.
         * @param pretty new pretty print setting
         * @return this, for chaining
         */
        public OutputSettings prettyPrint(boolean pretty) {
            prettyPrint = pretty;
            return this;
        }
        
        /**
         * Get if outline mode is enabled. Default is false. If enabled, the HTML output methods will consider
         * all tags as block.
         * @return if outline mode is enabled.
         */
        public boolean outline() {
            return outline;
        }
        
        /**
         * Enable or disable HTML outline mode.
         * @param outlineMode new outline setting
         * @return this, for chaining
         */
        public OutputSettings outline(boolean outlineMode) {
            outline = outlineMode;
            return this;
        }

        /**
         * Get the current tag indent amount, used when pretty printing.
         * @return the current indent amount
         */
        public int indentAmount() {
            return indentAmount;
        }

        /**
         * Set the indent amount for pretty printing
         * @param indentAmount number of spaces to use for indenting each level. Must be {@literal >=} 0.
         * @return this, for chaining
         */
        public OutputSettings indentAmount(int indentAmount) {
            Validate.isTrue(indentAmount >= 0);
            this.indentAmount = indentAmount;
            return this;
        }

        @Override
        public OutputSettings clone() {
            OutputSettings clone;
            try {
                clone = (OutputSettings) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            clone.charset(charset.name()); // new charset and charset encoder
            clone.escapeMode = Entities.EscapeMode.valueOf(escapeMode.name());
            // indentAmount, prettyPrint are primitives so object.clone() will handle
            return clone;
        }
    }

    /**
     * Get the document's current output settings.
     * @return the document's current output settings.
     */
    public OutputSettings outputSettings() {
        return outputSettings;
    }

    /**
     * Set the document's output settings.
     * @param outputSettings new output settings.
     * @return this document, for chaining.
     */
    public 文档 outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public enum QuirksMode {
        noQuirks, quirks, limitedQuirks
    }

    public QuirksMode quirksMode() {
        return quirksMode;
    }

    public 文档 quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }
}
