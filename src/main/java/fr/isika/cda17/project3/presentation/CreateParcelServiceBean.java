package fr.isika.cda17.project3.presentation;
import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;

@ManagedBean
@ViewScoped
public class CreateParcelServiceBean {


	@Inject
	private ParcelServiceDao parcelServiceDao;

	private ParcelService ps = new ParcelService();

	private Vehicule vehicule = new Vehicule();

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
//		ps.setVehicule(vehicule);
//		ps.setTrajectory(trajectory);
//		ps.setServicetype(ServiceType.PARCEL);
//		ps.setPublicationDate(LocalDateTime.now());
//		ps.setIsRequest(false);
//		ParcelService created = parcelServiceDao.create(ps);
//		System.out.println(created);
	}

	public ParcelService getPs() {
		return ps;
	}

	public void setPs(ParcelService ps) {
		this.ps = ps;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


}