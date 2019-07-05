package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Site;
import org.springframework.jdbc.core.RowMapper;

public class SiteRM implements RowMapper<Site> {

	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		Site vSite = new Site();
		
		vSite.setName(rs.getString("name"));
		vSite.setImageUrl(rs.getString("image_url"));
		vSite.setLatitude(rs.getFloat("latitude"));
		vSite.setLongitude(rs.getFloat("longitude"));
		vSite.setLocation(rs.getString("location"));
		vSite.setAccess(rs.getString("access"));
		vSite.setRockType(rs.getString("rock_type"));
		vSite.setProfil(rs.getString("profil"));
		vSite.setAnchorage(rs.getString("anchorage"));
		vSite.setMaxHeight(rs.getInt("max_height"));
		vSite.setMinAltitude(rs.getInt("min_altitude"));
		vSite.setOrientation(rs.getString("orientation"));
		vSite.setNote(rs.getString("note"));
		
		return vSite;
	}

}
