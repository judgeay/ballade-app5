package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import org.simpleframework.xml.Element;

public class LookAt {

    @Element
    private double longitude;

    @Element
    private double latitude;

    @Element(required=false)
    private double range;

    @Element(required=false)
    private double tilt;

    @Element(required=false)
    private double heading;

    public LookAt() {
        super();
    }

    public LookAt(double longitude, double latitude, double range, double tilt,
                  double heading) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
        this.range = range;
        this.tilt = tilt;
        this.heading = heading;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getTilt() {
        return tilt;
    }

    public void setTilt(double tilt) {
        this.tilt = tilt;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }
}