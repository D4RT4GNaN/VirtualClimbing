package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.ActionDao;
import org.openclassroom.projet.consumer.impl.rowmapper.BookingRM;
import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Implementation class of {@link ActionDao}
 */
@Named
public class ActionDaoImpl extends AbstractDao implements ActionDao {
	
	@Override
	public void rentTopo(Booking pBooking) {
		String vRequest = "INSERT INTO booking"
						+ " VALUES ("
						+ " :start_date,"
						+ " :end_date,"
						+ " :name_topo,"
						+ " :pseudo_user"
						+ ")";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("start_date", pBooking.getStartDate(), Types.DATE);
		vParams.addValue("end_date", pBooking.getEndDate(), Types.DATE);
		vParams.addValue("name_topo", pBooking.getTopo().getName(), Types.VARCHAR);
		vParams.addValue("pseudo_user", pBooking.getUser().getPseudo(), Types.VARCHAR);
		
		getNamedParameterJdbcTemplate().update(vRequest, vParams);
	}

	@Override
	public List<Booking> listBooking(User pUser) {
		String vRequest = "SELECT * FROM booking"
						+ " WHERE pseudo_user=?";		
		RowMapper<Booking> vRowMapper = new BookingRM();
		
		List<Booking> vListBooking = getJdbcTemplate().query(vRequest, vRowMapper, pUser.getPseudo());
		
		return vListBooking;
	}
	
}