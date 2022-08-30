package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;


import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;

@ManagedBean
@ViewScoped
public class CreateCarPoolingServiceBean {

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;
	
	@Inject
	private UserAccountsDao userAccountsDao;
	
	private UserAccount userAccount;
	
	private CarPoolingService cps = new CarPoolingService();
	
	private Vehicule vehicule = new Vehicule();
	
	private Trajectory trajectory = new Trajectory();
	
	private Itinerary itinerary = new Itinerary();
	
	private List<UserAccount> userAccountsPurchasers = new LinkedList<>();
	
	
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
		cps.setVehicule(userAccount.getVehicule());
		trajectory.setItinerary(itinerary);
		cps.setTrajectory(trajectory);
		cps.setServicetype(ServiceType.CAR_POOLING);
		cps.setPublicationDate(LocalDateTime.now());
		cps.setIsRequest(false);
		cps.setUserAccountProvider(userAccount);
		CarPoolingService created = carPoolingServiceDao.create(cps);
		System.out.println(created);
	}
	
public void createRequest() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		trajectory.setItinerary(itinerary);
		cps.setTrajectory(trajectory);
		cps.setServicetype(ServiceType.CAR_POOLING);
		cps.setPublicationDate(LocalDateTime.now());
		cps.setIsRequest(true);
		userAccountsPurchasers.add(userAccount);
		cps.setUserAccountsPurchasers(userAccountsPurchasers);
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

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
	}
}

