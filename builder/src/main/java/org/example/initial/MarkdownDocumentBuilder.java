package org.example.initial;

public class MarkdownDocumentBuilder implements IDocumentBuilder {
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public IDocumentBuilder writeTitle(String text) {
        stringBuilder.append("\n#");
        stringBuilder.append(text);
        return this;
    }

    @Override
    public IDocumentBuilder writeParagraph(String text) {
        stringBuilder.append("\n");
        stringBuilder.append(text);
        return this;
    }

    @Override
    public void build() {
        System.out.println(stringBuilder);
    }
}
