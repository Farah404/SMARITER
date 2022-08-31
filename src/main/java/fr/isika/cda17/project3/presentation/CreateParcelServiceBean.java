package fr.isika.cda17.project3.presentation;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;

@ManagedBean
@ViewScoped
public class CreateParcelServiceBean {
	
	@Inject
	private ParcelServiceDao parcelServiceDao;
	
	@Inject
	private UserAccountsDao userAccountsDao;
	
	private UserAccount userAccount;
	
	private ParcelService ps = new ParcelService();
	
	private Vehicule vehicule = new Vehicule();
	
	private Trajectory trajectory= new Trajectory();
	
	private Itinerary itinerary = new Itinerary();
	
	private String startDate;
	
	private String endDate;
	
	private List<UserAccount> userAccountsPurchasers = new LinkedList<>();
	
	public TrajectoryType[] trajectoryTypeValues() {
		return TrajectoryType.values();
	}
			
	public void create() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		ps.setVehicule(userAccount.getVehicule());
		trajectory.setItinerary(itinerary);
		ps.setTrajectory(trajectory);
		ps.setServicetype(ServiceType.PARCEL);
		ps.setPublicationDate(LocalDateTime.now());
		ps.setIsRequest(false);
		ps.setStartDate(LocalDateTime.parse(startDate));
		ps.setEndDate(LocalDateTime.parse(endDate));
		ParcelService created = parcelServiceDao.create(ps);
		System.out.println(created);
	}
	
	public void createRequest() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		trajectory.setItinerary(itinerary);
		ps.setTrajectory(trajectory);
		ps.setServicetype(ServiceType.PARCEL);
		ps.setPublicationDate(LocalDateTime.now());
		ps.setIsRequest(true);
		userAccountsPurchasers.add(userAccount);
		ps.setUserAccountsPurchasers(userAccountsPurchasers);
		ParcelService created = parcelServiceDao.create(ps);
		System.out.println(created);
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

	public Trajectory getTrajectory() {
		return trajectory;
	}

	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
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
