package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// Ici on met le tag @Root car c'est le premier élément (la racine) du fichier XML
@Root(name="kml")
public class Kml {

    // Le tag Element correspond comme sont nom l'indique à un élément entre crochet ("") dans le fichier XML
    @Element
    private Document Document;

    public Kml() {
        super();
    }

    public Kml(Document Document) {
        super();
        this.Document = Document;
    }

    public Document getDocument() {
        return Document;
    }

    public void setDocument(Document Document) {
        this.Document = Document;
    }
}