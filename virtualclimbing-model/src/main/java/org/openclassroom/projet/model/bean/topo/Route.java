package org.openclassroom.projet.model.bean.topo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Route {

	// ==================== Attributes ====================
    @NotNull
    @Size(min=1, max=100)
    private String name;
    
    @NotNull
    @Size(min=1, max=10)
    private String grade;
    
    @NotNull
    private Integer height;
    
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
    public Route(String pName, String pGrade, Integer pHeight, String pNote, Sector pSector) {
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
    public Integer getHeight() {
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