package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.springframework.jdbc.core.RowMapper;

public class RouteRM implements RowMapper<Route> {

	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		Route vRoute = new Route();
		
		vRoute.setName(rs.getString("name"));
		vRoute.setGrade(rs.getString("grade"));
		vRoute.setHeight(rs.getInt("height"));
		vRoute.setNote(rs.getString("note"));
		
		Sector vSector = new Sector();
		vSector.setName(rs.getString("name_sector"));
		vRoute.setSector(vSector);
		
		return vRoute;
	}

}
