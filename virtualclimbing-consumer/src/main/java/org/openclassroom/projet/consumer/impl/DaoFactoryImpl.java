package org.openclassroom.projet.consumer.impl;

import org.openclassroom.projet.consumer.contract.DaoFactory;
import org.openclassroom.projet.consumer.contract.dao.ActionDao;
import org.openclassroom.projet.consumer.contract.dao.TopoDao;
import org.openclassroom.projet.consumer.contract.dao.UserDao;

public class DaoFactoryImpl implements DaoFactory {
	
	private ActionDao actionDao;
	private TopoDao topoDao;
	private UserDao userDao;

	@Override
	public ActionDao getActionDao() {
		return actionDao;
	}

	@Override
	public TopoDao getTopoDao() {
		return topoDao;
	}

	@Override
	public UserDao getUserDao() {
		return userDao;
	}

}