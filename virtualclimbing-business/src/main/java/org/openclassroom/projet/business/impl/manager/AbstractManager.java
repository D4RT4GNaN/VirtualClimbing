package org.openclassroom.projet.business.impl.manager;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.openclassroom.projet.consumer.contract.DaoFactory;

public abstract class AbstractManager {
	
	Locale locale = Locale.FRENCH;
	
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
    
    ResourceBundle resourceBundle = ResourceBundle.getBundle("businessMessage", locale);

}
