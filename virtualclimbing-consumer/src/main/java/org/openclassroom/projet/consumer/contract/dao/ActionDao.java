package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;

/**
 * DAO Interface of package
 * {@link org.openclassroom.projet.model.bean.action}
 */
public interface ActionDao {
	
	// ===================================
	//               Booking
	// ===================================
	
	/**
	 * Add reservation of {@link Topo} in the database
	 * 
	 * @param pBooking -
	 */
	void rentTopo(Booking pBooking);
	
	/**
	 * Return the list of {@link Booking} for an {@link User}
	 * 
	 * @param pUser -
	 * @return List<{@link Booking}>
	 */
	List<Booking> listBooking(User pUser);
	
	
	
	// ===================================
	//               Comment
	// ===================================
	
	/**
	 * Return the list of {@link Comment} for a {@link Sector} in database
	 * 
	 * @param pSector -
	 * @return List<{@link Comment}>
	 */
	List<Comment> getListComment(Sector pSector);
	
	/**
	 * Add the {@link Comment} in database
	 * 
	 * @param pComment -
	 */
	void addComment(Comment pComment);
	
}