package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;

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

    private Trajectory trajectory = new Trajectory();

    private Itinerary itinerary = new Itinerary();

    private String startDate;

    private String endDate;

    public TrajectoryType[] trajectoryTypeValues() {
	return TrajectoryType.values();
    }

    public String create() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	((ParcelService) ps).setVehicule(userAccount.getVehicule());
	trajectory.setItinerary(itinerary);
	
	ps.withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.PARCEL)
		.withProvider(userAccount)
		.withReferenceNumber(createReferenceNumber());
	
	ps.withBarCode(createParcelNumber()).withTrajectory(trajectory);
	
	parcelServiceDao.create((ParcelService) ps);
	return "subServiceList.xhtml";
    }

    public String createRequest() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	
	trajectory.setItinerary(itinerary);
	
	ps.withStartDate(LocalDateTime.parse(startDate))
		.withEndDate(LocalDateTime.parse(endDate))
		.withPublicationDate(LocalDateTime.now())
		.withServiceType(ServiceType.PARCEL)
		.withRequest(true)
		.withPurchaser(userAccount)
		.withReferenceNumber(createReferenceNumber());
	
	ps.withBarCode(createParcelNumber()).withTrajectory(trajectory);


	parcelServiceDao.create((ParcelService) ps);
	return "subServiceList.xhtml";

    }
    
    public int createParcelNumber() {
    	int ref = parcelServiceDao.findAll().size()+151;
    	return ref;
    }
    public String createReferenceNumber() {
    	int ref = parcelServiceDao.findAll().size()+1;
    	String referenceNumber="2022-00" + ref + "-PS";
    	return referenceNumber;
    }

    public ParcelService getPs() {
	return (ParcelService) ps;
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
