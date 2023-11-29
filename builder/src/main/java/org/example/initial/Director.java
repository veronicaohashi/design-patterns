package org.example.initial;

public class Director {

    public void buildWelcomePage(IDocumentBuilder builder) {
        builder
                .writeTitle("Welcome")
                .writeParagraph("This is the welcome page")
                .build();
    }

    public void buildGoodbyePage(IDocumentBuilder builder) {
        builder
                .writeTitle("Goodbye")
                .writeParagraph("This is the goodbye page")
                .build();
    }
}
