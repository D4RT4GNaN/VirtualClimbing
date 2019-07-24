package org.openclassroom.projet.business.impl.manager;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.openclassroom.projet.business.contract.manager.ActionManager;
import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("actionManager")
public class ActionManagerImpl extends AbstractManager implements ActionManager {
	
	@Inject
	@Named("txManagerProjet")
	private PlatformTransactionManager platformTransactionManager;
	
	@Override
	public void addBooking(Booking pBooking) throws FunctionalException {
		if (pBooking == null) {
            throw new FunctionalException("Une réservation ne peut pas être null !");
        }

        Set<ConstraintViolation<Booking>> vViolations = getConstraintValidator().validate(pBooking);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Booking est invalide",
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getActionDao().rentTopo(pBooking);
	
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
	public List<Booking> getListBooking(User pUser) {
		List<Booking> vListBooking = getDaoFactory().getActionDao().listBooking(pUser);
		return vListBooking;
	}

}
