package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element;

public class innerBoundaryIs {

	@Element(required=false)
    private LinearRing LinearRing;
	
	public innerBoundaryIs()
	{
		super();
	}
	
	public innerBoundaryIs(LinearRing ring)
	{
		super();
		this.LinearRing = ring;
	}

	public LinearRing getLinearRing() {
		return LinearRing;
	}

	public void setLinearRing(LinearRing linearRing) {
		LinearRing = linearRing;
	}
}
