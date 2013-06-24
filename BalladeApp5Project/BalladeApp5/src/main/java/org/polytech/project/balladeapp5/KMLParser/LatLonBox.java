package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element;

public class LatLonBox {

	@Element(required=false)
	private float north;
	
	@Element(required=false)
	private float south;
	
	@Element(required=false)
    private float east;
	
	@Element(required=false)
    private float west;
	
	@Element(required=false)
    private float rotation;
	
	public LatLonBox()
	{
		super();
	}
	
	public LatLonBox(float N, float S, float E, float W, float R)
	{
		super();
		this.north = N;
		this.south = S;
		this.east = E;
		this.west = W;
		this.rotation = R;
	}

	public float getNorth() {
		return north;
	}

	public void setNorth(float north) {
		this.north = north;
	}

	public float getSouth() {
		return south;
	}

	public void setSouth(float south) {
		this.south = south;
	}

	public float getEast() {
		return east;
	}

	public void setEast(float east) {
		this.east = east;
	}

	public float getWest() {
		return west;
	}

	public void setWest(float west) {
		this.west = west;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}
