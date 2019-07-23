package org.openclassroom.projet.business.impl.manager;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.openclassroom.projet.business.contract.manager.UserManager;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("userManager")
public class UserManagerImpl extends AbstractManager implements UserManager {
	
	@Inject
	@Named("txManagerProjet")
	private PlatformTransactionManager platformTransactionManager;
	
	@Override
	public User connectUser(String pPseudo, String pPassword) throws FunctionalException {
		User vUser = new User();
		try {
			vUser = getDaoFactory().getUserDao().getUser(pPseudo);
		} catch (FunctionalException e) {
			throw new FunctionalException(e.getMessage());
		}
		
		if (vUser.getPassword().equals(pPassword)) {
			return vUser;
		} else {
			throw new FunctionalException("Mot de passe incorrect !");
		}
	}
	
	@Override
	public void addUser(User pUser) throws FunctionalException {
		if (pUser == null) {
            throw new FunctionalException("Un utilisateur ne peut pas être null !");
        }

        Set<ConstraintViolation<User>> vViolations = getConstraintValidator().validate(pUser);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet User est invalide",
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getUserDao().addUser(pUser);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
		} finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	}
	
	@Override
	public void changePassword(User pUser, String pConfirmPassword) throws FunctionalException {
		if (pUser == null)
            throw new FunctionalException("Un utilisateur ne peut pas être null !");
		
		if (pUser.getPseudo() == null || pUser.getPseudo().equals(""))
			throw new FunctionalException("Un utilisateur doit être connecté");
		
		if (pUser.getPassword() == null || pUser.getPassword().equals(""))
			throw new FunctionalException("Un mot de passe doit être renseigné");
		
		if (!pUser.getPassword().equals(pConfirmPassword))
			throw new FunctionalException("Le mot de passe et la confirmation doivent être identique");
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getUserDao().changePassword(pUser);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
		} finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	}
}
