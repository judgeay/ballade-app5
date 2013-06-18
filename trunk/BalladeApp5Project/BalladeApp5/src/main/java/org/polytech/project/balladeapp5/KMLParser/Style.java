package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Style {

    @Attribute(required=false)
    private String id;

    @Element(required=false)
    private LineStyle LineStyle;

    @Element(required=false)
    private IconStyle IconStyle;

    @Element(required=false)
    private ListStyle ListStyle;

    public Style() {
        super();
    }

    public Style(String id, LineStyle linestyle, IconStyle iconStyle,
                 ListStyle listStyle) {
        super();
        this.id = id;
        LineStyle = linestyle;
        this.IconStyle = iconStyle;
        ListStyle = listStyle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LineStyle getLinestyle() {
        return LineStyle;
    }

    public void setLinestyle(LineStyle linestyle) {
        this.LineStyle = linestyle;
    }

    public IconStyle getIconStyle() {
        return IconStyle;
    }

    public void setIconStyle(IconStyle iconStyle) {
        this.IconStyle = iconStyle;
    }

    public ListStyle getListStyle() {
        return ListStyle;
    }

    public void setListStyle(ListStyle listStyle) {
        ListStyle = listStyle;
    }

}