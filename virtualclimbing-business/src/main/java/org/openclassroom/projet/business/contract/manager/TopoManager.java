package org.openclassroom.projet.business.contract.manager;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.openclassroom.projet.model.exception.NotFoundException;

public interface TopoManager {

	// ==============================================
	//                      Topo
	// ==============================================
	
	/**
	 * Get {@link Topo} with its name
	 * @param pNameTopo -
	 */
	Topo getTopo(String pNameTopo);
	
	/**
	 * Search and return all {@link Topo} containing the keyword if its not empty.
	 * Otherwise this return the complete list of {@link Topo}
	 * @param pKeyword -
	 */
	List<Topo> searchTopo(String pKeyword);
	
	/**
	 * Add a new {@link Topo}
	 * @param pTopo -
	 */
	void addTopo(Topo pTopo);
	
	
	
	// ==============================================
	//                    Topo_Site
	// ==============================================
	
	/**
	 * Return the list of {@link Topo} that contains the given {@link Site}
	 * @param pSite -
	 */
	List<Topo> getListTopoForSite(Site pSite);
	
	/**
	 * Return the list of {@link Site} in a {@link Topo}
	 * @param pTopo -
	 */
	List<Site> getListSiteForTopo(Topo pTopo);
	
	/**
	 * Add a new link between a {@link Topo} and a {@link Site}
	 * @param pTopoSite -
	 */
	void addTopoSite(TopoSite pTopoSite);
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	/**
	 * 
	 * @param pNameSite -
	 * @throws NotFoundException 
	 */
	Site getSite(String pNameSite) throws NotFoundException;
	
	/**
	 * Search and return the list of {@link Site} containing the keyword, if its not empty.
	 * Otherwise, this return the complete list of {@link Site}
	 * @param pKeyword -
	 */
	List<Site> searchSite(String pKeyword);
	
	/**
	 * Add a new {@link Site}
	 * @param pSite -
	 */
	void addSite(Site pSite);
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	/**
	 * 
	 * @param pNameSector -
	 * @throws NotFoundException
	 */
	Sector getSector(String pNameSector) throws NotFoundException;
	
	/**
	 * Search and return the list of {@link Sector} containing the keyword, if its not empty.
	 * Otherwise, this return the list of all {@link Sector}
	 * @param pKeyword -
	 */
	List<Sector> searchSector(String pKeyword);
	
	/**
	 * Return the list of {@link Sector} in a {@link Site}
	 * @param pSite -
	 */
	List<Sector> getListSectorForSite(Site pSite);
	
	/**
	 * Add a new {@link Sector}
	 * @param pSector -
	 */
	void addSector(Sector pSector);
	
	
	
	// ==============================================
	//                     Route
	// ==============================================
	
	/**
	 * Return the list of {@link Route} containing the keyword if its not empty.
	 * Otherwise, this return the complete list of {@link Route}
	 * @param pKeyword -
	 */
	List<Route> searchRoute(String pKeyword);
	
	/**
	 * Return the list of {@link Route} in a {@link Sector}
	 * @param pSector -
	 */
	List<Route> getListRouteForSector(Sector pSector);
	
	/**
	 * Add a new {@link Route}
	 * @param pRoute -
	 */
	void addRoute(Route pRoute);
	
}
