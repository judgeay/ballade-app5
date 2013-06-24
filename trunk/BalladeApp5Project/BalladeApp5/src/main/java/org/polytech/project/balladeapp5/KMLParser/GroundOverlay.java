package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element; 

public class GroundOverlay 
{
	@Element(required=false)
	private String name;
	
	@Element(required=false)
    private boolean visibility;
	
	@Element(required=false)
    private String description;
    
	@Element(required=false)
    private LookAt LookAt;
    
	@Element(required=false)
    private Icon Icon;
    
	@Element(required=false)
    private LatLonBox LatLonBox;
    
	public GroundOverlay()
	{
		super();
	}
}
