package org.openclassroom.projet.webapp.converter.locator;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.struts2.util.StrutsTypeConverter;

public abstract class AbstractLocator extends StrutsTypeConverter {

	Locale locale = Locale.FRENCH;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);
	
}
