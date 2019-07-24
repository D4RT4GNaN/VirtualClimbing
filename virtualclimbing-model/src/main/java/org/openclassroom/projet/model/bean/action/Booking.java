package org.openclassroom.projet.model.bean.action;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;

public class Booking {

	// ==================== Attributes ====================
    @NotNull
    private Date startDate;
    
    @NotNull
    @Future
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
    
    public Boolean isAfter() {
    	Boolean isAfter = endDate.after(new java.util.Date());
    	return isAfter;
    }
    
    public Date dateFromString(String pDate) {
    	java.util.Date vDate = null;
    	
    	try {
			vDate = new SimpleDateFormat("MM/dd/yyyy").parse(pDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	Date sqlDate = new Date(vDate.getTime());
    	
    	return sqlDate;
    }
	
}