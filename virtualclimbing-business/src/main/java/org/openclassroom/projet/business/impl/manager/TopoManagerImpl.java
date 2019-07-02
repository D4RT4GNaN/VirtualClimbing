package org.openclassroom.projet.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.openclassroom.projet.business.contract.manager.TopoManager;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;

@Named("topoManager")
public class TopoManagerImpl extends AbstractManager implements TopoManager {

	// ==============================================
	//                      Topo
	// ==============================================
	
	@Override
	public Topo getTopo(String pNameTopo) {
		Topo vTopo = getDaoFactory().getTopoDao().getTopo(pNameTopo);
		return vTopo;
	}

	@Override
	public List<Topo> searchTopo(String pKeyword) {
		List<Topo> vListTopo = null;
		if (pKeyword != null && pKeyword != "") {
			vListTopo = getDaoFactory().getTopoDao().searchTopo(pKeyword);
		} else {
			vListTopo = getDaoFactory().getTopoDao().getListTopo();
		}
		return vListTopo;
	}

	@Override
	public void addTopo(Topo pTopo) {
		getDaoFactory().getTopoDao().addTopo(pTopo);		
	}
	
	
	
	// ==============================================
	//                   Topo_Site
	// ==============================================
	
	@Override
	public List<Topo> getListTopoForSite(Site pSite) {
		List<Topo> vListTopo = getDaoFactory().getTopoDao().getListTopoForSite(pSite);
		return vListTopo;
	}
	
	@Override
	public List<Site> getListSiteForTopo(Topo pTopo) {
		List<Site> vListSite = getDaoFactory().getTopoDao().getListSiteForTopo(pTopo);
		return vListSite;
	}
	
	@Override
	public void addTopoSite(TopoSite pTopoSite) {
		getDaoFactory().getTopoDao().addTopoSite(pTopoSite);
	}
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	@Override
	public List<Site> searchSite(String pKeyword) {
		List<Site> vListSite = null;
		if (pKeyword.isEmpty())
			vListSite = getDaoFactory().getTopoDao().getListSite();
		else 
			vListSite = getDaoFactory().getTopoDao().searchSite(pKeyword);
		return vListSite;
	}
	
	@Override
	public void addSite(Site pSite) {
		getDaoFactory().getTopoDao().addSite(pSite);
	}
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	@Override
	public List<Sector> searchSector(String pKeyword) {
		List<Sector> vListSector = null;
		if (pKeyword.isEmpty())
			vListSector = getDaoFactory().getTopoDao().getListSector();
		else
			vListSector = getDaoFactory().getTopoDao().searchSector(pKeyword);
		return vListSector;
	}

	@Override
	public List<Sector> getListSectorForSite(Site pSite) {
		List<Sector> vListSector = getDaoFactory().getTopoDao().getListSectorForSite(pSite);
		return vListSector;
	}

	@Override
	public void addSector(Sector pSector) {
		getDaoFactory().getTopoDao().addSector(pSector);
	}

	
	
	// ==============================================
	//                      Route
	// ============================================== 

	@Override
	public List<Route> searchRoute(String pKeyword) {
		List<Route> vListRoute = null;
		if (pKeyword.isEmpty())
			vListRoute = getDaoFactory().getTopoDao().getListRoute();
		else
			vListRoute = getDaoFactory().getTopoDao().searchRoute(pKeyword);
		return vListRoute;
	}

	@Override
	public List<Route> getListRouteForSector(Sector pSector) {
		List<Route> vListRoute = getDaoFactory().getTopoDao().getListRouteForSector(pSector);
		return vListRoute;
	}

	@Override
	public void addRoute(Route pRoute) {
		getDaoFactory().getTopoDao().addRoute(pRoute);
	}
	
}
