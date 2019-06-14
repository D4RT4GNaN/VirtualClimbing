package org.openclassroom.projet.consumer.impl.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDao {
	
	/*@Inject
	@Named("dataSourceProjet")
	private DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}*/
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	
	public void setDataSource(DataSource pDataSource) {
		jdbcTemplate = new JdbcTemplate(pDataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(pDataSource);
	}
	
}