package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class Point {

    @Element
    private String coordinates;
    
    @Element(required=false)
    private String altitudeMode;
    
    @Element(required=false)
    private boolean extrude;

    public boolean isExtrude() {
		return extrude;
	}

	public void setExtrude(boolean extrude) {
		this.extrude = extrude;
	}

	public Point() {
        super();
    }

    public Point(String coordinates, String altMode) {
        super();
        this.coordinates = coordinates;
        this.altitudeMode = altMode;
    }

    public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}

	public String getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}