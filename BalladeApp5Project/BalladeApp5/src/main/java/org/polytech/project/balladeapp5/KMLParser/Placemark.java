package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Placemark {

	@Element(required = false)
	private String name;

	@Element(data = true, required = false)
	private String description;

	@Element(required = false)
	private String address;

	// Ici nous n'avons pas besoin de l'attribut inline car les éléments ne
	// sont pas mêlés à d'autres
	@ElementList(required = false)
	private List<StyleMap> styleMaps;

	@Element(required = false)
	private Point Point;

	@Element(required = false)
	private LookAt LookAt;

	@Element(required = false)
	private GeometryCollection GeometryCollection;

	@Element(required = false)
	private String styleUrl;

	@Element(required = false)
	private boolean visibility;

	@Element(required = false)
	private LineString LineString;

	@Element(required = false)
	private Polygon Polygon;

	public LineString getLineString() {
		return LineString;
	}

	public void setLineString(LineString lineString) {
		LineString = lineString;
	}

	public List<StyleMap> getStyleMaps() {
		return styleMaps;
	}

	public void setStyleMaps(List<StyleMap> styleMaps) {
		this.styleMaps = styleMaps;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<StyleMap> getStyleMap() {
		return styleMaps;
	}

	public void setStyleMap(List<StyleMap> styleMap) {
		this.styleMaps = styleMap;
	}

	public Point getPoint() {
		return Point;
	}

	public void setPoint(Point point) {
		this.Point = point;
	}

	public LookAt getLookAt() {
		return LookAt;
	}

	public void setLookAt(LookAt lookAt) {
		this.LookAt = lookAt;
	}

	public GeometryCollection getGeometryCollection() {
		return GeometryCollection;
	}

	public void setGeometryCollection(GeometryCollection geometryCollection) {
		GeometryCollection = geometryCollection;
	}

	public String getStyleUrl() {
		return styleUrl;
	}

	public void setStyleUrl(String styleUrl) {
		this.styleUrl = styleUrl;
	}

	public List<String> getAllCoordinates() 
	{
		List<String> returnList = new ArrayList<String>();

		if (getPoint() != null)
			if (getPoint().getCoordinates() != null)
				returnList.add(getPoint().getCoordinates());

		if (getPolygon() != null)
			if (getPolygon().getOuterBoundaryIs() != null)
				if (getPolygon().getOuterBoundaryIs().getLinearRing() != null)
					if (getPolygon().getOuterBoundaryIs().getLinearRing().getCoordinates() != null)
						returnList.add(getPolygon().getOuterBoundaryIs().getLinearRing().getCoordinates());

		if (getPolygon() != null)
			if (getPolygon().getInnerBoundaryIs() != null)
				if (getPolygon().getInnerBoundaryIs().getLinearRing() != null)
					if (getPolygon().getInnerBoundaryIs().getLinearRing().getCoordinates() != null)
						returnList.add(getPolygon().getInnerBoundaryIs().getLinearRing().getCoordinates());

		if (getLineString() != null)
			if (getLineString().getCoordinates() != null)
				returnList.add(getLineString().getCoordinates());

		return returnList;
	}

	public Polygon getPolygon() {
		return Polygon;
	}

	public void setPolygon(Polygon polygon) {
		Polygon = polygon;
	}
}