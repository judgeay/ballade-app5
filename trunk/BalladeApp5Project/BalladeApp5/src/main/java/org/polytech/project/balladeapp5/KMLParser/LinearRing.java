package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element;

public class LinearRing {

	@Element(required=false)
	private String coordinates;
	
	public LinearRing()
	{
		super();
	}
	
	public LinearRing(String coordi)
	{
		super();
		this.coordinates = coordi;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
}
