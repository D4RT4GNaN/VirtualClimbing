package org.openclassroom.projet.consumer.contract.dao;

import java.util.List;

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
	 * Get {@link Topo} with his name in the database
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
	
}