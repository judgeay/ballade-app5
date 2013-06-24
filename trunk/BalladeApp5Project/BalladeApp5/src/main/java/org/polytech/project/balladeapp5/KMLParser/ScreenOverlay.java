package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element;

public class ScreenOverlay 
{
	@Element(required=false)
    private String name;
	
	@Element(required=false)
    private boolean visibility;
	
	@Element(required=false)
    private String description;
	
	@Element(required=false)
    private Icon Icon;
	
	@Element(required=false)
    private overlayXY overlayXY; // x="0.5" y="0.5" xunits="fraction" yunits="fraction"/>
	
	@Element(required=false)
    private screenXY screenXY; // x="0.5" y="0.5" xunits="fraction" yunits="fraction"/>
	
	@Element(required=false)
    private rotationXY rotationXY; // x="0.5" y="0.5" xunits="fraction" yunits="fraction"/>
	
	@Element(required=false)
    private size size; // x="0" y="0" xunits="pixels" yunits="pixels"/>
}
