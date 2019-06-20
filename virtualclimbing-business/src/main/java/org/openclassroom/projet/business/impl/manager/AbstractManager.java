package org.openclassroom.projet.business.impl.manager;

import javax.inject.Inject;

import org.openclassroom.projet.consumer.contract.DaoFactory;

public abstract class AbstractManager {
	
	@Inject
	private DaoFactory daoFactory;
	
	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

}
