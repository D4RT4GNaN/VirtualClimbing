package org.openclassroom.projet.webapp.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;

import com.opensymphony.xwork2.ActionSupport;

public class BookingAction extends AbstractAction implements SessionAware {

	// ==================== Attributes ====================
	// ----- Input parameter
	private User user;
	
	// ----- Output elements
	private List<Booking> listBooking;
	private List<Topo> listTopo;
	private int endIteration;
	private Booking booking;
	private String endDate;
	
	// ----- Struts elements
	private Map<String, Object> session;
	
	
	
	// ==================== Getters/Setters ====================
	public User getUser() {
		return user;
	}
	public void setUser(User vUser) {
		user = vUser;
	}
	public List<Booking> getListBooking() {
		return listBooking;
	}
	public List<Topo> getListTopo() {
		return listTopo;
	}
	public void setListBooking(List<Booking> pListBooking) {
		listBooking = pListBooking;
	}
	public int getEndIteration() {
		return endIteration;
	}
	public void setEndIteration(int pEndIteration) {
		endIteration = pEndIteration;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking pBooking) {
		booking = pBooking;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String pEndDate) {
		endDate = pEndDate;
	}
	@Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
	
	
	
	// ==================== Methods ====================		
	public String doGetListBooking() {
		user = (User)session.get("user");
		listBooking = getManagerFactory().getActionManager().getListBooking(user);
		endIteration = listBooking.size()>=6 ? listBooking.size()-6 : 0;
		return ActionSupport.SUCCESS;
	}
	
	public String doGetListPrivateTopo() {
		listTopo = getManagerFactory().getTopoManager().searchPrivateTopo();
		return ActionSupport.SUCCESS;
	}
	
	public String doAddBooking() {
		String vResult = ActionSupport.INPUT;
		
		if (this.booking != null && endDate != "") {
			
			Date newDate = new Date();
			booking.setStartDate(new java.sql.Date(newDate.getTime()));
			
			booking.setEndDate(booking.dateFromString(endDate));
			
			User vUser = (User) session.get("user");
			booking.setUser(vUser);
			
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getActionManager().addBooking(booking);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Réservation ajouté avec succès");

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                }
            }
        } else {
        	this.addActionError("Entrer une date de fin de réservation !");
        }
		
		if (vResult.equals(ActionSupport.INPUT)) {
			listTopo = getManagerFactory().getTopoManager().searchPrivateTopo();
		}
		
		return vResult;
	}

}
