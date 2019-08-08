package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.openclassroom.projet.model.exception.FunctionalException;

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
	 * 
	 * @param pNameTopo -
	 * @return {@link Topo}
	 */
	Topo getTopo(String pNameTopo);
	
	/**
	 * Get a list of all {@link Topo} in the database
	 * 
	 * @return List<{@link Topo}>
	 */
	List<Topo> getListTopo();
	
	/**
	 * Search and return all public {@link Topo} containing the keyword in the database
	 * 
	 * @param pKeyword -
	 * @return List<{@link Topo}>
	 */
	List<Topo> searchTopo(String pKeyword);
	
	/**
	 * Search and return all private {@link Topo} in the database
	 * 
	 * @return List<{@link Topo}>
	 */
	List<Topo> searchPrivateTopo();
	
	/**
	 * Add {@link Topo} in database
	 * 
	 * @param pTopo -
	 */
	void addTopo(Topo pTopo) throws FunctionalException;
	
	
	
	// ==============================================
	//                   Topo_Site
	// ==============================================
	
	/**
	 * Get a list of all {@link Topo} that contains the {@link Site}, in the database
	 * 
	 * @param pSite -
	 * @return List<{@link TopoSite}>
	 */
	List<TopoSite> getTopoSite(Site pSite);
	
	/**
	 * Get a list of all {@link Site} in a {@link Topo}, in the database
	 * 
	 * @param pTopo -
	 * @return List<{@link TopoSite}>
	 */
	List<TopoSite> getTopoSite(Topo pTopo);
	
	/**
	 * Add a new link between {@link Topo} and {@link Site} in database
	 * 
	 * @param pTopoSite -
	 */
	void addTopoSite(TopoSite pTopoSite) throws FunctionalException;
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	/**
	 * Get {@link Site} in database by giving it its name
	 * 
	 * @param pNameSite -
	 * @return {@link Site}
	 */
	Site getSite(String pNameSite);
	
	/**
	 * Get the list of all {@link Site} in database
	 * 
	 * @return List<{@link Site}>
	 */
	List<Site> getListSite();
	
	/**
	 * Get a list of {@link Site} whose name contains the keyword
	 * 
	 * @param pKeyword -
	 * @return List<{@link Site}>
	 */
	List<Site> searchSite(String pKeyword);
	
	/**
	 * Adding a {@link Site} in database
	 * 
	 * @param pSite -
	 */
	void addSite(Site pSite) throws FunctionalException;
	
	/**
	 * Increase the number of {@link Sector} contained in a {@link Site}
	 * 
	 * @param pSite -
	 * @param pNumberSector -
	 */
	void updateNumberSector(Site pSite, int pNumberSector);
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	/**
	 * Get {@link Sector} in database by giving it its name
	 * 
	 * @param pNameSector -
	 * @return {@link Sector}
	 */
	Sector getSector(String pNameSector);
	
	/**
	 * Get the list of all {@link Sector} in database
	 * 
	 * @return List<{@link Sector}>
	 */
	List<Sector> getListSector();
	
	/**
	 * Search and return the list of {@link Sector} in a {@link Site}
	 * 
	 * @param pSite -
	 * @return List<{@link Sector}>
	 */
	List<Sector> getListSectorForSite(Site pSite);
	
	/**
	 * Get a list of {@link Sector} whose name contains the keyword
	 * 
	 * @param pKeyword -
	 * @return List<{@link Sector}>
	 */
	List<Sector> searchSector(String pKeyword);
	
	/**
	 * Adding a {@link Sector} in database
	 * 
	 * @param pSector -
	 */
	void addSector(Sector pSector) throws FunctionalException;
	
	/**
	 * Increase the number of {@link Route} contained in a {@link Sector}
	 * 
	 * @param pSector -
	 * @param pNumberRoute -
	 */
	void updateNumberRoute(Sector pSector, int numberRoute);
	
	
	
	// ==============================================
	//                     Route
	// ==============================================
	
	/**
	 * Get {@link Route} in database by giving it its name
	 * 
	 * @param pNameRoute -
	 * @return {@link Route}
	 */
	Route getRoute(String pNameRoute);
	
	/**
	 * Get the list of all {@link Route} in database
	 * 
	 * @return List<{@link Route}>
	 */
	List<Route> getListRoute();
	
	/**
	 * Search and return the list of {@link Route} in a {@link Sector}
	 * 
	 * @param pSector -
	 * @return List<{@link Route}>
	 */
	List<Route> getListRouteForSector(Sector pSector);
	
	/**
	 * Get a list of {@link Route} whose name contains the keyword
	 * 
	 * @param pKeyword -
	 * @return List<{@link Route}>
	 */
	List<Route> searchRoute(String pKeyword);
	
	/**
	 * Adding a {@link Route} in database
	 * 
	 * @param pRoute -
	 */
	void addRoute(Route pRoute) throws FunctionalException;
	
}