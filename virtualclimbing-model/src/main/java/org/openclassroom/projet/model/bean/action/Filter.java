package org.openclassroom.projet.model.bean.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openclassroom.projet.model.bean.topo.Topo;

public class Filter {

	// ==================== Attributes ====================
    final String[] rangedRoute = {"1 - 9", "10 - 99", "100 - 999", "> 1000"};
    final String[] rangedSector = {"1 - 5", "6 - 10", "11 - 15", "16 - 20", "> 20"};
	
	private int numberOfSite;
    private String numberOfSector;
    private String numberOfRoute;
    
    private List<Integer> listNumberSite = new ArrayList<>();
    private List<String> listNumberSector = new ArrayList<>(Arrays.asList(rangedSector));
    private List<String> listNumberRoute = new ArrayList<>(Arrays.asList(rangedRoute));


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Filter() {
    	for(int i = 1; i <= 50; i++) {
    		listNumberSite.add(i);
    	}
    }


    /**
     * Constructor.
     *
     * @param pNumberOfSite -
     * @param pNumberOfSector -
     * @param pNumberOfRoute -
     */
    public Filter(int pNumberOfSite, String pNumberOfSector, String pNumberOfRoute) {
    	numberOfSite = pNumberOfSite;
    	numberOfSector = pNumberOfSector;
    	numberOfRoute = pNumberOfRoute;
    	
    	for(int i = 1; i <= 50; i++) {
    		listNumberSite.add(i);
    	}
    }


    // ==================== Getters/Setters ====================
    public int getNumberOfSite() {
		return numberOfSite;
	}
    public void setNumberOfSite(int numberOfSite) {
		this.numberOfSite = numberOfSite;
	}
    public String getNumberOfSector() {
		return numberOfSector;
	}
    public void setNumberOfSector(String numberOfSector) {
		this.numberOfSector = numberOfSector;
	}
    public String getNumberOfRoute() {
		return numberOfRoute;
	}
    public void setNumberOfRoute(String numberOfRoute) {
		this.numberOfRoute = numberOfRoute;
	}
    public List<Integer> getListNumberSite() {
		return listNumberSite;
	}
    public void setListNumberSite(List<Integer> listNumberSite) {
		this.listNumberSite = listNumberSite;
	}
    public List<String> getListNumberSector() {
		return listNumberSector;
	}
    public void setListNumberSector(List<String> listNumberSector) {
		this.listNumberSector = listNumberSector;
	}
    public List<String> getListNumberRoute() {
		return listNumberRoute;
	}
    public void setListNumberRoute(List<String> listNumberRoute) {
		this.listNumberRoute = listNumberRoute;
	}


	// ==================== Methods ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        vStB.append(" {")
            .append("").append("")
            .append("}");
        return vStB.toString();
    }
    
    /***/
    public Boolean isInSiteRange(Topo pTopo) {
    	return pTopo.getNumberSite() == numberOfSite || numberOfSite == -1;
    }
    
    /***/
    public Boolean isInSectorRange(int pNumberSector) {
    	switch (numberOfSector) {
    	case "1 - 5":
    		return pNumberSector > 0 && pNumberSector < 6;
    	case "6 - 10":
    		return pNumberSector > 5 && pNumberSector < 11;
    	case "11 - 15":
    		return pNumberSector > 10 && pNumberSector < 16;
    	case "16 - 20":
    		return pNumberSector > 15 && pNumberSector < 21;
    	case "> 20":
    		return pNumberSector > 20;
    	default :
    		return true;
    	}
    }
    
    /***/
    public Boolean isInRouteRange(int pNumberRoute) {
    	switch (numberOfRoute) {
    	case "1 - 9":
    		return pNumberRoute > 0 && pNumberRoute < 10;
    	case "10 - 99":
    		return pNumberRoute > 9 && pNumberRoute < 100;
    	case "100 - 999":
    		return pNumberRoute > 99 && pNumberRoute < 1000;
    	case "> 1000":
    		return pNumberRoute > 999;
    	default :
    		return true;
    	}
    }
}