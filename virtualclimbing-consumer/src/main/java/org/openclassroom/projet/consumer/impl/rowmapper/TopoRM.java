package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class TopoRM implements RowMapper<Topo> {

	@Override
	public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Topo vTopo = new Topo();
		User vUser = new User();
		
		vUser.setPseudo(rs.getString("pseudo"));
		
		vTopo.setName(rs.getString("name"));
		vTopo.setOfficialWebSite(rs.getString("official_web_site"));
		vTopo.setDescription(rs.getString("description"));
		vTopo.setUser(vUser);
		vTopo.setImageUrl(rs.getString("image_url"));
		vTopo.setPrivateTopo(rs.getBoolean("private"));
		
		return vTopo;
	}

}
