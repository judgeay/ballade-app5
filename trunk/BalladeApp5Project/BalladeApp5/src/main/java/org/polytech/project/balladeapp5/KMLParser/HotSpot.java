package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Attribute;

public class HotSpot {

    @Attribute
    private double x;

    @Attribute
    private double y;

    @Attribute
    private String xunits;

    @Attribute
    private String yunits;

    public HotSpot() {
        super();
    }

    public HotSpot(double x, double y, String xunits, String yunits) {
        super();
        this.x = x;
        this.y = y;
        this.xunits = xunits;
        this.yunits = yunits;
    }

}