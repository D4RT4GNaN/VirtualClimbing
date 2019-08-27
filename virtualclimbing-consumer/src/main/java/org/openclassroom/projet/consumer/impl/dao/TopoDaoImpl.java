package org.openclassroom.projet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.consumer.contract.dao.TopoDao;
import org.openclassroom.projet.consumer.impl.rowmapper.RouteRM;
import org.openclassroom.projet.consumer.impl.rowmapper.SectorRM;
import org.openclassroom.projet.consumer.impl.rowmapper.SiteRM;
import org.openclassroom.projet.consumer.impl.rowmapper.TopoRM;
import org.openclassroom.projet.consumer.impl.rowmapper.TopoSiteRM;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.springframework.dao.DuplicateKeyException;
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
		String vRequest = "SELECT * FROM topo WHERE private=false";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Topo> vListTopo = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListTopo;
	}

	@Override
	public List<Topo> searchTopo(String pKeyword) {
		String vRequest = "SELECT * FROM topo WHERE lower(name) LIKE lower(?) AND private=false";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Topo> vListTopo = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListTopo;
	}
	
	@Override
	public List<Topo> searchPrivateTopo() {
		String vRequest = "SELECT * FROM topo WHERE private=true";
		RowMapper<Topo> vRowMapper = new TopoRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Topo> vListTopo = vJdbcTemplate.query(vRequest, vRowMapper);
		
		return vListTopo;
	}
	
	@Override
	public void addTopo(Topo pTopo) throws FunctionalException {
		String vRequest = "INSERT INTO topo (name, official_web_site, description, pseudo, image_url, private, number_site) "
						+ "VALUES (:name, :officialWebSite, :description, :pseudo, :imageUrl, :private, :numberSite)";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pTopo.getName(), Types.VARCHAR);
		vParams.addValue("officialWebSite", pTopo.getOfficialWebSite(), Types.VARCHAR);
		vParams.addValue("description", pTopo.getDescription(), Types.VARCHAR);
		vParams.addValue("pseudo", pTopo.getUser().getPseudo(), Types.VARCHAR);
		vParams.addValue("imageUrl", pTopo.getImageUrl(), Types.VARCHAR);
		vParams.addValue("private", pTopo.getPrivateTopo(), Types.BOOLEAN);
		vParams.addValue("numberSite", pTopo.getNumberSite(), Types.INTEGER);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vNamedParameterJdbcTemplate.update(vRequest, vParams);
		} catch (DuplicateKeyException pEx) {
			throw new FunctionalException(getText("dao.topo.error.duplicateKey", pTopo.getName()));
		}
	}
	
	
	
	// ==============================================
	//                   Topo_Site
	// ==============================================
	
	@Override
	public List<TopoSite> getTopoSite(Site pSite) {
		String vRequest = "SELECT * FROM topo_site WHERE name_site = ?";
		RowMapper<TopoSite> vRowMapper = new TopoSiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<TopoSite> vListTopoSite = vJdbcTemplate.query(vRequest, vRowMapper, pSite.getName());
		
		return vListTopoSite;
	}
	
	@Override
	public List<TopoSite> getTopoSite(Topo pTopo) {
		String vRequest = "SELECT * FROM topo_site WHERE name_topo = ?";
		RowMapper<TopoSite> vRowMapper = new TopoSiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<TopoSite> vListTopoSite = vJdbcTemplate.query(vRequest, vRowMapper, pTopo.getName());
		
		return vListTopoSite;
	}
	
	@Override
	public void addTopoSite(TopoSite pTopoSite) throws FunctionalException {
		String vRequest = "INSERT INTO topo_site (name_topo, name_site) "
				+ "VALUES (:nameTopo, :nameSite)";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("nameTopo", pTopoSite.getTopo().getName(), Types.VARCHAR);
		vParams.addValue("nameSite", pTopoSite.getSite().getName(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vNamedParameterJdbcTemplate.update(vRequest, vParams);
		} catch (DuplicateKeyException pEx) {
			throw new FunctionalException(
					getText("dao.toposite.error.duplicateKey", pTopoSite.getTopo().getName(), pTopoSite.getSite().getName()));
		}
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
		String vRequest = "SELECT * FROM site WHERE lower(name) LIKE lower(?)";
		RowMapper<Site> vRowMapper = new SiteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Site> vListSite = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListSite;
	}
	
	@Override
	public void addSite(Site pSite) throws FunctionalException {
		String vRequest = "INSERT INTO public.site (name, image_url, latitude, longitude, location, access, rock_type, profil, anchorage, max_height, min_altitude, orientation, note, number_sector) "
		 			+ "VALUES (:name, :imageUrl, :latitude, :longitude, :location, :access, :rockType, :profil, :anchorage, :maxHeight, :minAltitude, :orientation, :note, :numberSector)";
		
		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pSite);
		vParams.registerSqlType("name", Types.VARCHAR);
		vParams.registerSqlType("imageUrl", Types.VARCHAR);
		vParams.registerSqlType("latitude", Types.DECIMAL);
		vParams.registerSqlType("longitude", Types.DECIMAL);
		vParams.registerSqlType("location", Types.VARCHAR);
		vParams.registerSqlType("access", Types.VARCHAR);
		vParams.registerSqlType("rockType", Types.VARCHAR);
		vParams.registerSqlType("profil", Types.VARCHAR);
		vParams.registerSqlType("anchorage", Types.VARCHAR);
		vParams.registerSqlType("maxHeight", Types.INTEGER);
		vParams.registerSqlType("minAltitude", Types.INTEGER);
		vParams.registerSqlType("orientation", Types.VARCHAR);
		vParams.registerSqlType("note", Types.VARCHAR);
		vParams.registerSqlType("numberSector", Types.INTEGER);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vNamedParameterJdbcTemplate.update(vRequest, vParams);
		} catch (DuplicateKeyException pEx) {
			throw new FunctionalException(getText("dao.site.error.duplicateKey", pSite.getName()));
		}
	}
	
	@Override
	public void updateNumberSector(Site pSite, int pNumberSector) {
		String vRequest = "UPADTE public.site SET number_sector=:numberSector WHERE name=:name";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pSite.getName(), Types.VARCHAR);
		vParams.addValue("numberSector", pNumberSector, Types.INTEGER);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vNamedParameterJdbcTemplate.update(vRequest, vParams);
	}


		
	// ==============================================
	//                     Sector
	// ==============================================

	@Override
	public Sector getSector(String pNameSector) {
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
		String vRequest = "SELECT * FROM sector WHERE lower(name) LIKE lower(?)";
		RowMapper<Sector> vRowMapper = new SectorRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Sector> vListSector = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		System.out.println(vListSector);
		return vListSector;
	}

	@Override
	public void addSector(Sector pSector) throws FunctionalException {
		String vRequest = "INSERT INTO sector (name, name_site, image_url, number_route) "
						+ "VALUES (:name, :nameSite, :imageUrl, :numberRoute)";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pSector.getName(), Types.VARCHAR);
		vParams.addValue("nameSite", pSector.getSite().getName(), Types.VARCHAR);
		vParams.addValue("imageUrl", pSector.getImageUrl(), Types.VARCHAR);
		vParams.addValue("numberRoute", pSector.getNumberRoute(), Types.INTEGER);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vNamedParameterJdbcTemplate.update(vRequest, vParams);
		} catch (DuplicateKeyException pEx) {
			throw new FunctionalException(getText("dao.sector.error.duplicateKey", pSector.getName()));
		}
	}
	
	@Override
	public void updateNumberRoute(Sector pSector, int numberRoute) {
		String vRequest = "UPDATE public.sector SET number_route=:numberRoute WHERE name=:name";
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pSector.getName(), Types.VARCHAR);
		vParams.addValue("numberRoute", numberRoute, Types.INTEGER);
		
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
		String vRequest = "SELECT * FROM route WHERE lower(name) LIKE lower(?)";
		RowMapper<Route> vRowMapper = new RouteRM();
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		List<Route> vListRoute = vJdbcTemplate.query(vRequest, vRowMapper, "%" + pKeyword + "%");
		
		return vListRoute;
	}

	@Override
	public void addRoute(Route pRoute) throws FunctionalException {
		String vRequest = "INSERT INTO route (name, grade, height, note, name_sector) "
				+ "VALUES (:name, :grade, :height, :note, :nameSector)";

		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("name", pRoute.getName(), Types.VARCHAR);
		vParams.addValue("grade", pRoute.getGrade(), Types.VARCHAR);
		vParams.addValue("height", pRoute.getHeight(), Types.INTEGER);
		vParams.addValue("note", pRoute.getNote(), Types.VARCHAR);
		vParams.addValue("nameSector", pRoute.getSector().getName(), Types.VARCHAR);
		
		NamedParameterJdbcTemplate vNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		try {
			vNamedParameterJdbcTemplate.update(vRequest, vParams);
		} catch (DuplicateKeyException pEx) {
			throw new FunctionalException(getText("dao.route.error.duplicateKey", pRoute.getName()));
		}
	}

}