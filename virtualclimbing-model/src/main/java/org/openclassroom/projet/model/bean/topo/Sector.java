package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;

public class Sector {

	// ==================== Attributes ====================
    @NotNull
    private String name;
    
    @NotNull
    private Site site;
    
    @NotNull
    private String imageUrl;


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Sector() {
    }


    /**
     * Constructor.
     *
     * @param pName -
     * @param pSite -
     * @param pImageUrl -
     */
    public Sector(String pName, Site pSite, String pImageUrl) {
        name = pName;
        site = pSite;
        imageUrl = pImageUrl;    
    }


    // ==================== Getters/Setters ====================
    public String getName() {
        return name;
    }
    public void setName(String pName) {
    	name = pName;
    }
    public Site getSite() {
        return site;
    }
    public void setSite(Site pSite) {
    	site = pSite;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String pImageUrl) {
    	imageUrl = pImageUrl;
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