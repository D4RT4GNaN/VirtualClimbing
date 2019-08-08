package org.openclassroom.projet.business.impl.manager;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.openclassroom.projet.business.contract.manager.ActionManager;
import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Sector;
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
	
	// ===================================
	//               Booking
	// ===================================
	
	@Override
	public void addBooking(Booking pBooking) throws FunctionalException {
		if (pBooking == null) {
			logger.error(resourceBundle.getString("manager.booking.logging.null"));
            throw new FunctionalException(resourceBundle.getString("manager.booking.error.null"));
        }

        Set<ConstraintViolation<Booking>> vViolations = getConstraintValidator().validate(pBooking);
        if (!vViolations.isEmpty()) {
        	logger.warn(resourceBundle.getString("manager.booking.logging.validation") 
        			+ vViolations.toString());
            throw new FunctionalException(resourceBundle.getString("manager.booking.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getActionDao().rentTopo(pBooking);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	        logger.info(getText("manager.booking.logging.newBooking", 
	        		pBooking.getUser().getPseudo(),
	        		pBooking.getTopo().getName())
	        );
		} finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	            logger.error(resourceBundle.getString("manager.booking.logging.databaseError"));
	        }
	    }
	}
	
	@Override
	public List<Booking> getListBooking(User pUser) {
		List<Booking> vListBooking = getDaoFactory().getActionDao().listBooking(pUser);
		return vListBooking;
	}
	
	// ===================================
	//               Comment
	// ===================================
	
	@Override
	public List<Comment> getListComment(Sector pSector) {
		List<Comment> vListComment = getDaoFactory().getActionDao().getListComment(pSector);
		return vListComment;
	}
	
	@Override
	public void addComment(Comment pComment) throws FunctionalException {
		if (pComment == null) {
			logger.error(resourceBundle.getString("manager.comment.logging.null"));
            throw new FunctionalException(resourceBundle.getString("manager.comment.error.null"));
        }

        Set<ConstraintViolation<Comment>> vViolations = getConstraintValidator().validate(pComment);
        if (!vViolations.isEmpty()) {
        	logger.warn(resourceBundle.getString("manager.comment.logging.validation")
        			+ vViolations.toString());
            throw new FunctionalException(resourceBundle.getString("manager.comment.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getActionDao().addComment(pComment);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	        logger.info(getText("manager.comment.logging.newComment", pComment.getUser().getPseudo()));
		} finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	            logger.error(resourceBundle.getString("manager.comment.logging.databaseError"));
	        }
	    }
	}

}
