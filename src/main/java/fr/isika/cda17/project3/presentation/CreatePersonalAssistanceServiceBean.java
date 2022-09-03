package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class CreatePersonalAssistanceServiceBean {
    @Inject
    private PersonalAssistanceServiceDao personalAssistanceServiceDao;

    @Inject
    private UserAccountsDao userAccountsDao;

    private UserAccount userAccount;

    private Service pas = new PersonalAssistanceService();

    private Trajectory trajectory = new Trajectory();

    private Itinerary itinerary = new Itinerary();

    private String startDate;

    private String endDate;

    public PersonalAssistanceType[] personalAssistanceTypeValues() {
	return PersonalAssistanceType.values();
    }

    public TrajectoryType[] trajectoryTypeValues() {
	return TrajectoryType.values();
    }

    public void create() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	trajectory.setItinerary(itinerary);
	((PersonalAssistanceService) pas).setTrajectory(trajectory);
	
	pas	.withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.PERSONAL_ASSISTANCE)
		.withProvider(userAccount);
	
	PersonalAssistanceService created = personalAssistanceServiceDao.create((PersonalAssistanceService) pas);
	System.out.println(created);
    }

    public void createRequest() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	
	trajectory.setItinerary(itinerary);
	
	pas	.withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.PERSONAL_ASSISTANCE)
		.withRequest(true)
		.withPurchaser(userAccount);
	
	pas = ((PersonalAssistanceService) pas).withTrajectory(trajectory);


	PersonalAssistanceService created = personalAssistanceServiceDao.create((PersonalAssistanceService) pas);
	System.out.println(created);
    }

    public PersonalAssistanceService getPas() {
	return (PersonalAssistanceService) pas;
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
