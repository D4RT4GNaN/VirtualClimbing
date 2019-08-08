package org.openclassroom.projet.business.contract.manager;

import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.openclassroom.projet.model.exception.TechnicalException;

public interface UserManager {
	/**
	 * Add a new {@link User}
	 * 
	 * @param pUser -
	 */
	void addUser(User pUser) throws TechnicalException, FunctionalException;

	/**
	 * Get a specific {@link User} with couple of parameter: Pseudo and Password
	 * 
	 * @param pPseudo -
	 * @param pPassword -
	 * @return {@link User}
	 */
	User connectUser(String pPseudo, String pPassword) throws FunctionalException;

	/**
	 * Change the password of an existing {@link User}
	 * 
	 * @param pUser -
	 * @param pConfirmPassword -
	 */
	void changePassword(User pUser, String pConfirmPassword) throws FunctionalException;
}
