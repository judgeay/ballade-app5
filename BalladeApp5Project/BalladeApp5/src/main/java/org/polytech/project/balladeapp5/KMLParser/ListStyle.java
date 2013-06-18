package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class ListStyle {

    @Element(required=false)
    private ItemIcon ItemIcon;

    public ListStyle() {
        super();
    }

    public ListStyle(ItemIcon itemIcon) {
        super();
        ItemIcon = itemIcon;
    }

    public ItemIcon getItemIcon() {
        return ItemIcon;
    }

    public void setItemIcon(ItemIcon itemIcon) {
        ItemIcon = itemIcon;
    }

}