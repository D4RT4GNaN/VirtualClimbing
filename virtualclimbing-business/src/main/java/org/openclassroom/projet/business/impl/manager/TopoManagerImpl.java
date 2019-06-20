package org.openclassroom.projet.business.impl.manager;

import java.util.List;

import org.openclassroom.projet.business.contract.manager.TopoManager;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;

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
		if (pKeyword != null && pKeyword != "")
			vListTopo = getDaoFactory().getTopoDao().searchTopo(pKeyword);
		else
			vListTopo = getDaoFactory().getTopoDao().getListTopo();
		return vListTopo;
	}

	@Override
	public void addTopo(Topo pTopo) {
		getDaoFactory().getTopoDao().addTopo(pTopo);		
	}
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	@Override
	public List<Sector> searchSector(String pKeyword) {
		List<Sector> vListSector = null;
		if (pKeyword.isEmpty())
			vListSector = getDaoFactory().getTopoDao().searchSector(pKeyword);
		else
			vListSector = getDaoFactory().getTopoDao().getListSector();
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
