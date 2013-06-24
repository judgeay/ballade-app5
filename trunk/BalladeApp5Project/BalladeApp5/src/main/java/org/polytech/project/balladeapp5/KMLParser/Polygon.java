package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Element;

public class Polygon {
	
	@Element(required=false)
	private boolean extrude;
	
	@Element(required=false)
    private String altitudeMode;
    
	@Element(required=false)
    private outerBoundaryIs outerBoundaryIs;
	
	@Element(required=false)
    private innerBoundaryIs innerBoundaryIs;
	
	@Element(required=false)
	private boolean tessellate;
	
	public innerBoundaryIs getInnerBoundaryIs() {
		return innerBoundaryIs;
	}

	public void setInnerBoundaryIs(innerBoundaryIs innerBoundaryIs) {
		this.innerBoundaryIs = innerBoundaryIs;
	}

	public boolean isTessellate() {
		return tessellate;
	}

	public void setTessellate(boolean tessellate) {
		this.tessellate = tessellate;
	}

	public Polygon()
	{
		super();
	}
	
	public Polygon(boolean ext, String alt, outerBoundaryIs is)
	{
		super();
		this.extrude = ext;
		this.altitudeMode = alt;
		this.outerBoundaryIs = is;
	}

	public boolean isExtrude() {
		return extrude;
	}

	public void setExtrude(boolean extrude) {
		this.extrude = extrude;
	}

	public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}

	public outerBoundaryIs getOuterBoundaryIs() {
		return outerBoundaryIs;
	}

	public void setOuterBoundaryIs(outerBoundaryIs outerBoundaryIs) {
		this.outerBoundaryIs = outerBoundaryIs;
	}

}
