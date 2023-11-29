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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public HtmlElement(String tag) {
        this(tag, null);
    }

    public List<HtmlElement> getChildren() {
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

    @Override
    public String toString() {
        var sb = new StringBuilder();
        renderText(0, sb);
        return sb.toString();
    }
}
