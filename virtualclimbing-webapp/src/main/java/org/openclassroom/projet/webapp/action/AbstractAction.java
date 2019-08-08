package org.openclassroom.projet.webapp.action;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openclassroom.projet.business.contract.ManagerFactory;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {
	
	Logger logger = LogManager.getLogger("RollingFileLogger");
	
	@Inject
	private ManagerFactory managerFactory;
	
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

}
