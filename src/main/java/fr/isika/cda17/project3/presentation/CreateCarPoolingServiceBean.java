package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
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
public class CreateCarPoolingServiceBean {

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;
	
//	@Inject
//	private CarRentalServiceDao carRentalServiceDao;
//	
//	@Inject
//	private ParcelServiceDao parcelServiceDao;
//	
//	@Inject
//	private PersonalAssistanceServiceDao personalAssistanceServiceDao;
	
	private CarPoolingService cps = new CarPoolingService();
	
	private Vehicule vehicule = new Vehicule();
	
	private Trajectory trajectory = new Trajectory();
	
	
	public CarPoolingType[] carPoolingTypeValues() {
		return CarPoolingType.values();
	}
//	public PersonalAssistanceType[] personalAssistanceTypeValues() {
//		return PersonalAssistanceType.values();
//	}
//	public ServiceType[] serviceType() {
//		return ServiceType.values();
//	}
		
	public void create() {
		cps.setVehicule(vehicule);
		cps.setTrajectory(trajectory);
		cps.setServicetype(ServiceType.CAR_POOLING);
		cps.setPublicationDate(LocalDateTime.now());
		cps.setIsRequest(false);
		CarPoolingService created = carPoolingServiceDao.create(cps);
		System.out.println(created);
	}

	public CarPoolingService getCps() {
		return cps;
	}

	public void setCps(CarPoolingService cps) {
		this.cps = cps;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Trajectory getTrajectory() {
		return trajectory;
	}

	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
	}
	
}
