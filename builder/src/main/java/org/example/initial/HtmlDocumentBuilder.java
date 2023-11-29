package org.example.initial;

public class HtmlDocumentBuilder implements IDocumentBuilder {

    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public IDocumentBuilder writeTitle(String text) {
        stringBuilder.append("<h1>");
        stringBuilder.append(text);
        stringBuilder.append("</h1>");
        return this;
    }

    @Override
    public IDocumentBuilder writeParagraph(String text) {
        stringBuilder.append("<p>");
        stringBuilder.append(text);
        stringBuilder.append("</p>");
        return this;
    }

    @Override
    public void build() {
        System.out.println(stringBuilder);
    }
}
