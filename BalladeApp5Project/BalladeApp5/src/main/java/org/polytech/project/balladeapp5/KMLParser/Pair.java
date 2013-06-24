package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class Pair {
    @Element(required=false)
    private String key;

    @Element(required=false)
    private String styleUrl;

    public Pair() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStyle() {
        return styleUrl;
    }

    public void setStyle(String style) {
        this.styleUrl = style;
    }
}