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
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;

@ManagedBean
@ViewScoped
public class CarRentalServiceManagementBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CarRentalServiceDao carRentalServiceDao;

	private List<CarRentalService>carRentalServiceList;

	private CarRentalService carRentalService = new CarRentalService();

	private Vehicule vehicule =new Vehicule();

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("carRentalServiceId")) {
			String carRentalServiceIdParamValue = map.get("carRentalServiceId");
			System.err.println(carRentalServiceIdParamValue);
			if (carRentalServiceIdParamValue != null && !carRentalServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(carRentalServiceIdParamValue);
				if(id != null) {
					carRentalService = carRentalServiceDao.findById(id);
					if (carRentalService == null) {
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
		ec.redirect("listCarPoolingService.xhtml");
	}
	public String updapte() {
		carRentalServiceDao.update(carRentalService);
		System.out.println((carRentalService));
		return "listcarRentalService.xhtml";
	}

	public String detail(Long id) {
		//carPoolingServiceDao.toString();

		return "detailAndBookingcarRentalService.xhtml?faces-redirect=true&carRentalServiceId=" + id;
	}

	private void refresh() {
		carRentalServiceList = carRentalServiceDao.findAll();

	}
	@PostConstruct
	public void freshinit() {
		refresh();
	}

	public String showUpdate(Long id) {
		System.err.println(id);
		return "editcarRentalService.xhtml?faces-redirect=true&carRentalServiceId=" + id;
	}
	public void delete(Long id) {
		carRentalServiceDao.delete(id);
		freshinit();
	}

	public CarRentalServiceDao getCarRentalServiceDao() {
		return carRentalServiceDao;
	}

	public void setCarRentalServiceDao(CarRentalServiceDao carRentalServiceDao) {
		this.carRentalServiceDao = carRentalServiceDao;
	}

	public List<CarRentalService> getCarRentalServiceList() {
		return carRentalServiceList;
	}

	public void setCarRentalServiceList(List<CarRentalService> carRentalServiceList) {
		this.carRentalServiceList = carRentalServiceList;
	}

	public CarRentalService getCarRentalService() {
		return carRentalService;
	}

	public void setCarRentalService(CarRentalService carRentalService) {
		this.carRentalService = carRentalService;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public ServiceType[] serviceType() {
		return ServiceType.values();
	}
}
