package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class Pair {
    @Element
    private String key;

    @Element
    private Style Style;

    public Pair() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Style getStyle() {
        return Style;
    }

    public void setStyle(Style style) {
        this.Style = style;
    }
}