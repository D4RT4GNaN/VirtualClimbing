package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.TopoDao;
import org.openclassroom.projet.consumer.impl.rowmapper.RouteRM;
import org.openclassroom.projet.consumer.impl.rowmapper.SectorRM;
import org.openclassroom.projet.consumer.impl.rowmapper.SiteRM;
import org.openclassroom.projet.consumer.impl.rowmapper.TopoRM;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Implementation class of {@link TopoDao}
 */
@Named("topoDao")
public class TopoDaoImpl extends AbstractDao implements TopoDao {
	
	// ==============================================
	//                      Topo
	// ==============================================
	
	@Override
	public Topo getTopo(String pNameTopo) {
		String vRequest = "SELECT * FROM topo"
						+ " WHERE name=?";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Topo vTopo = vJdbcTemplate.queryForObject(vRequest, vRowMapper, pNameTopo);
		
		return vTopo;
	}

	@Override
	public List<Topo> getListTopo() {
		String vRequest = "SELECT * FROM topo";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Topo> vListTopo = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListTopo;
	}

	@Override
	public List<Topo> searchTopo(String pKeyword) {
		String vRequest = "SELECT * FROM topo WHERE lower(name) LIKE ?";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Topo> vListTopo = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListTopo;
	}
	
	@Override
	public void addTopo(Topo pTopo) {
		String vRequest = "INSERT INTO topo (name, official_web_site, description, pseudo) "
						+ "VALUES (:name, :officialWebSite, :description, :pseudo)";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pTopo.getName(), Types.VARCHAR);
		vParams.addValue("officialWebSite", pTopo.getOfficialWebSite(), Types.VARCHAR);
		vParams.addValue("description", pTopo.getDescription(), Types.VARCHAR);
		vParams.addValue("pseudo", pTopo.getUser().getPseudo(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}
	
	
	
	// ==============================================
	//                   Topo_Site
	// ==============================================
	
	@Override
	public List<Topo> getListTopoForSite(Site pSite) {
		String vRequest = "SELECT * FROM topo_site WHERE name_site = ?";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Topo> vListTopo = vJdbcTemplate.query(vRequest, vRowMapper, pSite.getName());
		
		return vListTopo;
	}
	
	@Override
	public List<Site> getListSiteForTopo(Topo pTopo) {
		String vRequest = "SELECT * FROM topo_site WHERE name_topo = ?";
		RowMapper<Site> vRowMapper = new SiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Site> vListSite = vJdbcTemplate.query(vRequest, vRowMapper, pTopo.getName());
		
		return vListSite;
	}
	
	@Override
	public void addTopoSite(TopoSite pTopoSite) {
		String vRequest = "INSERT INTO site (nameTopo, nameSite) "
				+ "VALUES (:nameTopo, :nameSite)";

		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTopoSite);
		vParams.registerSqlType("nameTopo", Types.VARCHAR);
		vParams.registerSqlType("nameSite", Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	@Override
	public Site getSite(String pNameSite) {
		String vRequest = "SELECT * FROM site"
				+ " WHERE name=?";
		RowMapper<Site> vRowMapper = new SiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Site vSite = vJdbcTemplate.queryForObject(vRequest, vRowMapper, pNameSite);
		
		return vSite;
	}
	
	@Override
	public List<Site> getListSite() {
		String vRequest = "SELECT * FROM site";
		RowMapper<Site> vRowMapper = new SiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Site> vListSite = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListSite;
	}
	
	@Override
	public List<Site> searchSite(String pKeyword) {
		String vRequest = "SELECT * FROM site WHERE lower(name) LIKE ?";
		RowMapper<Site> vRowMapper = new SiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Site> vListSite = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListSite;
	}
	
	@Override
	public void addSite(Site pSite) {
		String vRequest = "INSERT INTO site (name, equipment, number_route, max_height, rock_type, location) "
						+ "VALUES (:name, :equipment, :numberRoute, :maxHeight, :rockType, :location)";
		
		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pSite);
		vParams.registerSqlType("name", Types.VARCHAR);
		vParams.registerSqlType("equipment", Types.VARCHAR);
		vParams.registerSqlType("numberRoute", Types.INTEGER);
		vParams.registerSqlType("maxHeight", Types.INTEGER);
		vParams.registerSqlType("rockType", Types.VARCHAR);
		vParams.registerSqlType("location", Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}


		
	// ==============================================
	//                     Sector
	// ==============================================

	@Override
	public Sector getSector(Sector pNameSector) {
		String vRequest = "SELECT * FROM sector"
				+ " WHERE name=?";
		RowMapper<Sector> vRowMapper = new SectorRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Sector vSector = vJdbcTemplate.queryForObject(vRequest, vRowMapper, pNameSector);
		
		return vSector;
	}

	@Override
	public List<Sector> getListSector() {
		String vRequest = "SELECT * FROM sector";
		RowMapper<Sector> vRowMapper = new SectorRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Sector> vListSector = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListSector;
	}
	
	@Override
	public List<Sector> getListSectorForSite(Site pSite) {
		String vRequest = "SELECT * FROM sector "
						+ "WHERE name_site = ?";
		RowMapper<Sector> vRowMapper = new SectorRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Sector> vListSector = vJdbcTemplate.query(vRequest, vRowMapper, pSite.getName());
		
		return vListSector;
	}

	@Override
	public List<Sector> searchSector(String pKeyword) {
		String vRequest = "SELECT * FROM sector WHERE lower(name) LIKE ?";
		RowMapper<Sector> vRowMapper = new SectorRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Sector> vListSector = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListSector;
	}

	@Override
	public void addSector(Sector pSector) {
		String vRequest = "INSERT INTO sector (name, name_site, image_url) "
				+ "VALUES (:name, :nameSite, :imageUrl)";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pSector.getName(), Types.VARCHAR);
		vParams.addValue("nameSite", pSector.getSite().getName(), Types.VARCHAR);
		vParams.addValue("imageUrl", pSector.getImageUrl(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}
	
	
	
	// ==============================================
	//                     Route
	// ==============================================

	@Override
	public Route getRoute(String pNameRoute) {
		String vRequest = "SELECT * FROM route"
				+ " WHERE name=?";
		RowMapper<Route> vRowMapper = new RouteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Route vRoute = vJdbcTemplate.queryForObject(vRequest, vRowMapper, pNameRoute);
		
		return vRoute;
	}

	@Override
	public List<Route> getListRoute() {
		String vRequest = "SELECT * FROM route";
		RowMapper<Route> vRowMapper = new RouteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Route> vListRoute = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListRoute;
	}
	
	@Override
	public List<Route> getListRouteForSector(Sector pSector) {
		String vRequest = "SELECT * FROM route "
						+ "WHERE name_sector = ?";
		RowMapper<Route> vRowMapper = new RouteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Route> vListRoute = vJdbcTemplate.query(vRequest, vRowMapper, pSector.getName());
		
		return vListRoute;
	}

	@Override
	public List<Route> searchRoute(String pKeyword) {
		String vRequest = "SELECT * FROM route WHERE lower(name) LIKE ?";
		RowMapper<Route> vRowMapper = new RouteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Route> vListRoute = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListRoute;
	}

	@Override
	public void addRoute(Route pRoute) {
		String vRequest = "INSERT INTO route (name, grade, height, note, name_sector) "
				+ "VALUES (:name, :grade, :height, :note, :nameSector)";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pRoute.getName(), Types.VARCHAR);
		vParams.addValue("grade", pRoute.getGrade(), Types.VARCHAR);
		vParams.addValue("height", pRoute.getHeight(), Types.INTEGER);
		vParams.addValue("note", pRoute.getNote(), Types.VARCHAR);
		vParams.addValue("nameSector", pRoute.getSector().getName(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}

}