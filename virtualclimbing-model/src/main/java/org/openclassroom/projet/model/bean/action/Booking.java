package org.openclassroom.projet.model.bean.action;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;

public class Booking {

	// ==================== Attributes ====================
    @NotNull
    private Date startDate;
    
    @NotNull
    private Date endDate;
    
    @NotNull
    private Topo topo;
    
    @NotNull
    private User user;


    // ==================== Constructors ====================
    /**
     * Constructor.
     */
    public Booking() {
    }


    /**
     * Constructor.
     *
     * @param pStartDate -
     * @param pEndDate -
     * @param pTopo -
     * @param pUser -
     */
    public Booking(Date pStartDate, Date pEndDate, Topo pTopo, User pUser) {
        startDate = pStartDate;
        endDate = pEndDate;
        topo = pTopo;
        user = pUser;  
    }


    // ==================== Getters/Setters ====================
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date pStartDate) {
    	startDate = pStartDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date pEndDate) {
    	endDate = pEndDate;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo pTopo) {
    	topo = pTopo;
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