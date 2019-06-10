package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;

import org.openclassroom.projet.model.bean.user.User;

public class Topo {

	// ==================== Attributes ====================
    @NotNull
    private String name;
    private String officialWebSite;
    
    @NotNull
    private String description;
    
    @NotNull
    private User user;


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
     */
    public Topo(String pName, String pOfficialWebSite, String pDescription, User pUser) {
        name = pName;
        officialWebSite = pOfficialWebSite;
        description = pDescription;
        user = pUser;
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