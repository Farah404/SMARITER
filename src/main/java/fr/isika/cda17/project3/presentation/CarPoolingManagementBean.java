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

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;

@ManagedBean
@ViewScoped
public class CarPoolingManagementBean implements Serializable {

	private static final String LIST_CARPOOLINGSERVICE_XHTML = "listCarPoolingService.xhtml";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;

	private List<CarPoolingService> carPoolingServiceList;

	private CarPoolingService carPoolingService = new CarPoolingService();
	
	private TrajectoryType trajectoryType;
	private Vehicule vehicule =new Vehicule();



	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		if (map.containsKey("carPoolingServiceId")) {
			String carPoolingServiceIdParamValue = map.get("carPoolingServiceId");
			System.err.println(carPoolingServiceIdParamValue);
			if (carPoolingServiceIdParamValue != null && !carPoolingServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(carPoolingServiceIdParamValue);
				if(id != null) {
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
		ec.redirect(LIST_CARPOOLINGSERVICE_XHTML);
	}
	public String updapte() {
		carPoolingServiceDao.update(carPoolingService);
		System.out.println((carPoolingService));
		return LIST_CARPOOLINGSERVICE_XHTML;
	}
	
	public String detail(Long id) {
		//carPoolingServiceDao.toString();
		
		return "detailAndBookingCarPoolingService.xhtml?faces-redirect=true&carPoolingServiceId=" + id;
	}
		
	private void refresh() {
		carPoolingServiceList = carPoolingServiceDao.findAll();

	}
	@PostConstruct
	public void freshinit() {
		refresh();
	}
	
	public String showUpdate(Long id) {
		System.err.println(id);
		return "editcarPoolingService.xhtml?faces-redirect=true&carPoolingServiceId=" + id;
	}

	public CarPoolingType[] carPoolingType() {
		return CarPoolingType.values();

	}
	public TrajectoryType[] trajectoryType() {
		return TrajectoryType.values();
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
	public TrajectoryType getTrajectoryType() {
		return trajectoryType;
	}
	public void setTrajectoryType(TrajectoryType trajectoryType) {
		this.trajectoryType = trajectoryType;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	

}
