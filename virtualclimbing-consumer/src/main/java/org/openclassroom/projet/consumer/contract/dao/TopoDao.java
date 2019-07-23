package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;

/**
 * DAO Interface of package
 * {@link org.openclassroom.projet.model.bean.topo}
 */
public interface TopoDao {
	
	// ==============================================
	//                      Topo
	// ==============================================
	
	/**
	 * Get {@link Topo} with its name in the database
	 * @param pNameTopo -
	 */
	Topo getTopo(String pNameTopo);
	
	/**
	 * Get a list of all {@link Topo} in the database
	 */
	List<Topo> getListTopo();
	
	/**
	 * Search and return all public {@link Topo} containing the keyword in the database
	 * @param pKeyword -
	 */
	List<Topo> searchTopo(String pKeyword);
	
	/**
	 * Search and return all private {@link Topo} in the database
	 */
	List<Topo> searchPrivateTopo();
	
	/**
	 * Add {@link Topo} in database
	 * @param pTopo -
	 */
	void addTopo(Topo pTopo);
	
	
	
	// ==============================================
	//                   Topo_Site
	// ==============================================
	
	/**
	 * Get a list of all {@link Topo} that contains the {@link Site}, in the database
	 * @param pSite -
	 */
	List<TopoSite> getTopoSite(Site pSite);
	
	/**
	 * Get a list of all {@link Site} in a {@link Topo}, in the database
	 * @param pTopo -
	 */
	List<TopoSite> getTopoSite(Topo pTopo);
	
	/**
	 * Add a new link between {@link Topo} and {@link Site} in database
	 * @param pTopo -
	 * @param pSite -
	 */
	void addTopoSite(TopoSite pTopoSite);
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	/**
	 * Get {@link Site} in database by giving it its name
	 * @param pNameSite -
	 */
	Site getSite(String pNameSite);
	
	/**
	 * Get the list of all {@link Site} in database
	 */
	List<Site> getListSite();
	
	/**
	 * Get a list of {@link Site} whose name contains the keyword
	 * @param pKeyword -
	 */
	List<Site> searchSite(String pKeyword);
	
	/**
	 * Adding a {@link Site} in database
	 * @param pSite -
	 */
	void addSite(Site pSite);
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	/**
	 * Get {@link Sector} in database by giving it its name
	 * @param pNameSector -
	 */
	Sector getSector(String pNameSector);
	
	/**
	 * Get the list of all {@link Sector} in database
	 */
	List<Sector> getListSector();
	
	/**
	 * Search and return the list of {@link Sector} in a {@link Site}
	 * @param pSite -
	 */
	List<Sector> getListSectorForSite(Site pSite);
	
	/**
	 * Get a list of {@link Sector} whose name contains the keyword
	 * @param pKeyword -
	 */
	List<Sector> searchSector(String pKeyword);
	
	/**
	 * Adding a {@link Sector} in database
	 * @param pSector -
	 */
	void addSector(Sector pSector);
	
	
	
	// ==============================================
	//                     Route
	// ==============================================
	
	/**
	 * Get {@link Route} in database by giving it its name
	 * @param pNameRoute -
	 */
	Route getRoute(String pNameRoute);
	
	/**
	 * Get the list of all {@link Route} in database
	 */
	List<Route> getListRoute();
	
	/**
	 * Search and return the list of {@link Route} in a {@link Sector}
	 * @param pSector -
	 */
	List<Route> getListRouteForSector(Sector pSector);
	
	/**
	 * Get a list of {@link Route} whose name contains the keyword
	 * @param pKeyword -
	 */
	List<Route> searchRoute(String pKeyword);
	
	/**
	 * Adding a {@link Route} in database
	 * @param pRoute -
	 */
	void addRoute(Route pRoute);
	
}