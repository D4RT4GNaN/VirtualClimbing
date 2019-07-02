package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;

public class TopoSite {
	
	// ==================== Attributes ====================
    @NotNull
    private Topo topo;
    
    @NotNull
    private Site site;



    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public TopoSite() {
    }


    /**
     * Constructor.
     *
     * @param pTopo -
     * @param pSite -
     */
    public TopoSite(Topo pTopo, Site pSite) {
        topo = pTopo;
        site = pSite;
    }


    // ==================== Getters/Setters ====================
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo pTopo) {
    	topo = pTopo;
    }
    public Site getSite() {
        return site;
    }
    public void setSite(Site pSite) {
    	site = pSite;
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
