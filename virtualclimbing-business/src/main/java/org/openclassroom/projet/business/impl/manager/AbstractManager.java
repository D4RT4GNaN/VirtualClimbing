package org.openclassroom.projet.business.impl.manager;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openclassroom.projet.consumer.contract.DaoFactory;

public abstract class AbstractManager {
	
	Locale locale = Locale.FRENCH;
	Logger logger = LogManager.getLogger("RollingFileLogger");
	ResourceBundle resourceBundle = ResourceBundle.getBundle("businessMessage", locale);
	
	@Inject
	private DaoFactory daoFactory;
	
	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	/**
     * Return a {@link Validator} for constraints
     *
     * @return Validator
     */
    protected Validator getConstraintValidator() {
        Configuration<?> vConfiguration = Validation.byDefaultProvider().configure();
        ValidatorFactory vFactory = vConfiguration.buildValidatorFactory();
        Validator vValidator = vFactory.getValidator();
        return vValidator;
    }

    /**
     * Get text from resourceBundle with one parameter to format it
     * 
     * @param pText -
     * @param pParameter -
     * @return String
     */
    protected String getText(String pText, Object pParameter) {
		String vMessage = resourceBundle.getString(pText);
		MessageFormat vMessageFormat = new MessageFormat(vMessage);
		Object[] pParameters = {pParameter};
		vMessage = vMessageFormat.format(pParameters);
		return vMessage;
	}
    
    /**
     * Get text from resourceBundle with two parameter to format it
     * 
     * @param pText -
     * @param pParameter1 & pParameter2 -
     * @return String
     */
    protected String getText(String pText, Object pParameter1, Object pParameter2) {
		String vMessage = resourceBundle.getString(pText);
		MessageFormat vMessageFormat = new MessageFormat(vMessage);
		Object[] pParameters = {pParameter1, pParameter2};
		vMessage = vMessageFormat.format(pParameters);
		return vMessage;
	}
}
