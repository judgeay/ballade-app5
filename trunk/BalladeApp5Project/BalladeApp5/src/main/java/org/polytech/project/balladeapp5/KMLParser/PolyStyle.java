package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element;

public class PolyStyle {

	@Element(required=false)
    private String color;

    public PolyStyle() {
        super();
    }

    public PolyStyle(String color) {
        super();
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
