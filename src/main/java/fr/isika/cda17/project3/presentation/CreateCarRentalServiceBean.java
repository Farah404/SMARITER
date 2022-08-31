package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;

public class CreateCarRentalServiceBean {

	@Inject
	private CarRentalServiceDao carRentalServiceDao;

	private CarRentalService crs = new CarRentalService();

	private Vehicule vehicule = new Vehicule();

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
//		crs.setVehicule(vehicule);
//		crs.setServicetype(ServiceType.CAR_RENTAL);
//		crs.setPublicationDate(LocalDateTime.now());
//		crs.setIsRequest(false);
//		CarRentalService created = carRentalServiceDao.create(crs);
//		System.out.println(created);
	}

	public CarRentalService getCrs() {
		return crs;
	}

	public void setCrs(CarRentalService crs) {
		this.crs = crs;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


}
