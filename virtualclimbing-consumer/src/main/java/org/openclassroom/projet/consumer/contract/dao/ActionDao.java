package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.user.User;

/**
 * DAO Interface of package
 * {@link org.openclassroom.projet.model.bean.action}
 */
public interface ActionDao {
	
	/**
	 * Add reservation of {@link Topo} in the database
	 * @param pBooking -
	 */
	void rentTopo(Booking pBooking);
	
	/**
	 * Return the list of {@link Booking} for an {@link User}
	 * @param pUser -
	 */
	List<Booking> listBooking(User pUser);
	
}