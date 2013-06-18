package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class IconStyle {

    @Element(required=false)
    private Icon Icon;

    @Element(required=false)
    private HotSpot hotSpot;

    @Element(required=false)
    private double scale;

    public IconStyle() {
        super();
    }

    public IconStyle(Icon icon, HotSpot hotSpot, double scale) {
        super();
        this.Icon = icon;
        this.hotSpot = hotSpot;
        this.scale = scale;
    }

    public Icon getIcon() {
        return Icon;
    }

    public void setIcon(Icon icon) {
        this.Icon = icon;
    }

    public HotSpot getHotSpot() {
        return hotSpot;
    }

    public void setHotSpot(HotSpot hotSpot) {
        this.hotSpot = hotSpot;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}