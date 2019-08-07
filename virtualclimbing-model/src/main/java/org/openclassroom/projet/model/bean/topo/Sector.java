package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Sector {

	// ==================== Attributes ====================
    @NotNull
    @Size(min=1, max=100)
    private String name;
    
    @NotNull
    private Site site;
    
    @NotNull
    private String imageUrl;
    
    @NotNull
    private int numberRoute;


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
     * @param pNumberRoute -
     */
    public Sector(String pName, Site pSite, String pImageUrl, int pNumberRoute) {
        name = pName;
        site = pSite;
        imageUrl = pImageUrl;  
        numberRoute = pNumberRoute;
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
    public int getNumberRoute() {
        return numberRoute;
    }
    public void setNumberRoute(int pNumberRoute) {
    	numberRoute = pNumberRoute;
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