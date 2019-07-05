package org.openclassroom.projet.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.openclassroom.projet.business.contract.ManagerFactory;
import org.openclassroom.projet.model.bean.topo.Site;
import org.openclassroom.projet.model.exception.NotFoundException;

import com.opensymphony.xwork2.conversion.TypeConversionException;



/***/
public class SiteLocator extends StrutsTypeConverter {
	
	@Inject
	private ManagerFactory managerFactory;
	
	@Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                        = StringUtils.isEmpty(vValue)
                        ? null
                        :  managerFactory.getTopoManager().getSite(vValue);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Site introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vRetour;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        String vString;
        if (pObject instanceof Site) {
            Site vSite = (Site) pObject;
            vString
                = vSite.getName() != null
                ? vSite.getName().toString()
                : "";
        } else {
            vString = "";
        }
        return vString;
    }

}
