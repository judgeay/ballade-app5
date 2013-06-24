package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class LineString {

    @Element(required=false)
    private String coordinates;

    @Element(required=false)
    private boolean tessellate;
    
    @Element(required=false)
    private boolean extrude;
    
    public boolean isExtrude() {
		return extrude;
	}

	public void setExtrude(boolean extrude) {
		this.extrude = extrude;
	}

	@Element(required=false)
    private String altitudeMode;
    
    public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}

	public LineString() {
        super();
    }

    public boolean isTessellate() {
		return tessellate;
	}

	public void setTessellate(boolean tessellate) {
		this.tessellate = tessellate;
	}

	public LineString(String coordinates) {
        super();
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

}