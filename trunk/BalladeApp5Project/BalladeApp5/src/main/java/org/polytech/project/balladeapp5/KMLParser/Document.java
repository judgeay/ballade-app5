package org.polytech.project.balladeapp5.KMLParser;

/**
 * Created by remipraud on 18/06/13.
 */

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class Document {

    // Le tag ElementList permet de définir une liste d'éléments
    // Ensuite on a des attributs: entry permet de définir à quelle élément fait référence la liste,
    // inline permet créer une liste avec des éléments qui ne sont pas exclusivement entre balises.
    // C'est à dire que ces éléments sont mêlés avec d'autre éléments entre les mêmes balises.
    // l'attribut required quant à lui permet de définir si l'élément est obligatoire ou pas
    @ElementList(entry="Placemark",inline=true,required=false)
    private List<Placemark>placemarks;

    @Element(required=false)
    private String name;

    @ElementList(entry="Style",inline=true,required=false)
    private List<Style> styles;
    
    @Element(required=false)
    private String open;

    @Element(required=false)
    private String description;
    
    @Element(required=false)
    private boolean visibility;
    
    @Element(required=false)
    private LookAt LookAt;
    
    @Element(required=false)
    private StyleMap StyleMap;
    
    public StyleMap getStyleMap() {
		return StyleMap;
	}

	public void setStyleMap(StyleMap styleMap) {
		StyleMap = styleMap;
	}

	public LookAt getLookAt() {
		return LookAt;
	}

	public void setLookAt(LookAt lookAt) {
		this.LookAt = lookAt;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	// L'attribut data permet de signaler que l'élément contient une section ( <!--[CDATA[ )
    @Element(data=true,required=false)
    private String Snippet;
    
    @ElementList(entry="Folder",inline=true,required=false)
    private List<Folder> folders;

    public List<Style> getStyles() {
		return styles;
	}

	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Style> getStyle() {
        return styles;
    }

    public void setStyle(List<Style> styles) {
        this.styles = styles;
    }

    public String getSnippet() {
        return Snippet;
    }

    public void setSnippet(String snippet) {
        this.Snippet = snippet;
    }

    public List<Placemark> getPlacemarks() {
        return placemarks;
    }

    public void setPlacemarks(List<Placemark>placemarks) {
        this.placemarks = placemarks;
    }
    
    public List<String> getAllCoordinates()
    {
    	List<String> finalList = new ArrayList<String>();
    	
    	if(getFolders() != null)
    	{
    		for(Folder test : getFolders())
    		{
    			if(test.getPlacemarks() != null)
    			{
    				for(Placemark crtplcmk : test.getPlacemarks())
    				{
    					if(crtplcmk.getAllCoordinates() != null)
    						finalList.addAll(crtplcmk.getAllCoordinates());
    				}
    			}
    		
    			if(test.getDocuments() != null)
    			{
    				for(Document doc : test.getDocuments())
    				{
    					if(doc.getAllCoordinates() != null)
    						finalList.addAll(doc.getAllCoordinates());
    				}
    			}
    		
    			if(test.getFolders() != null)
    			{
    				for(Folder fld : test.getFolders())
    				{
    					if(fld.getAllCoordinates() != null)
    						finalList.addAll(fld.getAllCoordinates());
    				}
    			}
    		}
    	}
    	
    	if(getPlacemarks() != null)
    	{
    		for(Placemark plcmk : getPlacemarks())
    		{
    			if(plcmk.getAllCoordinates() != null)
    				finalList.addAll(plcmk.getAllCoordinates());
    		}
    	}
    	    	
    	return finalList;
    }
}