package org.openclassroom.projet.business.impl.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.openclassroom.projet.business.contract.manager.TopoManager;
import org.openclassroom.projet.model.bean.topo.Route;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.bean.topo.Topo;
import org.openclassroom.projet.model.bean.topo.TopoSite;
import org.openclassroom.projet.model.exception.FunctionalException;
import org.openclassroom.projet.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("topoManager")
public class TopoManagerImpl extends AbstractManager implements TopoManager {

	@Inject
	@Named("txManagerProjet")
	private PlatformTransactionManager platformTransactionManager;
	
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
		if (pKeyword != null && !pKeyword.isEmpty()) {
			vListTopo = getDaoFactory().getTopoDao().searchTopo(pKeyword);
		} else {
			vListTopo = getDaoFactory().getTopoDao().getListTopo();
		}
		return vListTopo;
	}
	
	@Override
	public List<Topo> searchPrivateTopo() {
		List<Topo> vListTopo = getDaoFactory().getTopoDao().searchPrivateTopo();
		return vListTopo;
	}

	@Override
	public void addTopo(Topo pTopo) throws FunctionalException {
		if (pTopo == null) {
            throw new FunctionalException(resourceBundle.getString("manager.topo.error.null"));
        }

        Set<ConstraintViolation<Topo>> vViolations = getConstraintValidator().validate(pTopo);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException(resourceBundle.getString("manager.topo.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getTopoDao().addTopo(pTopo);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	    } finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	}
	
	
	
	// ==============================================
	//                   Topo_Site
	// ==============================================
	
	@Override
	public List<Topo> getListTopoForSite(Site pSite) {
		List<TopoSite> vListTopoSite = getDaoFactory().getTopoDao().getTopoSite(pSite);
		List<Topo> vListTopo = new ArrayList<>();
		
		for (TopoSite pTopoSite : vListTopoSite) {
			Topo vTopo = pTopoSite.getTopo();
			vListTopo.add(vTopo);
		}
		
		return vListTopo;
	}
	
	@Override
	public List<Site> getListSiteForTopo(Topo pTopo) {		
		List<TopoSite> vListTopoSite = getDaoFactory().getTopoDao().getTopoSite(pTopo);
		List<Site> vListSite = new ArrayList<>();
		
		for (TopoSite pTopoSite : vListTopoSite) {
			String nameSite = pTopoSite.getSite().getName();
			Site vSite = getDaoFactory().getTopoDao().getSite(nameSite);
			vListSite.add(vSite);
		}
		
		return vListSite;
	}
	
	@Override
	public void addTopoSite(TopoSite pTopoSite) throws FunctionalException {
		if (pTopoSite == null) {
            throw new FunctionalException(resourceBundle.getString("manager.toposite.error.null"));
        }

        Set<ConstraintViolation<TopoSite>> vViolations = getConstraintValidator().validate(pTopoSite);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException(resourceBundle.getString("manager.toposite.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getTopoDao().addTopoSite(pTopoSite);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	    } finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	}
	
	
	
	// ==============================================
	//                      Site
	// ==============================================
	
	@Override
	public Site getSite(String pNameSite) throws NotFoundException {
		Site vSite = getDaoFactory().getTopoDao().getSite(pNameSite);
		return vSite;
	}
	
	@Override
	public Site getSiteForSector(Sector pSector) throws NotFoundException {
		String vNameSite = pSector.getSite().getName();
		Site vSite = getDaoFactory().getTopoDao().getSite(vNameSite);
		return vSite;
	}
	
	@Override
	public List<Site> getAllSite() {
		List<Site> vListSite = getDaoFactory().getTopoDao().getListSite();
		return vListSite;
	}
	
	@Override
	public List<Site> searchSite(String pKeyword) {
		List<Site> vListSite = null;
		if (pKeyword != null && !pKeyword.isEmpty())
			vListSite = getDaoFactory().getTopoDao().getListSite();
		else 
			vListSite = getDaoFactory().getTopoDao().searchSite(pKeyword);
		return vListSite;
	}
	
	@Override
	public void addSite(Site pSite) throws FunctionalException {
		if (pSite == null) {
            throw new FunctionalException(resourceBundle.getString("manager.site.error.null"));
        }

        Set<ConstraintViolation<Site>> vViolations = getConstraintValidator().validate(pSite);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException(resourceBundle.getString("manager.site.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getTopoDao().addSite(pSite);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	    } finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	}
	
	
	
	// ==============================================
	//                     Sector
	// ==============================================
	
	@Override
	public Sector getSector(String pNameSector) throws NotFoundException {
		Sector vSector = getDaoFactory().getTopoDao().getSector(pNameSector);
		return vSector;
	}
	
	@Override
	public Sector getSectorForRoute(Route pRoute) {
		String vNameSector = pRoute.getSector().getName();
		Sector vSector = getDaoFactory().getTopoDao().getSector(vNameSector);
		return vSector;
	}
	
	@Override
	public List<Sector> getAllSector() {
		List<Sector> vListSector = getDaoFactory().getTopoDao().getListSector();
		return vListSector;
	}
	
	@Override
	public List<Sector> searchSector(String pKeyword) {
		List<Sector> vListSector = null;
		if (pKeyword != null && !pKeyword.isEmpty())
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
	public void addSector(Sector pSector) throws FunctionalException {
		if (pSector == null) {
            throw new FunctionalException(resourceBundle.getString("manager.sector.error.null"));
        }

        Set<ConstraintViolation<Sector>> vViolations = getConstraintValidator().validate(pSector);
        if (!vViolations.isEmpty() || pSector.getSite().getName().isEmpty()) {
            throw new FunctionalException(resourceBundle.getString("manager.sector.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getTopoDao().addSector(pSector);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	    } finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	}

	
	
	// ==============================================
	//                      Route
	// ============================================== 

	@Override
	public Route getRoute(String pNameRoute) throws NotFoundException {
		Route vRoute = getDaoFactory().getTopoDao().getRoute(pNameRoute);
		return vRoute;
	}
	
	@Override
	public List<Route> searchRoute(String pKeyword) {
		List<Route> vListRoute = null;
		if (pKeyword != null && !pKeyword.isEmpty())
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
	public void addRoute(Route pRoute) throws FunctionalException {
		if (pRoute == null) {
            throw new FunctionalException(resourceBundle.getString("manager.route.error.null"));
        }

        Set<ConstraintViolation<Route>> vViolations = getConstraintValidator().validate(pRoute);
        if (!vViolations.isEmpty() || pRoute.getSector().getName().isEmpty()) {
            throw new FunctionalException(resourceBundle.getString("manager.route.error.validation"),
                                          new ConstraintViolationException(vViolations));
        } 
		
        TransactionStatus vTransactionStatus
        = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
	    try {
	    	getDaoFactory().getTopoDao().addRoute(pRoute);
	
	        TransactionStatus vTScommit = vTransactionStatus;
	        vTransactionStatus = null;
	        platformTransactionManager.commit(vTScommit);
	    } finally {
	        if (vTransactionStatus != null) {
	            platformTransactionManager.rollback(vTransactionStatus);
	        }
	    }
	    
	}
	
}
