package org.openclassroom.projet.business.impl.manager;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
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
			logger.warn(e.getMessage());
			throw new FunctionalException(e.getMessage());
		}
		
		String hashedPassword = "";
		
		try {
			hashedPassword = hashPassword(pPassword);
		} catch (GeneralSecurityException e) {
			logger.error(e);
			throw new FunctionalException(resourceBundle.getString("manager.user.error.generalSecurity"));
		}
		
		if (vUser.getPassword().equals(hashedPassword)) {
			logger.info(getText("manager.user.logging.connect", pPseudo));
			return vUser;
		} else {
			logger.warn(resourceBundle.getString("manager.user.logging.failedConnect"));
			throw new FunctionalException(resourceBundle.getString("manager.user.error.incorrectPassword"));
		}
		
	}
	
	@Override
	public void addUser(User pUser) throws FunctionalException {
		if (pUser == null) {
			logger.error(resourceBundle.getString("manager.user.logging.null"));
            throw new FunctionalException(resourceBundle.getString("manager.user.error.null"));
        }

        Set<ConstraintViolation<User>> vViolations = getConstraintValidator().validate(pUser);
        if (!vViolations.isEmpty()) {
        	logger.warn(resourceBundle.getString("manager.user.logging.validation") 
        			+ vViolations.toString());
            throw new FunctionalException(resourceBundle.getString("manager.user.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
        
        String rawPassword = pUser.getPassword();
        try {
			String hashedPassword = hashPassword(rawPassword);
			pUser.setPassword(hashedPassword);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			logger.error(resourceBundle.getString("manager.user.logging.hashError") + e);
		}
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getUserDao().addUser(pUser);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	        logger.info(getText("manager.user.logging.newUser", pUser.getPseudo()));
		} finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	            logger.error(resourceBundle.getString("manager.user.logging.databaseError.user"));
	        }
	    }
	}
	
	@Override
	public void changePassword(User pUser, String pConfirmPassword) throws FunctionalException {
		if (pUser == null) {
			logger.error(resourceBundle.getString("manager.user.logging.null"));
            throw new FunctionalException(resourceBundle.getString("manager.user.error.null"));
		}
		
		if (pUser.getPseudo() == null || pUser.getPseudo().equals("")) {
			logger.error(resourceBundle.getString("manager.user.logging.403.password"));
			throw new FunctionalException(resourceBundle.getString("manager.user.error.mustConnected"));
		}
		
		if (pUser.getPassword() == null || pUser.getPassword().equals("")) {
			logger.warn(resourceBundle.getString("manager.user.logging.emptyPassword"));
			throw new FunctionalException(resourceBundle.getString("manager.user.error.emptyPassword"));
		}
		
		if (!pUser.getPassword().equals(pConfirmPassword)) {
			logger.warn(resourceBundle.getString("manager.user.logging.badConfirmPassword"));
			throw new FunctionalException(resourceBundle.getString("manager.user.error.badConfirmPassword"));
		}
		
		String rawPassword = pUser.getPassword();
        try {
			String hashedPassword = hashPassword(rawPassword);
			pUser.setPassword(hashedPassword);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			logger.error(resourceBundle.getString("manager.user.logging.hashError") + e);
		}
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getUserDao().changePassword(pUser);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	        logger.info(getText("manager.user.logging.newPassword", pUser.getPseudo()));
		} finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	            logger.error(resourceBundle.getString("manager.user.logging.databaseError.password"));
	        }
	    }
	}
	
	private String hashPassword(String pPassword) throws GeneralSecurityException {
		MessageDigest vMessageDigest = MessageDigest.getInstance("SHA-256");
		vMessageDigest.update(pPassword.getBytes());
		
		byte byteData[] = vMessageDigest.digest();
		
		StringBuffer vStringBuffer = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			vStringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
		
		return vStringBuffer.toString();
	}
}
