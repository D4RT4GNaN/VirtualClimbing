package org.openclassroom.projet.business.contract;

import org.openclassroom.projet.business.contract.manager.ActionManager;
import org.openclassroom.projet.business.contract.manager.TopoManager;
import org.openclassroom.projet.business.contract.manager.UserManager;

public interface ManagerFactory {

	ActionManager getActionManager();
	TopoManager getTopoManager();
	UserManager getUserManager();
	
	/*
	void setActionManager(ActionManager pActionManager);
	void setTopoManager(TopoManager pTopoManager);
	void setUserManager(UserManager pUserManager);
	*/
}
