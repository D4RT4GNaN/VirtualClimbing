package org.openclassroom.projet.consumer.impl.dao;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

@Named("abstractDao")
public abstract class AbstractDao {
	
	Locale locale = Locale.FRENCH;
	
	@Inject
	@Named("dataSourceProjet")
	private DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}

	ResourceBundle resourceBundle = ResourceBundle.getBundle("consumerMessage", locale);
	
	protected String getText(String pText, Object pParameter) {
		String vMessage = resourceBundle.getString(pText);
		MessageFormat vMessageFormat = new MessageFormat(vMessage);
		Object[] pParameters = {pParameter};
		vMessage = vMessageFormat.format(pParameters);
		return vMessage;
	}
	
	protected String getText(String pText, Object pParameter1, Object pParameter2) {
		String vMessage = resourceBundle.getString(pText);
		MessageFormat vMessageFormat = new MessageFormat(vMessage);
		Object[] pParameters = {pParameter1, pParameter2};
		vMessage = vMessageFormat.format(pParameters);
		return vMessage;
	}
	
}