package org.jsoup.select;

import org.jsoup.nodes.元素;
import org.jsoup.nodes.Node;

import static org.jsoup.select.NodeFilter.FilterResult.CONTINUE;
import static org.jsoup.select.NodeFilter.FilterResult.STOP;

/**
 * Collects a list of elements that match the supplied criteria.
 *
 * @author Jonathan Hedley
 */
public class Collector {

    private Collector() {
    }

    /**
     Build a list of elements, by visiting root and every descendant of root, and testing it against the evaluator.
     @param eval Evaluator to test elements against
     @param root root of tree to descend
     @return list of matches; empty if none
     */
    public static 元素组 collect (Evaluator eval, 元素 root) {
        元素组 elements = new 元素组();
        NodeTraversor.traverse(new Accumulator(root, elements, eval), root);
        return elements;
    }

    private static class Accumulator implements NodeVisitor {
        private final 元素 root;
        private final 元素组 elements;
        private final Evaluator eval;

        Accumulator(元素 root, 元素组 elements, Evaluator eval) {
            this.root = root;
            this.elements = elements;
            this.eval = eval;
        }

        public void head(Node node, int depth) {
            if (node instanceof 元素) {
                元素 el = (元素) node;
                if (eval.matches(root, el))
                    elements.add(el);
            }
        }

        public void tail(Node node, int depth) {
            // void
        }
    }

    public static 元素 findFirst(Evaluator eval, 元素 root) {
        FirstFinder finder = new FirstFinder(root, eval);
        NodeTraversor.filter(finder, root);
        return finder.match;
    }

    private static class FirstFinder implements NodeFilter {
        private final 元素 root;
        private 元素 match = null;
        private final Evaluator eval;

        FirstFinder(元素 root, Evaluator eval) {
            this.root = root;
            this.eval = eval;
        }

        @Override
        public FilterResult head(Node node, int depth) {
            if (node instanceof 元素) {
                元素 el = (元素) node;
                if (eval.matches(root, el)) {
                    match = el;
                    return STOP;
                }
            }
            return CONTINUE;
        }

        @Override
        public FilterResult tail(Node node, int depth) {
            return CONTINUE;
        }
    }

}
