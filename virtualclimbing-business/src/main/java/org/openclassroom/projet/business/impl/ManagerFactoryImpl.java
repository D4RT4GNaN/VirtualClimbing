package org.openclassroom.projet.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.openclassroom.projet.business.contract.ManagerFactory;
import org.openclassroom.projet.business.contract.manager.ActionManager;
import org.openclassroom.projet.business.contract.manager.TopoManager;
import org.openclassroom.projet.business.contract.manager.UserManager;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

	private ActionManager actionManager;
	
	@Inject
	private TopoManager topoManager;
	
	private UserManager userManager;
	
	@Override
	public ActionManager getActionManager() {
		return actionManager;
	}

	@Override
	public TopoManager getTopoManager() {
		return topoManager;
	}

	@Override
	public UserManager getUserManager() {
		return userManager;
	}
	
}
