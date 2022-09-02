package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;

@ManagedBean
@ViewScoped
public class ParcelServiceManagementBean implements Serializable {

    private static final String SERVICE_LIST_XHTML = "subServiceList.xhtml";
    private static final String UPDATE_PARCEL = "updateParcel.xhtml";
    private static final String USER_PROFILE = "subUserProfilePersonal.xhtml";
    

    private static final long serialVersionUID = 1L;

    @Inject
    private ParcelServiceDao parcelServiceDao;

    private ParcelService parcelService = new ParcelService();

    private List<ParcelService> parcelServiceList = new ArrayList<ParcelService>();

    public TrajectoryType[] trajectoryType() {
	return TrajectoryType.values();
    }

    public void init() throws IOException {
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

	if (map.containsKey("parcelServiceId")) {
	    String parcelServiceIdParamValue = map.get("parcelServiceId");
	    System.err.println(parcelServiceIdParamValue);
	    if (parcelServiceIdParamValue != null && !parcelServiceIdParamValue.isBlank()) {
		Long id = Long.valueOf(parcelServiceIdParamValue);
		if (id != null) {

		    parcelService = parcelServiceDao.findById(id);
		    if (parcelService == null) {
			redirectError();
		    }
		} else {
		    redirectError();
		}
	    } else {
		redirectError();
	    }
	}
    }

    public void redirectError() throws IOException {
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	ec.redirect(SERVICE_LIST_XHTML);
    }
    
    public String updateStepOne() {
	return UPDATE_PARCEL;
    }

    public String update() {
	parcelServiceDao.update(parcelService);
	System.out.println((parcelService));
	return USER_PROFILE;
    }

    public String detail(Long id) {
	parcelService = parcelServiceDao.findById(id);
	return "reserveParcelService.xhtml?faces-redirect=true&parcelServiceId=" + id;
    }
    
    public String detailFromSmariter(Long id) {
    	parcelService = parcelServiceDao.findById(id);
    	return "subWebsite/reserveParcelService.xhtml?faces-redirect=true&parcelServiceId=" + id;
        }

    private void refresh() {
	parcelServiceList = parcelServiceDao.findAll();

    }

    @PostConstruct
    public void freshinit() {
	refresh();
    }

    public void delete(Long id) {
	parcelServiceDao.delete(id);
	refresh();
    }

    public ParcelServiceDao getParcelServiceDao() {
	return parcelServiceDao;
    }

    public void setParcelServiceDao(ParcelServiceDao parcelServiceDao) {
	this.parcelServiceDao = parcelServiceDao;
    }

    public ParcelService getParcelService() {
	return parcelService;
    }

    public void setParcelService(ParcelService parcelService) {
	this.parcelService = parcelService;
    }

    public List<ParcelService> getParcelServiceList() {
	return parcelServiceList;
    }

    public void setParcelServiceList(List<ParcelService> parcelServiceList) {
	this.parcelServiceList = parcelServiceList;
    }

}
