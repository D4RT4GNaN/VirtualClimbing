package org.openclassroom.projet.consumer.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.DaoFactory;
import org.openclassroom.projet.consumer.contract.dao.ActionDao;
import org.openclassroom.projet.consumer.contract.dao.TopoDao;
import org.openclassroom.projet.consumer.contract.dao.UserDao;

@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {
	@Inject
	private ActionDao actionDao;
	@Inject
	private TopoDao topoDao;
	@Inject
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