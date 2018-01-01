package org.jsoup.select;

import java.util.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;

/**
 A list of {@link Element}s, with methods that act on every element in the list.
 <p>
 To get an {@code Elements} object, use the {@link Element#select(String)} method.
 </p>

 @author Jonathan Hedley, jonathan@hedley.net */
public class 元素组 extends ArrayList<元素> {
    
    public 元素组() {
    }

    public 元素组(int initialCapacity) {
        super(initialCapacity);
    }

    public 元素组(Collection<元素> elements) {
        super(elements);
    }
    
    public 元素组(List<元素> elements) {
        super(elements);
    }
    
    public 元素组(元素... elements) {
    	super(Arrays.asList(elements));
    }

    /**
     * Creates a deep copy of these elements.
     * @return a deep copy
     */
    @Override
	public 元素组 clone() {
        元素组 clone = new 元素组(size());
        for(元素 e : this)
    		clone.add(e.clone());
    	
    	return clone;
	}

	// attribute methods
    /**
     Get an attribute value from the first matched element that has the attribute.
     @param attributeKey The attribute key.
     @return The attribute value from the first matched element that has the attribute.. If no elements were matched (isEmpty() == true),
     or if the no elements have the attribute, returns empty string.
     @see #hasAttr(String)
     */
    public String attr(String attributeKey) {
        for (元素 element : this) {
            if (element.hasAttr(attributeKey))
                return element.attr(attributeKey);
        }
        return "";
    }

    /**
     Checks if any of the matched elements have this attribute defined.
     @param attributeKey attribute key
     @return true if any of the elements have the attribute; false if none do.
     */
    public boolean hasAttr(String attributeKey) {
        for (元素 element : this) {
            if (element.hasAttr(attributeKey))
                return true;
        }
        return false;
    }

    /**
     * Get the attribute value for each of the matched elements. If an element does not have this attribute, no value is
     * included in the result set for that element.
     * @param attributeKey the attribute name to return values for. You can add the {@code abs:} prefix to the key to
     * get absolute URLs from relative URLs, e.g.: {@code doc.select("a").eachAttr("abs:href")} .
     * @return a list of each element's attribute value for the attribute
     */
    public List<String> eachAttr(String attributeKey) {
        List<String> attrs = new ArrayList<>(size());
        for (元素 element : this) {
            if (element.hasAttr(attributeKey))
                attrs.add(element.attr(attributeKey));
        }
        return attrs;
    }

    /**
     * Set an attribute on all matched elements.
     * @param attributeKey attribute key
     * @param attributeValue attribute value
     * @return this
     */
    public 元素组 attr(String attributeKey, String attributeValue) {
        for (元素 element : this) {
            element.attr(attributeKey, attributeValue);
        }
        return this;
    }

    /**
     * Remove an attribute from every matched element.
     * @param attributeKey The attribute to remove.
     * @return this (for chaining)
     */
    public 元素组 removeAttr(String attributeKey) {
        for (元素 element : this) {
            element.removeAttr(attributeKey);
        }
        return this;
    }

    /**
     Add the class name to every matched element's {@code class} attribute.
     @param className class name to add
     @return this
     */
    public 元素组 addClass(String className) {
        for (元素 element : this) {
            element.addClass(className);
        }
        return this;
    }

    /**
     Remove the class name from every matched element's {@code class} attribute, if present.
     @param className class name to remove
     @return this
     */
    public 元素组 removeClass(String className) {
        for (元素 element : this) {
            element.removeClass(className);
        }
        return this;
    }

    /**
     Toggle the class name on every matched element's {@code class} attribute.
     @param className class name to add if missing, or remove if present, from every element.
     @return this
     */
    public 元素组 toggleClass(String className) {
        for (元素 element : this) {
            element.toggleClass(className);
        }
        return this;
    }

    /**
     Determine if any of the matched elements have this class name set in their {@code class} attribute.
     @param className class name to check for
     @return true if any do, false if none do
     */
    public boolean hasClass(String className) {
        for (元素 element : this) {
            if (element.hasClass(className))
                return true;
        }
        return false;
    }
    
    /**
     * Get the form element's value of the first matched element.
     * @return The form element's value, or empty if not set.
     * @see Element#val()
     */
    public String val() {
        if (size() > 0)
            return 第一个().val();
        else
            return "";
    }
    
    /**
     * Set the form element's value in each of the matched elements.
     * @param value The value to set into each matched element
     * @return this (for chaining)
     */
    public 元素组 val(String value) {
        for (元素 element : this)
            element.val(value);
        return this;
    }
    
    /**
     * Get the combined text of all the matched elements.
     * <p>
     * Note that it is possible to get repeats if the matched elements contain both parent elements and their own
     * children, as the Element.text() method returns the combined text of a parent and all its children.
     * @return string of all text: unescaped and no HTML.
     * @see Element#text()
     * @see #eachText()
     */
    public String text() {
        StringBuilder sb = new StringBuilder();
        for (元素 element : this) {
            if (sb.length() != 0)
                sb.append(" ");
            sb.append(element.text());
        }
        return sb.toString();
    }

    /**
     Test if any matched Element has any text content, that is not just whitespace.
     @return true if any element has non-blank text content.
     @see Element#hasText()
     */
    public boolean hasText() {
        for (元素 element: this) {
            if (element.hasText())
                return true;
        }
        return false;
    }

    /**
     * Get the text content of each of the matched elements. If an element has no text, then it is not included in the
     * result.
     * @return A list of each matched element's text content.
     * @see Element#text()
     * @see Element#hasText()
     * @see #text()
     */
    public List<String> eachText() {
        ArrayList<String> texts = new ArrayList<>(size());
        for (元素 el: this) {
            if (el.hasText())
                texts.add(el.text());
        }
        return texts;
    }
    
    /**
     * Get the combined inner HTML of all matched elements.
     * @return string of all element's inner HTML.
     * @see #text()
     * @see #outerHtml()
     */
    public String html() {
        StringBuilder sb = new StringBuilder();
        for (元素 element : this) {
            if (sb.length() != 0)
                sb.append("\n");
            sb.append(element.html());
        }
        return sb.toString();
    }
    
    /**
     * Get the combined outer HTML of all matched elements.
     * @return string of all element's outer HTML.
     * @see #text()
     * @see #html()
     */
    public String outerHtml() {
        StringBuilder sb = new StringBuilder();
        for (元素 element : this) {
            if (sb.length() != 0)
                sb.append("\n");
            sb.append(element.outerHtml());
        }
        return sb.toString();
    }

    /**
     * Get the combined outer HTML of all matched elements. Alias of {@link #outerHtml()}.
     * @return string of all element's outer HTML.
     * @see #text()
     * @see #html()
     */
    @Override
    public String toString() {
        return outerHtml();
    }

    /**
     * Update the tag name of each matched element. For example, to change each {@code <i>} to a {@code <em>}, do
     * {@code doc.select("i").tagName("em");}
     * @param tagName the new tag name
     * @return this, for chaining
     * @see Element#tagName(String)
     */
    public 元素组 tagName(String tagName) {
        for (元素 element : this) {
            element.tagName(tagName);
        }
        return this;
    }
    
    /**
     * Set the inner HTML of each matched element.
     * @param html HTML to parse and set into each matched element.
     * @return this, for chaining
     * @see Element#html(String)
     */
    public 元素组 html(String html) {
        for (元素 element : this) {
            element.html(html);
        }
        return this;
    }
    
    /**
     * Add the supplied HTML to the start of each matched element's inner HTML.
     * @param html HTML to add inside each element, before the existing HTML
     * @return this, for chaining
     * @see Element#prepend(String)
     */
    public 元素组 prepend(String html) {
        for (元素 element : this) {
            element.prepend(html);
        }
        return this;
    }
    
    /**
     * Add the supplied HTML to the end of each matched element's inner HTML.
     * @param html HTML to add inside each element, after the existing HTML
     * @return this, for chaining
     * @see Element#append(String)
     */
    public 元素组 append(String html) {
        for (元素 element : this) {
            element.append(html);
        }
        return this;
    }
    
    /**
     * Insert the supplied HTML before each matched element's outer HTML.
     * @param html HTML to insert before each element
     * @return this, for chaining
     * @see Element#before(String)
     */
    public 元素组 before(String html) {
        for (元素 element : this) {
            element.before(html);
        }
        return this;
    }
    
    /**
     * Insert the supplied HTML after each matched element's outer HTML.
     * @param html HTML to insert after each element
     * @return this, for chaining
     * @see Element#after(String)
     */
    public 元素组 after(String html) {
        for (元素 element : this) {
            element.after(html);
        }
        return this;
    }

    /**
     Wrap the supplied HTML around each matched elements. For example, with HTML
     {@code <p><b>This</b> is <b>Jsoup</b></p>},
     <code>doc.select("b").wrap("&lt;i&gt;&lt;/i&gt;");</code>
     becomes {@code <p><i><b>This</b></i> is <i><b>jsoup</b></i></p>}
     @param html HTML to wrap around each element, e.g. {@code <div class="head"></div>}. Can be arbitrarily deep.
     @return this (for chaining)
     @see Element#wrap
     */
    public 元素组 wrap(String html) {
        Validate.notEmpty(html);
        for (元素 element : this) {
            element.wrap(html);
        }
        return this;
    }

    /**
     * Removes the matched elements from the DOM, and moves their children up into their parents. This has the effect of
     * dropping the elements but keeping their children.
     * <p>
     * This is useful for e.g removing unwanted formatting elements but keeping their contents.
     * </p>
     * 
     * E.g. with HTML: <p>{@code <div><font>One</font> <font><a href="/">Two</a></font></div>}</p>
     * <p>{@code doc.select("font").unwrap();}</p>
     * <p>HTML = {@code <div>One <a href="/">Two</a></div>}</p>
     *
     * @return this (for chaining)
     * @see Node#unwrap
     */
    public 元素组 unwrap() {
        for (元素 element : this) {
            element.unwrap();
        }
        return this;
    }

    /**
     * Empty (remove all child nodes from) each matched element. This is similar to setting the inner HTML of each
     * element to nothing.
     * <p>
     * E.g. HTML: {@code <div><p>Hello <b>there</b></p> <p>now</p></div>}<br>
     * <code>doc.select("p").empty();</code><br>
     * HTML = {@code <div><p></p> <p></p></div>}
     * @return this, for chaining
     * @see Element#empty()
     * @see #remove()
     */
    public 元素组 empty() {
        for (元素 element : this) {
            element.empty();
        }
        return this;
    }

    /**
     * Remove each matched element from the DOM. This is similar to setting the outer HTML of each element to nothing.
     * <p>
     * E.g. HTML: {@code <div><p>Hello</p> <p>there</p> <img /></div>}<br>
     * <code>doc.select("p").remove();</code><br>
     * HTML = {@code <div> <img /></div>}
     * <p>
     * Note that this method should not be used to clean user-submitted HTML; rather, use {@link org.jsoup.safety.Cleaner} to clean HTML.
     * @return this, for chaining
     * @see Element#empty()
     * @see #empty()
     */
    public 元素组 remove() {
        for (元素 element : this) {
            element.remove();
        }
        return this;
    }
    
    // filters
    
    /**
     * Find matching elements within this element list.
     * @param query A {@link Selector} query
     * @return the filtered list of elements, or an empty list if none match.
     */
    public 元素组 select(String query) {
        return Selector.select(query, this);
    }

    /**
     * Remove elements from this list that match the {@link Selector} query.
     * <p>
     * E.g. HTML: {@code <div class=logo>One</div> <div>Two</div>}<br>
     * <code>Elements divs = doc.select("div").not(".logo");</code><br>
     * Result: {@code divs: [<div>Two</div>]}
     * <p>
     * @param query the selector query whose results should be removed from these elements
     * @return a new elements list that contains only the filtered results
     */
    public 元素组 not(String query) {
        元素组 out = Selector.select(query, this);
        return Selector.filterOut(this, out);
    }
    
    /**
     * Get the <i>nth</i> matched element as an Elements object.
     * <p>
     * See also {@link #get(int)} to retrieve an Element.
     * @param index the (zero-based) index of the element in the list to retain
     * @return Elements containing only the specified element, or, if that element did not exist, an empty list.
     */
    public 元素组 eq(int index) {
        return size() > index ? new 元素组(get(index)) : new 元素组();
    }
    
    /**
     * Test if any of the matched elements match the supplied query.
     * @param query A selector
     * @return true if at least one element in the list matches the query.
     */
    public boolean is(String query) {
        Evaluator eval = QueryParser.parse(query);
        for (元素 e : this) {
            if (e.is(eval))
                return true;
        }
        return false;
    }

    /**
     * Get the immediate next element sibling of each element in this list.
     * @return next element siblings.
     */
    public 元素组 next() {
        return siblings(null, true, false);
    }

    /**
     * Get the immediate next element sibling of each element in this list, filtered by the query.
     * @param query CSS query to match siblings against
     * @return next element siblings.
     */
    public 元素组 next(String query) {
        return siblings(query, true, false);
    }

    /**
     * Get all of the following element siblings of each element in this list.
     * @return all following element siblings.
     */
    public 元素组 nextAll() {
        return siblings(null, true, true);
    }

    /**
     * Get all of the following element siblings of each element in this list, filtered by the query.
     * @param query CSS query to match siblings against
     * @return all following element siblings.
     */
    public 元素组 nextAll(String query) {
        return siblings(query, true, true);
    }

    /**
     * Get the immediate previous element sibling of each element in this list.
     * @return previous element siblings.
     */
    public 元素组 prev() {
        return siblings(null, false, false);
    }

    /**
     * Get the immediate previous element sibling of each element in this list, filtered by the query.
     * @param query CSS query to match siblings against
     * @return previous element siblings.
     */
    public 元素组 prev(String query) {
        return siblings(query, false, false);
    }

    /**
     * Get all of the previous element siblings of each element in this list.
     * @return all previous element siblings.
     */
    public 元素组 prevAll() {
        return siblings(null, false, true);
    }

    /**
     * Get all of the previous element siblings of each element in this list, filtered by the query.
     * @param query CSS query to match siblings against
     * @return all previous element siblings.
     */
    public 元素组 prevAll(String query) {
        return siblings(query, false, true);
    }

    private 元素组 siblings(String query, boolean next, boolean all) {
        元素组 els = new 元素组();
        Evaluator eval = query != null? QueryParser.parse(query) : null;
        for (元素 e : this) {
            do {
                元素 sib = next ? e.nextElementSibling() : e.previousElementSibling();
                if (sib == null) break;
                if (eval == null)
                    els.add(sib);
                else if (sib.is(eval))
                    els.add(sib);
                e = sib;
            } while (all);
        }
        return els;
    }

    /**
     * Get all of the parents and ancestor elements of the matched elements.
     * @return all of the parents and ancestor elements of the matched elements
     */
    public 元素组 parents() {
        HashSet<元素> combo = new LinkedHashSet<>();
        for (元素 e: this) {
            combo.addAll(e.parents());
        }
        return new 元素组(combo);
    }

    // list-like methods
    /**
     Get the first matched element.
     @return The first matched element, or <code>null</code> if contents is empty.
     */
    public 元素 第一个() {
        return isEmpty() ? null : get(0);
    }

    /**
     Get the last matched element.
     @return The last matched element, or <code>null</code> if contents is empty.
     */
    public 元素 最后一个() {
        return isEmpty() ? null : get(size() - 1);
    }

    /**
     * Perform a depth-first traversal on each of the selected elements.
     * @param nodeVisitor the visitor callbacks to perform on each node
     * @return this, for chaining
     */
    public 元素组 traverse(NodeVisitor nodeVisitor) {
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    /**
     * Perform a depth-first filtering on each of the selected elements.
     * @param nodeFilter the filter callbacks to perform on each node
     * @return this, for chaining
     */
    public 元素组 filter(NodeFilter nodeFilter) {
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    /**
     * Get the {@link FormElement} forms from the selected elements, if any.
     * @return a list of {@link FormElement}s pulled from the matched elements. The list will be empty if the elements contain
     * no forms.
     */
    public List<FormElement> forms() {
        ArrayList<FormElement> forms = new ArrayList<>();
        for (元素 el: this)
            if (el instanceof FormElement)
                forms.add((FormElement) el);
        return forms;
    }

}
