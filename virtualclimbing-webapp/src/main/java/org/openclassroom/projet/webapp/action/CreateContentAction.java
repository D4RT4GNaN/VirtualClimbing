package org.openclassroom.projet.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
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
public class CreateContentAction extends AbstractAction {

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
	
	
	
	
	// ==================== Methods ====================		
	/***/
	public String doCreateContent() {
		listSite = getManagerFactory().getTopoManager().getAllSite();
		listSector = getManagerFactory().getTopoManager().getAllSector();
		return ActionSupport.SUCCESS;
	}
	
	/***/
	public String doCreateTopo() {
		String vResult = ActionSupport.INPUT;
		
		if (topo != null) {
			String imageUrl = addNewFile();
			topo.setImageUrl(imageUrl);
			
			User vUser = new User();
			vUser.setPseudo("User1");
			topo.setUser(vUser);
			
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
	
	/***/
	public String doCreateSite() {
		String vResult = ActionSupport.INPUT;
		
		if (site != null) {
			String imageUrl = addNewFile();
			site.setImageUrl(imageUrl);
			
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

	/***/
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
	
	/***/
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
