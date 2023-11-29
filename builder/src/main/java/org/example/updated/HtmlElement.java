package org.example.updated;

import java.util.ArrayList;
import java.util.List;

public class HtmlElement {

    private String tag;
    private final String text;
    private final List<HtmlElement> children;

    public HtmlElement(String tag, String text) {
        this.tag = tag;
        this.text = text;
        this.children = new ArrayList<>();
    }

    private void setTag(String tag) {
        this.tag = tag;
    }

    public HtmlElement(String tag) {
        this(tag, null);
    }

    // THIS METHOD COULD BE IMMUTABLE AND ONLY THE BUILDER CLASS COULD CHANGE
    // THE VALUE OF CHILDREN
    public List<HtmlElement> getChildren() {
//        return Collections.unmodifiableList(children);
        return children;
    }
    
    private void renderText(int indent, StringBuilder sb) {
        String indentation = " ".repeat(2 * indent);
        sb.append(String.format("%s<%s>%n", indentation, tag));

        if (text != null && !text.trim().isEmpty()) {
            sb.append(indentation).append(" ").append(text).append("\n");
        }

        for (HtmlElement child : children) {
            child.renderText(indent + 1, sb);
            sb.append("\n");
        }

        sb.append(String.format("%s</%s>", indentation, tag));
    }

    public static class Builder {

        private final HtmlElement result = new HtmlElement("");

        public Builder(String rootTag) {
            result.setTag(rootTag);
        }

        public Builder add(String childTag, String childText) {
            var e = new HtmlElement(childTag, childText);
            result.children.add(e);
            return this;
        }

        public static Builder create(String rootTag) {
            return new Builder(rootTag);
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        renderText(0, sb);
        return sb.toString();
    }
}
