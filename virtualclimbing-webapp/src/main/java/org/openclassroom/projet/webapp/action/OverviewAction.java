package org.openclassroom.projet.webapp.action;

import java.util.ArrayList;
import java.util.List;

import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.exception.NotFoundException;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action displaying the overview of a {@link Topo}
 */
public class OverviewAction extends AbstractAction {

	// ==================== Attributes ====================
		// ----- Input parameter
		private String name;
		private Site site;
		private Sector sector;
		private Route route;
		
		// ----- Output elements
		Topo topo;
		List<Site> listSite;
		List<Sector> listSector;
		List<Route> listRoute;
		List<Comment> listComment;
		
		// ----- Struts elements
		
		
		
		
		// ==================== Getters/Setters ====================
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Site getSite() {
			return site;
		}
		public void setSite(Site pSite) {
			site = pSite;
		}
		public Sector getSector() {
			return sector;
		}
		public void setSector(Sector pSector) {
			sector = pSector;
		}
		public Route getRoute() {
			return route;
		}
		public void setRoute(Route pRoute) {
			route = pRoute;
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
		public List<Comment> getListComment() {
			return listComment;
		}
		
		
		
		// ==================== Methods ====================		
		/**
		 * Action returning the overview of {@link Topo}
		 * 
		 * @return success
		 */
		public String doDetailTopo() {
			topo = getManagerFactory().getTopoManager().getTopo(name);
			listSite = getManagerFactory().getTopoManager().getListSiteForTopo(topo);
			if (!listSite.isEmpty()) {
				listSector = getManagerFactory().getTopoManager().getListSectorForSite(listSite.get(0));
				if (!listSector.isEmpty()) {
					listRoute = getManagerFactory().getTopoManager().getListRouteForSector(listSector.get(0));
					listComment = getManagerFactory().getActionManager().getListComment(listSector.get(0));
				}
			} else {
				listSector = new ArrayList<>();
				listComment = new ArrayList<>();
			}
			
			return ActionSupport.SUCCESS;
		}
		
		/**
		 * Action returning the overview of {@link Site}
		 * 
		 * @return success / error
		 */
		public String doDetailSite() {
			try {
				site = getManagerFactory().getTopoManager().getSite(name);
				listSector = getManagerFactory().getTopoManager().getListSectorForSite(site);
				if (!listSector.isEmpty()) {
					sector = listSector.get(0);
					listRoute = getManagerFactory().getTopoManager().getListRouteForSector(sector);
					listComment = getManagerFactory().getActionManager().getListComment(sector);
				}
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
			
			return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
		
		/**
		 * Action returning the overview of {@link Sector}
		 * 
		 * @return success / error
		 */
		public String doDetailSector() {
			try {
				sector = getManagerFactory().getTopoManager().getSector(name);
				site = getManagerFactory().getTopoManager().getSiteForSector(sector);
				listSector = getManagerFactory().getTopoManager().getListSectorForSite(site);
				listRoute = getManagerFactory().getTopoManager().getListRouteForSector(sector);
				listComment = getManagerFactory().getActionManager().getListComment(sector);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
			
			return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
		
		/**
		 * Action returning the overview of {@link Route}
		 * 
		 * @return success / error
		 */
		public String doDetailRoute() {
			try {
				route = getManagerFactory().getTopoManager().getRoute(name);
				sector = getManagerFactory().getTopoManager().getSectorForRoute(route);
				site = getManagerFactory().getTopoManager().getSiteForSector(sector);
				listSector = getManagerFactory().getTopoManager().getListSectorForSite(site);
				listRoute = getManagerFactory().getTopoManager().getListRouteForSector(sector);
				listComment = getManagerFactory().getActionManager().getListComment(sector);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
			
			return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
		
		/**
		 * Action changing the overview data when a new {@link Site} was selected on select tag
		 * 
		 * @return success / error
		 */
		public String doAjaxOnSelectSite() {
			if (site == null) {
	            addActionError("action.detail.ajax.error.site.null");
	        } else {
	            listSector = getManagerFactory().getTopoManager().getListSectorForSite(site);
	        }

	        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}

		/**
		 * Action changing the overview data when a new {@link Sector} was selected on select tag
		 * 
		 * @return success / error
		 */
		public String doAjaxOnSelectSector() {
			if (sector == null) {
	            addActionError(getText("action.detail.ajax.error.sector.null"));
	        } else {
	            listRoute = getManagerFactory().getTopoManager().getListRouteForSector(sector);
	            listComment = getManagerFactory().getActionManager().getListComment(sector);
	        }

	        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
	
}
