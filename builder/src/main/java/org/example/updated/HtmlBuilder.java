package org.example.updated;

public class HtmlBuilder {

    private final HtmlElement result = new HtmlElement("");

    public HtmlBuilder(String rootTag) {
        result.setTag(rootTag);
    }

    public void addChild(String childTag, String childText) {
        var e = new HtmlElement(childTag, childText);
        result.getChildren().add(e);
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
