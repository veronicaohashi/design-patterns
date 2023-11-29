package org.example.initial;

interface IDocumentBuilder {

    IDocumentBuilder writeTitle(String text);

    IDocumentBuilder writeParagraph(String text);

    void build();
}
