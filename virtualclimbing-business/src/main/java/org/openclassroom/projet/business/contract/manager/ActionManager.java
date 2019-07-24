package org.openclassroom.projet.business.contract.manager;

import java.util.List;

import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;

public interface ActionManager {

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

}
