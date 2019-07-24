package org.openclassroom.projet.business.contract.manager;

import java.util.List;

import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;

public interface ActionManager {

	// ===================================
	//               Booking
	// ===================================
	
	/**
	 * Validate the input information and add the {@link Booking} for an {@link User}
	 * @param pBooking -
	 * @throws FunctionalException 
	 */
	void addBooking(Booking pBooking) throws FunctionalException;

	/**
	 * Return all {@link Booking} of an {@link User}
	 * @param pUser -
	 */
	List<Booking> getListBooking(User pUser);

	// ===================================
	//               Comment
	// ===================================
	
	/**
	 * Return all {@link Comment} for a {@link Sector}
	 * @param pSector -
	 */
	List<Comment> getListComment(Sector pSector);

	/**
	 * Validate the {@link Comment} and add it for a {@link Sector}
	 * @param pComment -
	 * @throws FunctionalException 
	 */
	void addComment(Comment pComment) throws FunctionalException;
	
}
