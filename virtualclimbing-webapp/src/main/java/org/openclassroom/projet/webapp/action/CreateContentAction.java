package org.openclassroom.projet.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.openclassroom.projet.model.bean.user.User;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.openclassroom.projet.model.exception.NotFoundException;
import org.openclassroom.projet.model.exception.TechnicalException;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 */
public class CreateContentAction extends AbstractAction implements SessionAware {

	// ==================== Attributes ====================
	// ----- Input parameter
	private List<Site> listSite;
	private List<Sector> listSector;
	
	// ----- Output elements
	private Topo topo;
	private Site site;
	private Sector sector;
	private Route route;
	private File file;
	private String fileName;
	private String contentType;
	private List<String> checkboxSite;
	
	// ----- Struts elements
	private Map<String, Object> session;
	
	
	
	// ==================== Getters/Setters ====================
	public List<Site> getListSite() {
		return listSite;
	}
	public List<Sector> getListSector() {
		return listSector;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo pTopo) {
		topo = pTopo;
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
	public void setBanner(File pFile) {
		file = pFile;
	}
	public void setBannerFileName(String pFileName) {
		fileName = pFileName;
	}
	public void setBannerContentType(String pContentType) {
		contentType = pContentType;
	}
	public List<String> getCheckboxSite() {
		return checkboxSite;
	}
	public void setCheckboxSite(List<String> pCheckboxSite) {
		checkboxSite = pCheckboxSite;
	}
	@Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
	
	
	
	// ==================== Methods ====================		
	/**
	 * Called to load the creation page
	 * 
	 * @return success
	 */
	public String doCreateContent() {
		listSite = getManagerFactory().getTopoManager().getAllSite();
		listSector = getManagerFactory().getTopoManager().getAllSector();
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Get information of the form to create a new {@link Topo}
	 * And for all checkbox checked in form, it create a link between the new {@link Topo} and a checked {@link Site}
	 * 
	 * @return input / success / error
	 */
	public String doCreateTopo() {
		String vResult = ActionSupport.INPUT;
		
		if (topo != null) {
			String imageUrl = addNewFile();
			topo.setImageUrl(imageUrl);
			
			User vUser = (User) session.get("user");
			topo.setUser(vUser);
			
			topo.setNumberSite(checkboxSite.size());
			
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getTopoManager().addTopo(topo);
                    
                    for (String name: checkboxSite) {
						site = getManagerFactory().getTopoManager().getSite(name);
                    	TopoSite vTopoSite = new TopoSite(topo,site);
                    	getManagerFactory().getTopoManager().addTopoSite(vTopoSite);
                    }
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.create.topo.success"));

                } catch (NotFoundException pEx) {
                	this.addActionError(pEx.getMessage());
                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                } catch (TechnicalException pEx) {
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }
		
		if (vResult.equals(ActionSupport.INPUT)) {
			listSite = getManagerFactory().getTopoManager().getAllSite();
			listSector = getManagerFactory().getTopoManager().getAllSector();
		}
		
		return vResult;
	}
	
	/**
	 * Get information of the form to create a new {@link Site}
	 * 
	 * @return input / success / error
	 */
	public String doCreateSite() {
		String vResult = ActionSupport.INPUT;
		
		if (site != null) {
			String imageUrl = addNewFile();
			site.setImageUrl(imageUrl);
			
			site.setNumberSector(0);
			
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getTopoManager().addSite(site);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.create.site.success"));

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                } catch (TechnicalException pEx) {
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }
		
		if (vResult.equals(ActionSupport.INPUT)) {
			listSite = getManagerFactory().getTopoManager().getAllSite();
			listSector = getManagerFactory().getTopoManager().getAllSector();
		}
		
		return vResult;
	}

	/**
	 * Get information of the form to create a new {@link Sector}
	 * 
	 * @return input / success / error
	 */
	public String doCreateSector() {
		String vResult = ActionSupport.INPUT;
		
		if (this.sector != null) {
			String imageUrl = addNewFile();
			sector.setImageUrl(imageUrl);
			
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getTopoManager().addSector(sector);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.create.sector.success"));

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                } catch (TechnicalException pEx) {
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }
		
		if (vResult.equals(ActionSupport.INPUT)) {
			listSite = getManagerFactory().getTopoManager().getAllSite();
			listSector = getManagerFactory().getTopoManager().getAllSector();
		}
		
		System.out.println(vResult);
		return vResult;
	}
	
	/**
	 * Get information of the form to create a new {@link Route}
	 * 
	 * @return input / success / error
	 */
	public String doCreateRoute() {
		String vResult = ActionSupport.INPUT;
		
		if (this.route != null) {
			
            if (!this.hasErrors()) {
                try {
                    getManagerFactory().getTopoManager().addRoute(this.route);
                    
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage(getText("action.create.route.success"));

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());
                } catch (TechnicalException pEx) {
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }
		
		if (vResult.equals(ActionSupport.INPUT)) {
			listSite = getManagerFactory().getTopoManager().getAllSite();
			listSector = getManagerFactory().getTopoManager().getAllSector();
		}
		
		return vResult;
	}
	
	// private method
	private String addNewFile() {
		String imageUrl;
		
		if (file == null) {
			imageUrl = "images/781x250.svg";
		} else {
			imageUrl = "images/" + fileName;
			String newFile = ServletActionContext.getServletContext().getRealPath("/").concat(imageUrl);
			File destFile  = new File(newFile);
	        try {
				FileUtils.copyFile(file, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return imageUrl;
	}
	
}
