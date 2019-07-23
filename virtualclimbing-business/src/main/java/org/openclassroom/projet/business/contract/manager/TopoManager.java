package org.openclassroom.projet.business.contract.manager;

import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.openclassroom.projet.model.exception.NotFoundException;
import org.openclassroom.projet.model.exception.TechnicalException;

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
	 * Get the list of all private {@link Topo}
	 */
	List<Topo> searchPrivateTopo();
	
	/**
	 * Add a new {@link Topo}
	 * @param pTopo -
	 */
	void addTopo(Topo pTopo) throws TechnicalException, FunctionalException;
	
	
	
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
	void addTopoSite(TopoSite pTopoSite) throws TechnicalException, FunctionalException;
	
	
	
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
	 * 
	 * @param pSector -
	 * @throws NotFoundException
	 */
	Site getSiteForSector(Sector pSector) throws NotFoundException;
	
	/***/
	List<Site> getAllSite();
	
	/**
	 * Search and return the list of {@link Site} containing the keyword, if its not empty.
	 * Otherwise, this return the complete list of {@link Site}
	 * @param pKeyword -
	 */
	List<Site> searchSite(String pKeyword);
	
	/**
	 * Add a new {@link Site}
	 * @param pSite -
	 * @throws TechnicalException, FunctionalException
	 */
	void addSite(Site pSite) throws TechnicalException, FunctionalException;
	
	
	
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
	 * 
	 * @param pRoute -
	 * @throws NotFoundException
	 */
	Sector getSectorForRoute(Route pRoute) throws NotFoundException;
	
	/***/
	List<Sector> getAllSector();
	
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
	 * @throws TechnicalException, FunctionalException
	 */
	void addSector(Sector pSector) throws TechnicalException, FunctionalException;
	
	
	
	// ==============================================
	//                     Route
	// ==============================================
	
	/**
	 * 
	 * @param pNameRoute -
	 * @throws NotFoundException
	 */
	Route getRoute(String pNameRoute) throws NotFoundException;
	
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
	void addRoute(Route pRoute) throws TechnicalException, FunctionalException;
	
}
