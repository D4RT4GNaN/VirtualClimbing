package org.openclassroom.projet.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Named("abstractDao")
public abstract class AbstractDao {
	
	@Inject
	@Named("dataSourceProjet")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource pDataSource) {
		jdbcTemplate = new JdbcTemplate(pDataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(pDataSource);
	}
	
}