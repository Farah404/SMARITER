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

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;

@ManagedBean
@ViewScoped
public class CarPoolingManagementBean implements Serializable {

	//private static final String LIST_CARPOOLINGSERVICE_XHTML = "ListCarPoolingService.xhtml";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;

	private List<CarPoolingService> carPoolingServiceList;

	private CarPoolingService carPoolingService;

//	public void init() throws IOException {
//	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//	if (map.containsKey("carPoolingServiceId")) {
//		String carPoolingServiceIdParamValue = map.get("carPoolingServiceId");
//		System.err.println(carPoolingServiceIdParamValue);
//
//		if (!carPoolingServiceIdParamValue.isEmpty()) {
//			try {
//			Long id = Long.valueOf(carPoolingServiceIdParamValue);
//			
//			// TODO : si pas de id => message d'erreur
//	
//			carPoolingService = carPoolingServiceDao.findById(id);
//
//			if (carPoolingService == null) {
//				redirectError();
//			}
//			
//			} catch (NumberFormatException e) {
//				System.err.println("erreur : "+carPoolingServiceIdParamValue);
//				redirectError();
//			}
//
//		} else {
//
//			redirectError();
//
//		}
//	}
//
//}
///*
//* methods
//*/
//
//// creer une page Erreur parsonna
//	public void redirectError() throws IOException {
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		ec.redirect("listCarPoolingService.xhtml");
//	}
	
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
		ec.redirect("ListCarPoolingService.xhtml");
	}
	public String updapte() {
		carPoolingServiceDao.update(carPoolingService);
		System.out.println((carPoolingService));
		return "ListCarPoolingService.xhtm";
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

}
