package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.UserDao;
import org.openclassroom.projet.consumer.impl.rowmapper.UserRM;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Implementation class of {@link UserDao}
 */
@Named
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public User getUser(String pPseudo) {
		String vRequest = "SELECT * FROM identified_user"
				+ " WHERE pseudo=?";
		RowMapper<User> vRowMapper = new UserRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		User vUser = vJdbcTemplate.queryForObject(vRequest, vRowMapper, pPseudo);
		
		return vUser;
	}

	@Override
	public List<User> getListUser() {
		String vRequest = "SELECT * FROM identified_user";
		RowMapper<User> vRowMapper = new UserRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<User> vListUser = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListUser;
	}

	@Override
	public void addUser(User pUser) {
		String vRequest = "INSERT INTO identified_user (pseudo, first_name, last_name, password, registration_date) "
				+ "VALUES (:pseudo, :firstName, :lastName, :password, :registrationDate)";

		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pUser);
		vParams.registerSqlType("pseudo", Types.VARCHAR);
		vParams.registerSqlType("firstName", Types.VARCHAR);
		vParams.registerSqlType("lastName", Types.VARCHAR);
		vParams.registerSqlType("password", Types.VARCHAR);
		vParams.registerSqlType("registrationDate", Types.DATE);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}

}