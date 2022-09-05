package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;

@ManagedBean
@ViewScoped
public class CreateCarPoolingServiceBean {

    @Inject
    private CarPoolingServiceDao carPoolingServiceDao;

    @Inject
    private UserAccountsDao userAccountsDao;

    private UserAccount userAccount;

    private Service cps = new CarPoolingService();

    private Vehicule vehicule = new Vehicule();

    private Trajectory trajectory = new Trajectory();

    private Itinerary itinerary = new Itinerary();

    private String startDate;

    private String endDate;

    public CarPoolingType[] carPoolingTypeValues() {
	return CarPoolingType.values();
    }

    public TrajectoryType[] trajectoryTypeValues() {
	return TrajectoryType.values();
    }

    public void create() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	trajectory.setItinerary(itinerary);
	
	cps.withStartDate(LocalDateTime.parse(startDate))
			.withEndDate(LocalDateTime.parse(endDate))
			.withPublicationDate(LocalDateTime.now())
			.withServiceType(ServiceType.CAR_POOLING)
			.withProvider(userAccount)
			.withReferenceNumber(createReferenceNumber());
	

	((CarPoolingService) cps).setTrajectory(trajectory);
	
	CarPoolingService created = carPoolingServiceDao.create((CarPoolingService) cps);
	System.out.println(created);
    }

    public void createRequest() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);

	trajectory.setItinerary(itinerary);
	
	cps.withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.CAR_POOLING)
		.withRequest(true)
		.withPurchaser(userAccount)
		.withReferenceNumber(createReferenceNumber());
	
	cps = ((CarPoolingService) cps).withTrajectory(trajectory);

	CarPoolingService created = carPoolingServiceDao.create((CarPoolingService) cps);
	System.out.println(created);
    }

    public String createReferenceNumber() {
    	int ref = carPoolingServiceDao.findAll().size()+1;
    	String referenceNumber="2022-00" + ref + "-CP";
    	return referenceNumber;
    }
    public LocalDateTime expirationDate() {
    	LocalDateTime expirationDate=LocalDateTime.parse(endDate).minusDays(1);
    	return expirationDate;
    }
    public CarPoolingService getCps() {
	return (CarPoolingService) cps;
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

    public Itinerary getItinerary() {
	return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
	this.itinerary = itinerary;
    }

    public void setTrajectory(Trajectory trajectory) {
	this.trajectory = trajectory;
    }

    public String getStartDate() {
	return startDate;
    }

    public void setStartDate(String startDate) {
	this.startDate = startDate;
    }

    public String getEndDate() {
	return endDate;
    }

    public void setEndDate(String endDate) {
	this.endDate = endDate;
    }

}
