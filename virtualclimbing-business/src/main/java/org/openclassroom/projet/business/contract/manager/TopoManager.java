package org.openclassroom.projet.business.contract.manager;

import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.model.bean.action.Filter;
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
	 * 
	 * @param pNameTopo -
	 * @return {@link Topo}
	 */
	Topo getTopo(String pNameTopo);
	
	/**
	 * Search and return all {@link Topo} containing the keyword if its not empty.
	 * Otherwise this return the complete list of {@link Topo}
	 * 
	 * @param pKeyword -
	 * @return List<{@link Topo}>
	 */
	List<Topo> searchTopo(String pKeyword);
	
	/**
	 * Get the list of all private {@link Topo}
	 * 
	 * @return List<{@link Topo}>
	 */
	List<Topo> searchPrivateTopo();
	
	/**
	 * Add a new {@link Topo}
	 * 
	 * @param pTopo -
	 */
	void addTopo(Topo pTopo) throws TechnicalException, FunctionalException;
	
	/**
	 * Get a list of {@link Topo} and remove from it anything that does not fit the {@link Filter} criteria
	 * 
	 * @param pListTopo -
	 * @param pFilter -
	 * @return List<{@link Topo}>
	 */
	List<Topo> filterTopo(List<Topo> pListTopo, Filter pFilter);
	
	
	
	// ==============================================
	//                    Topo_Site
	// ==============================================
	
	/**
	 * Return the list of {@link Topo} that contains the given {@link Site}
	 * 
	 * @param pSite -
	 * @return List<{@link Topo}>
	 */
	List<Topo> getListTopoForSite(Site pSite);
	
	/**
	 * Return the list of {@link Site} in a {@link Topo}
	 * 
	 * @param pTopo -
	 * @return List<{@link Site}>
	 */
	List<Site> getListSiteForTopo(Topo pTopo);
	
	/**
	 * Add a new link between a {@link Topo} and a {@link Site}
	 * 
	 * @param pTopoSite -
	 */
	void addTopoSite(TopoSite pTopoSite) throws TechnicalException, FunctionalException;
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	/**
	 * Get a {@link Site} with its name
	 * 
	 * @param pNameSite -
	 * @return {@link Site}
	 */
	Site getSite(String pNameSite) throws NotFoundException;
	
	/**
	 * Get a {@link Site} from a {@link Sector} it contains
	 * 
	 * @param pSector -
	 * @return {@link Site}
	 */
	Site getSiteForSector(Sector pSector) throws NotFoundException;
	
	/**
	 * Get all {@link Site} from database
	 * 
	 * @return List<{@link Site}>
	 */
	List<Site> getAllSite();
	
	/**
	 * Search and return the list of {@link Site} containing the keyword, if its not empty.
	 * Otherwise, this return the complete list of {@link Site}
	 * 
	 * @param pKeyword -
	 * @return List<{@link Site}>
	 */
	List<Site> searchSite(String pKeyword);
	
	/**
	 * Add a new {@link Site}
	 * 
	 * @param pSite -
	 */
	void addSite(Site pSite) throws TechnicalException, FunctionalException;
	
	/**
	 * Get a list of {@link Site} and remove from it anything that does not fit the {@link Filter} criteria
	 * 
	 * @param pListSite -
	 * @param pFilter -
	 * @return List<{@link Site}>
	 */
	List<Site> filterSite(List<Site> pListSite, Filter pFilter);
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	/**
	 * Get a {@link Sector} with its name
	 * 
	 * @param pNameSector -
	 * @return {@link Sector}
	 */
	Sector getSector(String pNameSector) throws NotFoundException;
	
	/**
	 * Get a {@link Sector} from a {@link Route} it contains
	 * 
	 * @param pRoute -
	 * @return {@link Sector}
	 */
	Sector getSectorForRoute(Route pRoute) throws NotFoundException;
	
	/**
	 * Get all {@link Sector} in database
	 * 
	 * @return List<{@link Sector}>
	 */
	List<Sector> getAllSector();
	
	/**
	 * Search and return the list of {@link Sector} containing the keyword, if its not empty.
	 * Otherwise, this return the list of all {@link Sector}
	 * 
	 * @param pKeyword -
	 * @return List<{@link Sector}>
	 */
	List<Sector> searchSector(String pKeyword);
	
	/**
	 * Return the list of {@link Sector} in a {@link Site}
	 * 
	 * @param pSite -
	 * @return List<{@link Sector}>
	 */
	List<Sector> getListSectorForSite(Site pSite);
	
	/**
	 * Add a new {@link Sector}
	 * 
	 * @param pSector -
	 */
	void addSector(Sector pSector) throws TechnicalException, FunctionalException;
	
	/**
	 * Get a list of {@link Sector} and remove from it anything that does not fit the {@link Filter} criteria
	 * 
	 * @param pListSector -
	 * @param pFilter -
	 * @return List<{@link Sector}>
	 */
	List<Sector> filterSector(List<Sector> pListSector, Filter pFilter);
	
	
	
	// ==============================================
	//                     Route
	// ==============================================
	
	/**
	 * Get a {@link Route} with its name
	 * 
	 * @param pNameRoute -
	 * @return {@link Route}
	 */
	Route getRoute(String pNameRoute) throws NotFoundException;
	
	/**
	 * Return the list of {@link Route} containing the keyword if its not empty.
	 * Otherwise, this return the complete list of {@link Route}
	 * 
	 * @param pKeyword -
	 * @return List<{@link Route}>
	 */
	List<Route> searchRoute(String pKeyword);
	
	/**
	 * Return the list of {@link Route} in a {@link Sector}
	 * 
	 * @param pSector -
	 * @return List<{@link Route}>
	 */
	List<Route> getListRouteForSector(Sector pSector);
	
	/**
	 * Add a new {@link Route}
	 * 
	 * @param pRoute -
	 */
	void addRoute(Route pRoute) throws TechnicalException, FunctionalException;
	
}
