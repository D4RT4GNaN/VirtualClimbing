package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.ActionDao;
import org.openclassroom.projet.consumer.impl.rowmapper.BookingRM;
import org.openclassroom.projet.consumer.impl.rowmapper.CommentRM;
import org.openclassroom.projet.model.bean.action.Booking;
import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
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
	
	// ===================================
	//               Booking
	// ===================================
	
	@Override
	public void rentTopo(Booking pBooking) {
		String vRequest = "INSERT INTO booking (start_date, end_date, name_topo, pseudo_user)"
						+ " VALUES (:startDate, :endDate, :nameTopo, :pseudoUser)";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("startDate", pBooking.getStartDate(), Types.DATE);
		vParams.addValue("endDate", pBooking.getEndDate(), Types.DATE);
		vParams.addValue("nameTopo", pBooking.getTopo().getName(), Types.VARCHAR);
		vParams.addValue("pseudoUser", pBooking.getUser().getPseudo(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}

	@Override
	public List<Booking> listBooking(User pUser) {
		String vRequest = "SELECT * FROM booking"
						+ " WHERE pseudo_user=?";		
		RowMapper<Booking> vRowMapper = new BookingRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Booking> vListBooking = vJdbcTemplate.query(vRequest, vRowMapper, pUser.getPseudo());
		
		return vListBooking;
	}

	
	
	// ===================================
	//               Comment
	// ===================================
	
	@Override
	public List<Comment> getListCommentTopo(Topo pTopo) {
		String vRequest = "SELECT * FROM comment"
				+ " WHERE name_topo=?";		
		RowMapper<Comment> vRowMapper = new CommentRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Comment> vListComment = vJdbcTemplate.query(vRequest, vRowMapper, pTopo.getName());
		
		return vListComment;
	}

	@Override
	public List<Comment> getListCommentSite(Site pSite) {
		String vRequest = "SELECT * FROM comment"
				+ " WHERE name_site=?";		
		RowMapper<Comment> vRowMapper = new CommentRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Comment> vListComment = vJdbcTemplate.query(vRequest, vRowMapper, pSite.getName());
		
		return vListComment;
	}

	@Override
	public List<Comment> getListCommentSector(Sector pSector) {
		String vRequest = "SELECT * FROM comment"
				+ " WHERE name_sector=?";		
		RowMapper<Comment> vRowMapper = new CommentRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Comment> vListComment = vJdbcTemplate.query(vRequest, vRowMapper, pSector.getName());
		
		return vListComment;
	}

	@Override
	public void addComment(Comment pComment) {
		String vRequest = "INSERT INTO comment "
						+ "VALUES (:title, :description, :pseudo_user, :name_topo, :name_site, :name_sector)";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("title", pComment.getTitle(), Types.VARCHAR);
		vParams.addValue("description", pComment.getDescription(), Types.VARCHAR);
		vParams.addValue("pseudo_user", pComment.getUser().getPseudo(), Types.VARCHAR);
		vParams.addValue("name_topo", pComment.getTopo().getName(), Types.VARCHAR);
		vParams.addValue("name_site", pComment.getSite().getName(), Types.VARCHAR);
		vParams.addValue("name_sector", pComment.getSector().getName(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
		
	}
	
}