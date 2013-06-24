package org.polytech.project.balladeapp5.KMLParser;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class Folder {
	
	@Element(required=false)
	private String name;
	
	@Element(required=false)
	private String description;
	
	@Element(required=false)
	private LookAt LookAt;
	
	@Element(required=false)
	private boolean visibility;
    
	@Element(required=false)
	private String styleUrl;
	
	@Element(required=false)
	private GroundOverlay GroundOverlay;
	
    @ElementList(entry="ScreenOverlay",inline=true,required=false)
	private List<ScreenOverlay> ScreenOverlay;
    
    @ElementList(entry="Folder", inline=true, required=false)
    private List<Folder> Folders;
	
    public GroundOverlay getGroundOverlay() {
		return GroundOverlay;
	}

	public void setGroundOverlay(GroundOverlay groundOverlay) {
		GroundOverlay = groundOverlay;
	}

	public List<ScreenOverlay> getScreenOverlay() {
		return ScreenOverlay;
	}

	public void setScreenOverlay(List<ScreenOverlay> screenOverlay) {
		ScreenOverlay = screenOverlay;
	}

	public List<Folder> getFolders() {
		return Folders;
	}

	public void setFolders(List<Folder> folder) {
		Folders = folder;
	}

	@ElementList(entry="Document",inline=true,required=false)
	private List<Document> documents;
	
    public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getStyleUrl() {
		return styleUrl;
	}

	public void setStyleUrl(String styleUrl) {
		this.styleUrl = styleUrl;
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

	public LookAt getLookAt() {
		return LookAt;
	}

	public void setLookAt(LookAt lookAt) {
		LookAt = lookAt;
	}

	@ElementList(entry="Placemark",inline=true,required=false)
    private List<Placemark>placemarks;
	
	public List<Placemark> getPlacemarks() {
		return placemarks;
	}

	public void setPlacemarks(List<Placemark> placemarks) {
		this.placemarks = placemarks;
	}
	
	public Folder()
	{
		super();
	}

	public List<String> getAllCoordinates()
	{
		List<String> returnList = new ArrayList<String>();
		
		if(getPlacemarks() != null)
			for(Placemark plcmk : getPlacemarks())
			{
				if(plcmk.getAllCoordinates() != null)	
					returnList.addAll(plcmk.getAllCoordinates());
			}
		
		if(getDocuments() != null)
		{
			for(Document doc : getDocuments())
			{
				if(doc.getAllCoordinates() != null)
					returnList.addAll(doc.getAllCoordinates());
			}
		}
		
		return returnList;
	}
	
	public Folder(String name, String description, LookAt lookAt, List<Placemark> placemarks)
	{
		super();
		this.name = name;
		this.description = description;
		this.LookAt = lookAt;
		this.placemarks = placemarks;
	}
}
