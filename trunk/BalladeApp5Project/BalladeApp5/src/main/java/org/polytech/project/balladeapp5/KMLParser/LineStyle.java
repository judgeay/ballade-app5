package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class LineStyle {

    @Element(required=false)
    private String color;

    @Element(required=false)
    private String width;

    public LineStyle() {
        super();
    }

    public LineStyle(String color, String width) {
        super();
        this.color = color;
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

}