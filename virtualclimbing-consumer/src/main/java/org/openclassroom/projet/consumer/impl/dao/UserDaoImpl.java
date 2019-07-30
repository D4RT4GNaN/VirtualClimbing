package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.UserDao;
import org.openclassroom.projet.consumer.impl.rowmapper.UserRM;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Implementation class of {@link UserDao}
 */
@Named
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public User getUser(String pPseudo) throws FunctionalException {
		String vRequest = "SELECT * FROM identified_user"
				+ " WHERE pseudo=?";
		RowMapper<User> vRowMapper = new UserRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		User vUser = new User();
		
		try {
			vUser = vJdbcTemplate.queryForObject(vRequest, vRowMapper, pPseudo);
		} catch (EmptyResultDataAccessException pEx) {
			throw new FunctionalException(getText("dao.user.error.emptyResult", pPseudo));
		}
		
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
	public void addUser(User pUser) throws FunctionalException {
		String vRequest = "INSERT INTO identified_user (pseudo, first_name, last_name, password, registration_date) "
						+ "VALUES (:pseudo, :firstName, :lastName, :password, :registrationDate)";

		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pUser);
		vParams.registerSqlType("pseudo", Types.VARCHAR);
		vParams.registerSqlType("firstName", Types.VARCHAR);
		vParams.registerSqlType("lastName", Types.VARCHAR);
		vParams.registerSqlType("password", Types.VARCHAR);
		vParams.registerSqlType("registrationDate", Types.DATE);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vNamedParameterJdbcTemplate.update(vRequest, vParams);
		} catch (DuplicateKeyException pEx) {
			throw new FunctionalException(getText("dao.user.error.duplicateKey", pUser.getPseudo()));
		}
	}
	
	@Override
	public void changePassword(User pUser) {
		String vRequest = "UPDATE identified_user"
						+ " SET password=:password"
						+ " WHERE pseudo=:pseudo";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("pseudo", pUser.getPseudo(), Types.VARCHAR);
		vParams.addValue("password", pUser.getPassword(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}

}