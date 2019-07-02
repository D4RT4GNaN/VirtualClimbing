package org.openclassroom.projet.webapp.action;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action returning the search page with result 
 * of {@link Topo}, {@link Site}, {@link Sector} and {@link Route}
 */
public class SearchAction extends AbstractAction {

	// ==================== Attributes ====================
	// ----- Input parameter
	private String keyword; 
	
	// ----- Output elements
	List<Topo> listTopo;
	List<Site> listSite;
	List<Sector> listSector;
	List<Route> listRoute;
	
	// ----- Struts elements
	
	
	
	
	// ==================== Getters/Setters ====================
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Topo> getListTopo() {
		return listTopo;
	}
	public List<Site> getListSite() {
		return listSite;
	}
	public List<Sector> getListSector() {
		return listSector;
	}
	public List<Route> getListRoute() {
		return listRoute;
	}
	
	
	
	// ==================== Methods ====================
	/**
	 * Action returning the list of {@link Topo}, {@link Site}, {@link Sector} and {@link Route}
	 * whose the name contains the keyword entered in the search bar.
	 * @return success
	 */
	public String doResearch() {
		listTopo = getManagerFactory().getTopoManager().searchTopo(keyword);
		listSite = getManagerFactory().getTopoManager().searchSite(keyword);
		listSector = getManagerFactory().getTopoManager().searchSector(keyword);
		listRoute = getManagerFactory().getTopoManager().searchRoute(keyword);
		return ActionSupport.SUCCESS;
	}

}