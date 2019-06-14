package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRM implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User vUser = new User();
		
		vUser.setPseudo(rs.getString("pseudo"));
		vUser.setFirstName(rs.getString("first_name"));
		vUser.setLastName(rs.getString("last_name"));
		vUser.setPassword(rs.getString("password"));
		vUser.setRegistrationDate(rs.getDate("registration_date"));
		
		return vUser;
	}

}
