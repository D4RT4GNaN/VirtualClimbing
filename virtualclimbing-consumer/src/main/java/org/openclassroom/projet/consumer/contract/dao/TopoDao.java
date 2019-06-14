package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;

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
	 * Search and return all {@link Topo} containing the keyword in the database
	 * @param pKeyword -
	 */
	List<Topo> searchTopo(String pKeyword);
	
	/**
	 * Add {@link Topo} in database
	 * @param pTopo -
	 */
	void addTopo(Topo pTopo);
	
	
	
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
	
}