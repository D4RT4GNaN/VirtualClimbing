package org.openclassroom.projet.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.openclassroom.projet.model.bean.action.Comment;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.openclassroom.projet.model.exception.NotFoundException;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action displaying the overview of a {@link Topo}
 */
public class CommentAction extends AbstractAction implements SessionAware {

	// ==================== Attributes ====================
	// ----- Input parameter
	private Comment comment;
	private Topo topo;
	private String name;
	
	// ----- Output elements
	private Site site;
	private Sector sector;
	private List<Site> listSite;
	private List<Sector> listSector;
	private List<Route> listRoute;
	private List<Comment> listComment;
	
	// ----- Struts elements
	private Map<String, Object> session;
	
	
	
	// ==================== Getters/Setters ====================
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment pComment) {
		comment = pComment;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo pTopo) {
		topo = pTopo;
	}
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		name = pName;
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
	public List<Site> getListSite() {
		return listSite;
	}
	public void setListSite(List<Site> pListSite) {
		listSite = pListSite;
	}
	public List<Sector> getListSector() {
		return listSector;
	}
	public void setListSector(List<Sector> pListSector) {
		listSector = pListSector;
	}
	public List<Route> getListRoute() {
		return listRoute;
	}
	public void setListRoute(List<Route> pListRoute) {
		listRoute = pListRoute;
	}
	public List<Comment> getListComment() {
		return listComment;
	}
	public void setListComment(List<Comment> pListComment) {
		listComment = pListComment;
	}
	@Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
	
	
	
	// ==================== Methods ====================		
	/**
	 * Return the current page after post a {@link Comment}
	 * 
	 * @return success / error
	 */
	public String doDetailComment() {
		if (name != null && name != "") {
			topo = getManagerFactory().getTopoManager().getTopo(name);
			listSite = getManagerFactory().getTopoManager().getListSiteForTopo(topo);
		}
		String vSectorName = sector.getName();
		this.fillContent(vSectorName);
		
		return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	/**
	 * Post a {@link Comment} on a page
	 * 
	 * @return input / success
	 */
	public String doSendComment() {
		String vResult = ActionSupport.INPUT;
		
		if (comment != null) {
			
			User vUser = (User) session.get("user");
			comment.setUser(vUser);
			
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getActionManager().addComment(comment);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.comment.success"));

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                }
            }
		}
		
		if (vResult.equals(ActionSupport.INPUT)) {
			String vSectorName = comment.getSector().getName();
			
			if(!topo.isEmpty()) {
				listSite = getManagerFactory().getTopoManager().getListSiteForTopo(topo);
			}
			
			this.fillContent(vSectorName);
		}
		
		return vResult;
	}
	
	// Private method
	private void fillContent(String pSectorName) {
		try {
			sector = getManagerFactory().getTopoManager().getSector(pSectorName);
			site = getManagerFactory().getTopoManager().getSiteForSector(sector);
			listSector = getManagerFactory().getTopoManager().getListSectorForSite(site);
			listRoute = getManagerFactory().getTopoManager().getListRouteForSector(sector);
			listComment = getManagerFactory().getActionManager().getListComment(sector);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
}
