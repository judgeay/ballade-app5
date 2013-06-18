package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class Document {

    // Le tag ElementList permet de définir une liste d'éléments
    // Ensuite on a des attributs: entry permet de définir à quelle élément fait référence la liste,
    // inline permet créer une liste avec des éléments qui ne sont pas exclusivement entre balises.
    // C'est à dire que ces éléments sont mêlés avec d'autre éléments entre les mêmes balises.
    // l'attribut required quant à lui permet de définir si l'élément est obligatoire ou pas
    @ElementList(entry="Placemark",inline=true,required=false)
    private List<Placemark>placemarks;

    @Element(required=false)
    private String name;

    @Element(required=false)
    private Style Style;

    // L'attribut data permet de signaler que l'élément contient une section ( <!--[CDATA[ )
    @Element(data=true,required=false)
    private String Snippet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Style getStyle() {
        return Style;
    }

    public void setStyle(Style style) {
        this.Style = style;
    }

    public String getSnippet() {
        return Snippet;
    }

    public void setSnippet(String snippet) {
        this.Snippet = snippet;
    }

    public List<Placemark> getPlacemarks() {
        return placemarks;
    }

    public void setPlacemarks(List<Placemark>placemarks) {
        this.placemarks = placemarks;
    }
}