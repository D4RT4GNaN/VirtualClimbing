package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;

public class Route {

	// ==================== Attributes ====================
    @NotNull
    private String name;
    
    @NotNull
    private String grade;
    
    @NotNull
    private int height;
    private String note;
    
    @NotNull
    private Sector sector;


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Route() {
    }


    /**
     * Constructor.
     *
     * @param pName -
     * @param pGrade -
     * @param pHeight -
     * @param pNote -
     * @param pSector -
     */
    public Route(String pName, String pGrade, int pHeight, String pNote, Sector pSector) {
        name = pName;
        grade = pGrade;
        height = pHeight;
        note = pNote;
        sector = pSector;  
    }


    // ==================== Getters/Setters ====================
    public String getName() {
        return name;
    }
    public void setName(String pName) {
    	name = pName;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String pGrade) {
    	grade = pGrade;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int pHeight) {
    	height = pHeight;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String pNote) {
    	note = pNote;
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
            .append("name=").append(name)
            .append("}");
        return vStB.toString();
    }
	
}