package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;

public class Site {

	// ==================== Attributes ====================
    @NotNull
    private String name;
    
    @NotNull
    private String equipment;
    
    @NotNull
    private int numberRoute;
    
    @NotNull
    private int maxHeight;
    
    @NotNull
    private String rockType;
    
    @NotNull
    private String location;


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
     * @param pEquipment -
     * @param pNumberRoute -
     * @param pMaxHeight -
     * @param pRockType -
     * @param pLocation -
     */
    public Site(String pName, String pEquipment, int pNumberRoute, int pMaxHeight, String pRockType, String pLocation) {
        name = pName;
        equipment = pEquipment;
        numberRoute = pNumberRoute;
        maxHeight = pMaxHeight;
        rockType = pRockType;
        location = pLocation;    
    }


    // ==================== Getters/Setters ====================
    public String getName() {
        return name;
    }
    public void setName(String pName) {
    	name = pName;
    }
    public String getEquipment() {
        return equipment;
    }
    public void setEquipment(String pEquipment) {
    	equipment = pEquipment;
    }
    public int getNumberRoute() {
        return numberRoute;
    }
    public void setNumberRoute(int pNumberRoute) {
    	numberRoute = pNumberRoute;
    }
    public int getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(int pMaxHeight) {
    	maxHeight = pMaxHeight;
    }
    public String getRockType() {
        return rockType;
    }
    public void setRockType(String pRockType) {
    	rockType = pRockType;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String pLocation) {
    	location = pLocation;
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