package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;

/**
 * DAO Interface of package
 * {@link org.openclassroom.projet.model.bean.user}
 */
public interface UserDao {

	/**
	 * Get {@link User} from database
	 * @param pPseudo -
	 * @throws FunctionalException 
	 */
	User getUser(String pPseudo) throws FunctionalException;
	
	/**
	 * Get the list of all {@link User} in database
	 */
	List<User> getListUser();
	
	/**
	 * Add a {@link User} in database
	 * @param pUser -
	 * @throws FunctionalException 
	 */
	void addUser(User pUser) throws FunctionalException;

	/**
	 * Change the password of an existing {@link User}
	 * @param pUser -
	 */
	void changePassword(User pUser);
	
}