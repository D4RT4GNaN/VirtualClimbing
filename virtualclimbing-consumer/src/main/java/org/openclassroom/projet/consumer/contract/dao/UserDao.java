package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.user.User;

/**
 * DAO Interface of package
 * {@link org.openclassroom.projet.model.bean.user}
 */
public interface UserDao {

	/**
	 * Get {@link User} from database
	 * @param pPseudo -
	 */
	User getUser(String pPseudo);
	
	/**
	 * Get the list of all {@link User} in database
	 */
	List<User> getListUser();
	
	/**
	 * Add a {@link User} in database
	 * @param pUser -
	 */
	void addUser(User pUser);
	
}