package org.openclassroom.projet.business.contract.manager;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;

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
	//                     Sector
	// ==============================================
	
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
