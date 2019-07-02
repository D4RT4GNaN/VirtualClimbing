package org.openclassroom.projet.webapp.action;

import java.util.List;

import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action displaying the overview of a {@link Topo}
 */
public class OverviewAction extends AbstractAction {

	// ==================== Attributes ====================
		// ----- Input parameter
		private String topoName; 
		
		// ----- Output elements
		Topo topo;
		List<Site> listSite;
		List<Sector> listSector;
		List<Route> listRoute;
		
		// ----- Struts elements
		
		
		
		
		// ==================== Getters/Setters ====================
		public String getTopoName() {
			return topoName;
		}
		public void setTopoName(String topoName) {
			this.topoName = topoName;
		}
		public Topo getTopo() {
			return topo;
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
		 * Action returning the overview of {@link Topo}
		 * @return success
		 */
		public String doDetailTopo() {
			topo = getManagerFactory().getTopoManager().getTopo(topoName);
			listSite = getManagerFactory().getTopoManager().getListSiteForTopo(topo);
			System.out.println("test2");
			return ActionSupport.SUCCESS;
		}
	
}
