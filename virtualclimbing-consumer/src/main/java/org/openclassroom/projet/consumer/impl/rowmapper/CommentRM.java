package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class CommentRM implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment vComment = new Comment();
		User vUser = new User();
		Topo vTopo = new Topo();
		Site vSite = new Site();
		Sector vSector = new Sector();
		
		vUser.setPseudo(rs.getString("pseudo_user"));
		vTopo.setName(rs.getString("name_topo"));
		vSite.setName(rs.getString("name_site"));
		vSector.setName(rs.getString("name_sector"));
		
		vComment.setTitle(rs.getString("title"));
		vComment.setDescription(rs.getString("description"));
		vComment.setUser(vUser);
		vComment.setTopo(vTopo);
		vComment.setSite(vSite);
		vComment.setSector(vSector);
		
		return vComment;
	}

}
