package org.openclassroom.projet.business.contract.manager;

import java.util.List;

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
	
}
