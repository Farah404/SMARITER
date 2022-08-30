package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;

@ManagedBean
@ViewScoped
public class CreateServiceBean implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = -8566359843027496614L;

	private boolean request;
	
	private CarPoolingService cps = new CarPoolingService(); 
	
	public ServiceType[] serviceTypes() {
		return ServiceType.values();
	}
	
	
	public String chooseServiceType() {
			switch (cps.getServicetype())
			{
				case CAR_POOLING :
					if(request==false){
						return "subServiceCreationCarPooling.xhtml";
					}else {
						return "subServiceCreationCarPoolingRequest.xhtml";
					}
				case CAR_RENTAL:
					if(request==false) {
						return "subServiceCreationCarRental.xhtml";
					}else {
						return "subServiceCreationCarRentalRequest.xhtml";
					}
				case PARCEL:
					if(request==false) {
						return "subServiceCreationParcel.xhtml";
					}else {
						return "subServiceCreationParcelRequest.xhtml";
					}
				case PERSONAL_ASSISTANCE:
					if(request==false) {
						return "subServiceCreationPersonalAssistance.xhtml";
					}else {
						return "subServiceCreationPersonalAssistanceRequest.xhtml";
					}
			}
			return "subServiceCreation.xhtml";
		}
	

	public boolean isRequest() {
		return request;
	}


	public void setRequest(boolean request) {
		this.request = request;
	}


	public CarPoolingService getCps() {
		return cps;
	}

	public void setCps(CarPoolingService cps) {
		this.cps = cps;
	}
}

	

