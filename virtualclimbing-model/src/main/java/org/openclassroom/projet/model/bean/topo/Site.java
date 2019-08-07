package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Site {

	// ==================== Attributes ====================
    @NotNull
    @Size(min=1, max=100)
    private String name;
    private String imageUrl;
    
    @NotNull
    private float latitude;
    
    @NotNull
    private float longitude;
    
    @NotNull
    @Size(min=1, max=500)
    private String location;
    
    @NotNull
    @Size(min=1, max=500)
    private String access;
    
    @NotNull
    @Size(min=1, max=200)
    private String rockType;
    
    @NotNull
    @Size(min=1, max=200)
    private String profil;
    
    @NotNull
    @Size(min=1, max=100)
    private String anchorage;
    
    @NotNull
    private int maxHeight;
    
    @NotNull
    private int minAltitude;
    
    @NotNull
    @Size(min=1, max=50)
    private String orientation;
    
    @NotNull 
    @Size(min=1, max=1000)
    private String note;    
    
    @NotNull
    private int numberSector;
    


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Site() {
    }


    /**
     * Constructor.
     *
     * @param pName -
     * @param pImageUrl -
     * @param pLatitude -
     * @param pLongitude -
     * @param pLocation -
     * @param pAccess -
     * @param pRockType -
     * @param pProfil -
     * @param pAnchorage -
     * @param pMaxHeight -
     * @param pMinAltitude -
     * @param pOrientation -
     * @param pNote -
     * @param pNumberSector -
     */
    public Site(String pName, String pImageUrl, float pLatitude, float pLongitude, String pLocation, String pAccess, String pRockType, 
    			String pProfil, String pAnchorage, int pMaxHeight, int pMinAltitude, String pOrientation, String pNote, int pNumberSector) {
        name = pName;
        imageUrl = pImageUrl;
        latitude = pLatitude;
        longitude = pLongitude;
        location = pLocation;
        access = pAccess;
        rockType = pRockType;
        profil = pProfil;
        anchorage = pAnchorage;
        maxHeight = pMaxHeight;
        minAltitude = pMinAltitude;
        orientation = pOrientation;
        note = pNote;
        numberSector = pNumberSector;
    }


    // ==================== Getters/Setters ====================
    public String getName() {
        return name;
    }
    public void setName(String pName) {
    	name = pName;
    }
    public String getImageUrl() {
    	return imageUrl;
    }
    public void setImageUrl(String pImageUrl) {
    	imageUrl = pImageUrl;
    }
    public float getLatitude() {
    	return latitude;
    }
    public void setLatitude(float pLatitude) {
    	latitude = pLatitude;
    }
    public float getLongitude() {
    	return longitude;
    }
    public void setLongitude(float pLongitude) {
    	longitude = pLongitude;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String pLocation) {
    	location = pLocation;
    }
    public String getAccess() {
    	return access;
    }
    public void setAccess(String pAccess) {
    	access = pAccess;
    }
    public String getRockType() {
        return rockType;
    }
    public void setRockType(String pRockType) {
    	rockType = pRockType;
    }
    public String getProfil() {
    	return profil;
    }
    public void setProfil(String pProfil) {
    	profil = pProfil;
    }
    public String getAnchorage() {
    	return anchorage;
    }
    public void setAnchorage(String pAnchorage) {
    	anchorage = pAnchorage;
    }
    public int getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(int pMaxHeight) {
    	maxHeight = pMaxHeight;
    }
    public int getMinAltitude() {
    	return minAltitude;
    }
    public void setMinAltitude(int pMinAltitude) {
    	minAltitude = pMinAltitude;
    }
    public String getOrientation() {
    	return orientation;
    }
    public void setOrientation(String pOrientation) {
    	orientation = pOrientation;
    }
    public String getNote() {
    	return note;
    }
    public void setNote(String pNote) {
    	note = pNote;
    }
    public int getNumberSector() {
    	return numberSector;
    }
    public void setNumberSector(int pNumberSector) {
    	numberSector = pNumberSector;
    }
    


    // ==================== Methods ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        vStB.append(" {")
            .append("name=").append(name)
            .append("}");
        return vStB.toString();
    }
	
}