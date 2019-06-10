package org.openclassroom.projet.consumer.contract;

import org.openclassroom.projet.consumer.contract.dao.ActionDao;
import org.openclassroom.projet.consumer.contract.dao.TopoDao;
import org.openclassroom.projet.consumer.contract.dao.UserDao;

public interface DaoFactory {

	ActionDao getActionDao();
	
	TopoDao getTopoDao();
	
	UserDao getUserDao();
	
}