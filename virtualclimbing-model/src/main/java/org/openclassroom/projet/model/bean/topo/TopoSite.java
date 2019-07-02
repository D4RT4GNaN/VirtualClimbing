package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;

public class TopoSite {
	
	// ==================== Attributes ====================
    @NotNull
    private String nameTopo;
    
    @NotNull
    private String nameSite;



    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public TopoSite() {
    }


    /**
     * Constructor.
     *
     * @param pNameTopo -
     * @param pNameSite -
     */
    public TopoSite(String pNameTopo, String pNameSite) {
        nameTopo = pNameTopo;
        nameSite = pNameSite;
    }


    // ==================== Getters/Setters ====================
    public String getNameTopo() {
        return nameTopo;
    }
    public void setName(String pNameTopo) {
    	nameTopo = pNameTopo;
    }
    public String getNameSite() {
        return nameSite;
    }
    public void setNameSite(String pNameSite) {
    	nameSite = pNameSite;
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
