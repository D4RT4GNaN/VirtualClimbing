package org.openclassroom.projet.webapp.action;

import java.util.List;

import org.openclassroom.projet.model.bean.action.Filter;
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
	private List<Topo> listTopo;
	private List<Site> listSite;
	private List<Sector> listSector;
	private List<Route> listRoute;
	private Filter filter;
	
	
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
	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	
	
	// ==================== Methods ====================
	/**
	 * Action returning the list of {@link Topo}, {@link Site}, {@link Sector} and {@link Route}
	 * whose the name contains the keyword entered in the search bar.
	 * 
	 * @return success
	 */
	public String doResearch() {
		fillListResearch();
		filter = new Filter();
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Reload the search page taking into account the new {@link Filter}
	 * 
	 * @return success
	 */
	public String doFilter() {
		fillListResearch();
		
		listTopo = getManagerFactory().getTopoManager().filterTopo(listTopo, filter);
		listSite = getManagerFactory().getTopoManager().filterSite(listSite, filter);
		listSector = getManagerFactory().getTopoManager().filterSector(listSector, filter);
		listRoute = getManagerFactory().getTopoManager().searchRoute(keyword);
		return ActionSupport.SUCCESS;
	}
	
	// private method
	private void fillListResearch() {
		listTopo = getManagerFactory().getTopoManager().searchTopo(keyword);
		listSite = getManagerFactory().getTopoManager().searchSite(keyword);
		listSector = getManagerFactory().getTopoManager().searchSector(keyword);
		listRoute = getManagerFactory().getTopoManager().searchRoute(keyword);
	}

}
