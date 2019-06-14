package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.TopoDao;
import org.openclassroom.projet.consumer.impl.rowmapper.TopoRM;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 * Implementation class of {@link TopoDao}
 */
@Named
public class TopoDaoImpl extends AbstractDao implements TopoDao {
	
	// ==============================================
	//                      Topo
	// ==============================================
	
	@Override
	public Topo getTopo(String pNameTopo) {
		String vRequest = "SELECT * FROM booking"
						+ " WHERE name=?";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		Topo vTopo = getJdbcTemplate().queryForObject(vRequest, vRowMapper, pNameTopo);
		
		return vTopo;
	}

	@Override
	public List<Topo> getListTopo() {
		String vRequest = "SELECT * FROM booking";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		List<Topo> vListTopo = getJdbcTemplate().query(vRequest, vRowMapper);
		
		return vListTopo;
	}

	@Override
	public List<Topo> searchTopo(String pKeyword) {
		String vRequest = "SELECT * FROM topo WHERE lower(name) LIKE ?";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		List<Topo> vListTopo = getJdbcTemplate().query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListTopo;
	}
	
	@Override
	public void addTopo(Topo pTopo) {
		String vRequest = "INSERT INTO identified_user (name, official_web_site, description, pseudo) VALUES (:name, :officialWebSite, :description, :pseudo)";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pTopo.getName(), Types.VARCHAR);
		vParams.addValue("officialWebSite", pTopo.getOfficialWebSite(), Types.VARCHAR);
		vParams.addValue("description", pTopo.getDescription(), Types.VARCHAR);
		vParams.addValue("pseudo", pTopo.getUser().getPseudo(), Types.VARCHAR);
		
		getNamedParameterJdbcTemplate().update(vRequest, vParams);
	}

}