package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.assets.VehiculePowerType;
import fr.isika.cda17.project3.model.personManagement.assets.VehiculeType;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;

@ManagedBean
@ViewScoped
public class CarPoolingServiceManagementBean implements Serializable {

    private static final String SERVICE_LIST_XHTML = "subServiceList.xhtml";
    private static final String UPDATE_CARPOOLING = "updateCarPooling.xhtml";
    private static final String USER_PROFILE = "subUserProfilePersonal.xhtml";
    
    

    private static final long serialVersionUID = 1L;

    @Inject
    private CarPoolingServiceDao carPoolingServiceDao;

    private CarPoolingService carPoolingService = new CarPoolingService();

    private List<CarPoolingService> carPoolingServiceList;

    public CarPoolingType[] carPoolingType() {
	return CarPoolingType.values();
    }

    public TrajectoryType[] trajectoryType() {
	return TrajectoryType.values();
    }

    public VehiculeType[] vehiculeTypes() {
	return VehiculeType.values();
    }

    public VehiculePowerType[] VehiculePowerTypes() {
	return VehiculePowerType.values();
    }

    public void init() throws IOException {
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

	if (map.containsKey("carPoolingServiceId")) {
	    String carPoolingServiceIdParamValue = map.get("carPoolingServiceId");
	    if (carPoolingServiceIdParamValue != null && !carPoolingServiceIdParamValue.isBlank()) {
		Long id = Long.valueOf(carPoolingServiceIdParamValue);
		if (id != null) {
		    carPoolingService = carPoolingServiceDao.findById(id);
		    if (carPoolingService == null) {
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
	return UPDATE_CARPOOLING;
    }
    

    public String update() {
	carPoolingServiceDao.update(carPoolingService);
	System.out.println((carPoolingService));
	return USER_PROFILE;
    }

    public String detail(Long id) {
	carPoolingService = carPoolingServiceDao.findById(id);
	return "reserveCarPoolingService.xhtml?faces-redirect=true&carPoolingServiceId=" + id;
    }

    public String detailFromSmariter(Long id) {
    	carPoolingService = carPoolingServiceDao.findById(id);
    	return "subWebsite/reserveCarPoolingService.xhtml?faces-redirect=true&carPoolingServiceId=" + id;
        }
    
    private void refresh() {
	carPoolingServiceList = carPoolingServiceDao.findAll();

    }

    @PostConstruct
    public void freshinit() {
	refresh();
    }


    public void delete(Long id) {
	carPoolingServiceDao.delete(id);
	refresh();
    }

    public List<CarPoolingService> getCarPoolingServiceList() {
	return carPoolingServiceList;
    }

    public void setCarPoolingServiceList(List<CarPoolingService> carPoolingServiceList) {
	this.carPoolingServiceList = carPoolingServiceList;
    }

    public CarPoolingService getCarPoolingService() {
	return carPoolingService;
    }

    public void setCarPoolingService(CarPoolingService carPoolingService) {
	this.carPoolingService = carPoolingService;
    }

}