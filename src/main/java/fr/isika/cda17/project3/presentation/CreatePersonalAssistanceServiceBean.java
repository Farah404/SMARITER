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
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class CreatePersonalAssistanceServiceBean {

	
	@Inject
	private PersonalAssistanceServiceDao personalAssistanceServiceDao;
	
	@Inject
	private UserAccountsDao userAccountsDao;
	
	private UserAccount userAccount;
	
	private PersonalAssistanceService pas = new PersonalAssistanceService();
	
	private Trajectory trajectory= new Trajectory();
	
	private Itinerary itinerary = new Itinerary();
	
	private List<UserAccount> userAccountsPurchasers = new LinkedList<>();
		
	public void create() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		trajectory.setItinerary(itinerary);
		pas.setTrajectory(trajectory);
		pas.setServicetype(ServiceType.PERSONAL_ASSISTANCE);
		pas.setPublicationDate(LocalDateTime.now());
		pas.setIsRequest(false);
		pas.setUserAccountProvider(userAccount);
		PersonalAssistanceService created = personalAssistanceServiceDao.create(pas);
		System.out.println(created);
	}
	
	public void createRequest() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		userAccount = userAccountsDao.findById(id);
		trajectory.setItinerary(itinerary);
		pas.setTrajectory(trajectory);
		pas.setServicetype(ServiceType.PERSONAL_ASSISTANCE);
		pas.setPublicationDate(LocalDateTime.now());
		pas.setIsRequest(true);
		userAccountsPurchasers.add(userAccount);
		pas.setUserAccountsPurchasers(userAccountsPurchasers);
		PersonalAssistanceService created = personalAssistanceServiceDao.create(pas);
		System.out.println(created);
	}

	public PersonalAssistanceService getPas() {
		return pas;
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

	public void setPas(PersonalAssistanceService pas) {
		this.pas = pas;
	}

	
}
