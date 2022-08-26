package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class CreatePersonalAssistanceServiceBean {

	
	@Inject
	private PersonalAssistanceServiceDao personalAssistanceServiceDao;
	
	private PersonalAssistanceService pas = new PersonalAssistanceService();
	
	private Trajectory trajectory= new Trajectory();
	
//	public CarPoolingType[] carPoolingTypeValues() {
//		return CarPoolingType.values();
//	}
//	public PersonalAssistanceType[] personalAssistanceTypeValues() {
//		return PersonalAssistanceType.values();
//	}
//	public ServiceType[] serviceType() {
//		return ServiceType.values();
//	}
		
	public void create() {
		pas.setTrajectory(trajectory);
		pas.setServicetype(ServiceType.PERSONAL_ASSISTANCE);
		pas.setPublicationDate(LocalDateTime.now());
		pas.setIsRequest(false);
		PersonalAssistanceService created = personalAssistanceServiceDao.create(pas);
		System.out.println(created);
	}

	public PersonalAssistanceService getPas() {
		return pas;
	}

	public void setPas(PersonalAssistanceService pas) {
		this.pas = pas;
	}

	
}
