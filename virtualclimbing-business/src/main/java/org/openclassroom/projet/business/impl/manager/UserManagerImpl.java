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
			throw new FunctionalException(e.getMessage());
		}
		
		String hashedPassword = "";
		
		try {
			hashedPassword = hashPassword(pPassword);
		} catch (GeneralSecurityException e) {
			throw new FunctionalException(resourceBundle.getString("manager.user.error.generalSecurity"));
		}
		
		if (vUser.getPassword().equals(hashedPassword)) {
			return vUser;
		} else {
			throw new FunctionalException(resourceBundle.getString("manager.user.error.incorrectPassword"));
		}
		
	}
	
	@Override
	public void addUser(User pUser) throws FunctionalException {
		if (pUser == null) {
            throw new FunctionalException(resourceBundle.getString("manager.user.error.null"));
        }

        Set<ConstraintViolation<User>> vViolations = getConstraintValidator().validate(pUser);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException(resourceBundle.getString("manager.user.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
        
        String rawPassword = pUser.getPassword();
        try {
			String hashedPassword = hashPassword(rawPassword);
			pUser.setPassword(hashedPassword);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
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
            throw new FunctionalException(resourceBundle.getString("manager.user.error.null"));
		
		if (pUser.getPseudo() == null || pUser.getPseudo().equals(""))
			throw new FunctionalException(resourceBundle.getString("manager.user.error.mustConnected"));
		
		if (pUser.getPassword() == null || pUser.getPassword().equals(""))
			throw new FunctionalException(resourceBundle.getString("manager.user.error.emptyPassword"));
		
		if (!pUser.getPassword().equals(pConfirmPassword))
			throw new FunctionalException(resourceBundle.getString("manager.user.error.badConfirmPassword"));
		
		String rawPassword = pUser.getPassword();
        try {
			String hashedPassword = hashPassword(rawPassword);
			pUser.setPassword(hashedPassword);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		
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
