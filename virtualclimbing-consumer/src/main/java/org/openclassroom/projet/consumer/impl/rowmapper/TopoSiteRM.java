package org.openclassroom.projet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.springframework.jdbc.core.RowMapper;

public class TopoSiteRM implements RowMapper<TopoSite> {

	@Override
	public TopoSite mapRow(ResultSet rs, int rowNum) throws SQLException {
		TopoSite vTopoSite = new TopoSite();
		Topo vTopo = new Topo();
		Site vSite = new Site();
		
		vTopo.setName(rs.getString("name_topo"));
		vSite.setName(rs.getString("name_site"));
		
		vTopoSite.setTopo(vTopo);
		vTopoSite.setSite(vSite);
		
		return vTopoSite;
	}
	
}
