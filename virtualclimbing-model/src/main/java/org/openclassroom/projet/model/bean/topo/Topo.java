package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.openclassroom.projet.model.bean.user.User;

public class Topo {

	// ==================== Attributes ====================
    @NotNull
    @Size(min=1, max=100)
    private String name;
    
    private String officialWebSite;
    
    @NotNull
    @Size(min=1, max=1000)
    private String description;
    
    @NotNull
    private User user;
    
    private String imageUrl;
    
    @NotNull
    private Boolean privateTopo;


    
    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Topo() {
    }


    /**
     * Constructor.
     *
     * @param pName -
     * @param pOfficialWebSite -
     * @param pDescrition -
     * @param pUser -
     * @param pImageUrl -
     * @param pPrivateTopo -
     */
    public Topo(String pName, String pOfficialWebSite, String pDescription, User pUser, String pImageUrl, Boolean pPrivateTopo) {
        name = pName;
        officialWebSite = pOfficialWebSite;
        description = pDescription;
        user = pUser;
        imageUrl = pImageUrl;
        privateTopo = pPrivateTopo;
    }


    // ==================== Getters/Setters ====================
    public String getName() {
        return name;
    }
    public void setName(String pName) {
    	name = pName;
    }
    public String getOfficialWebSite() {
        return officialWebSite;
    }
    public void setOfficialWebSite(String pOfficialWebSite) {
    	officialWebSite = pOfficialWebSite;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String pDescription) {
    	description = pDescription;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User pUser) {
        user = pUser;
    }
    public String getImageUrl() {
    	return imageUrl;
    }
    public void setImageUrl(String pImageUrl) {
    	imageUrl = pImageUrl;
    }
    public Boolean getPrivateTopo() {
		return privateTopo;
	}
	public void setPrivateTopo(Boolean privateTopo) {
		this.privateTopo = privateTopo;
	}

	

	// ==================== Methods ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        vStB.append(" {")
            .append("pseudo=").append("")
            .append("}");
        return vStB.toString();
    }
	
}