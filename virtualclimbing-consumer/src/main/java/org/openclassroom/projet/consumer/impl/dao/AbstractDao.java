package org.openclassroom.projet.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDao {

	@Inject
	@Named("dataSourceProjet")
	private DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}
	
}