package org.openclassroom.projet.model.bean.action;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.user.User;

public class Comment {

	// ==================== Attributes ====================    
    @NotNull
    @Size(min=1)
    private String title;
    
    @NotNull
    @Size(min=1)
    private String description;
    
    @NotNull
    private User user;
    
    @NotNull
    private Sector sector;


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Comment() {
    }


    /**
     * Constructor.
     *
     * @param pTitle -
     * @param pDescription -
     * @param pUser -
     * @param pTopo -
     * @param pSite -
     * @param pSector -
     */
    public Comment(String pTitle, String pDescription, User pUser, Sector pSector) {
        title = pTitle;
        description = pDescription;
        user = pUser;
        sector = pSector;
    }


    // ==================== Getters/Setters ====================
    public String getTitle() {
        return title;
    }
    public void setTitle(String pTitle) {
    	title = pTitle;
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
    public Sector getSector() {
        return sector;
    }
    public void setSector(Sector pSector) {
    	sector = pSector;
    }


    // ==================== Methods ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        vStB.append(" {")
            .append("title=").append(title)
            .append("}");
        return vStB.toString();
    }
	
}