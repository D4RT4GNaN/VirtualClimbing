package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class BookingRM implements RowMapper<Booking> {

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		Booking vBooking = new Booking();
		vBooking.setStartDate(rs.getDate("start_date"));
		vBooking.setEndDate(rs.getDate("end_date"));
		
		Topo vTopo = new Topo();
		vTopo.setName(rs.getString("name_topo"));
		vBooking.setTopo(vTopo);
		
		User vUser = new User();
		vUser.setPseudo(rs.getString("pseudo_user"));
		vBooking.setUser(vUser);
		
		return vBooking;
	}
	
}