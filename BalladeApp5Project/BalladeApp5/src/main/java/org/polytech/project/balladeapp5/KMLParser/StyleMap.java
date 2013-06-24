package org.polytech.project.balladeapp5.KMLParser;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

public class StyleMap 
{
    @ElementList(entry="Pair",inline=true,required=false)
	private List<Pair> pairs;
	
	@Attribute(required=false)
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StyleMap()
	{
		super();
	}
	
	public StyleMap(List<Pair> pairs)
	{
		super();
		this.pairs = pairs;
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public void setPairs(List<Pair> pairs) {
		this.pairs = pairs;
	}
}
