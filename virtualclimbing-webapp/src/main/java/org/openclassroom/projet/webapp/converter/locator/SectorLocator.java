package org.openclassroom.projet.webapp.converter.locator;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.openclassroom.projet.business.contract.ManagerFactory;
import org.openclassroom.projet.model.bean.topo.Sector;
import org.openclassroom.projet.model.exception.NotFoundException;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/***/
public class SectorLocator extends StrutsTypeConverter {

	@Inject
	private ManagerFactory managerFactory;
	
	@Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vReturn = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vReturn
                        = StringUtils.isEmpty(vValue)
                        ? null
                        :  managerFactory.getTopoManager().getSector(vValue);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Secteur introuvable", pEx);
                }
            } else {
                vReturn = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vReturn;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        String vString;
        if (pObject instanceof Sector) {
            Sector vSector = (Sector) pObject;
            vString
                = vSector.getName() != null
                ? vSector.getName().toString()
                : "";
        } else {
            vString = "";
        }
        return vString;
    }
	
}
