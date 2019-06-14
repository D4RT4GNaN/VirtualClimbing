package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class SectorRM implements RowMapper<Sector> {

	@Override
	public Sector mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sector vSector = new Sector();
		
		vSector.setName(rs.getString("name"));
		
		Site vSite = new Site();
		vSite.setName(rs.getString("name_site"));
		vSector.setSite(vSite);
		
		vSector.setImageUrl(rs.getString("image_url"));
		
		return vSector;
	}

}
