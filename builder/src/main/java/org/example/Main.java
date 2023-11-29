package org.example;

import org.example.initial.Director;
import org.example.initial.HtmlDocumentBuilder;
import org.example.updated.HtmlElement;
import org.example.updated.HtmlBuilder;

public class Main {
    public static void main(String[] args) {
        // INITIAL IMPLEMENTATION
        final var director = new Director();
        director.buildGoodbyePage(new HtmlDocumentBuilder());

        // EXAMPLE OF COMPLEX OBJECT CREATION
        System.out.println("<==== WITHOUT BUILDER ===>");
        HtmlElement e = new HtmlElement("ul");
        e.getChildren().add(new HtmlElement("li", "item1"));
        e.getChildren().add(new HtmlElement("li", "item2"));
        e.getChildren().add(new HtmlElement("li", "item3"));
        System.out.println(e);

        // CREATE BUILDER
        // - APPLY SRP
        // - FACILITATE TO THE CLIENT TO CREATE AN HTML ELEMENT
        System.out.println("<==== WITH BUILDER ===>");
        HtmlBuilder builder1 = new HtmlBuilder("ul");
        builder1.addChild("li", "item1");
        builder1.addChild("li", "item2");
        builder1.addChild("li", "item3");
        System.out.println(builder1);

        // CREATE FLUENT BUILDER
        System.out.println("<==== WITH FLUENT BUILDER ===>");
        HtmlBuilder builder2 = new HtmlBuilder("ul")
                .add("li", "item1")
                .add("li", "item2")
                .add("li", "item3");
        System.out.println(builder2);
    }
}