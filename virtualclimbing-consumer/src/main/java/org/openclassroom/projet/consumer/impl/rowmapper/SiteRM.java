package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class SiteRM implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		Site vSite = new Site();
		
		vSite.setName(rs.getString("name"));
		vSite.setEquipment(rs.getString("equipment"));
		vSite.setNumberRoute(rs.getInt("number_route"));
		vSite.setMaxHeight(rs.getInt("max_height"));
		vSite.setRockType(rs.getString("rock_type"));
		vSite.setLocation(rs.getString("location"));
		
		return vSite;
	}

}
