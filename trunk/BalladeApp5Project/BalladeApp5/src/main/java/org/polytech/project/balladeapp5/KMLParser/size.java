package org.polytech.project.balladeapp5.KMLParser;

import org.simpleframework.xml.Attribute;

public class size {
	
	@Attribute(required=false)
	private float x;

	@Attribute(required=false)
	private float y;
	
	@Attribute(required=false)
	private String xunits;

	@Attribute(required=false)
	private String yunits;
	
	public size()
	{
		super();
	}
	
	public size(float x, float y, String xu, String yu)
	{
		super();
		this.x = x;
		this.y = y;
		this.xunits = xu;
		this.yunits = yu;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getXunits() {
		return xunits;
	}

	public void setXunits(String xunits) {
		this.xunits = xunits;
	}

	public String getYunits() {
		return yunits;
	}

	public void setYunits(String yunits) {
		this.yunits = yunits;
	}

}
