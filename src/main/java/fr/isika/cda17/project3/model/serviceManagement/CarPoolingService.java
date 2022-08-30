package fr.isika.cda17.project3.model.serviceManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CarPoolingService extends Service{
    
    @Enumerated
    private CarPoolingType carPoolingType;
    
    private int availableSeats;
    
    private Boolean isPetAllowed;
    
    private Boolean isSmokingAllowed;
    
    private Boolean isMusicAllowed;
    
    private Boolean isChattingAllowed;
    
    @ManyToMany
    private List <CarPoolingService> carPoolingServiceList = new ArrayList<CarPoolingService>();
    
    @OneToOne(cascade=CascadeType.ALL)
    private Vehicule vehicule;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Trajectory trajectory;

    public CarPoolingService() {
	super();
    }

    public CarPoolingService(Long id, Date publicationDate, Date expirationDate, Date startDate, Date endDate,
			int referenceNumber, Boolean isRequest, double price, List<Reservation> reservations, ServiceType servicetype,
			List<UserAccount> userAccounts, CarPoolingType carPoolingType, int availableSeats, Boolean isPetAllowed,
		    Boolean isSmokingAllowed, Boolean isMusicAllowed, Boolean isChattingAllowed, Vehicule vehicule, Trajectory trajectory) {
		super(id, publicationDate, expirationDate, startDate, endDate, referenceNumber, isRequest, price,reservations, servicetype,
				userAccounts);
		this.carPoolingType = carPoolingType;
		this.availableSeats = availableSeats;
		this.isPetAllowed = isPetAllowed;
		this.isSmokingAllowed = isSmokingAllowed;
		this.isMusicAllowed = isMusicAllowed;
		this.isChattingAllowed = isChattingAllowed;
		this.vehicule = vehicule;
		this.trajectory = trajectory;
	}

	public CarPoolingType getCarPoolingType() {
        return carPoolingType;
    }

    public void setCarPoolingType(CarPoolingType carPoolingType) {
        this.carPoolingType = carPoolingType;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Boolean getIsPetAllowed() {
        return isPetAllowed;
    }

    public void setIsPetAllowed(Boolean isPetAllowed) {
        this.isPetAllowed = isPetAllowed;
    }

    public Boolean getIsSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setIsSmokingAllowed(Boolean isSmokingAllowed) {
        this.isSmokingAllowed = isSmokingAllowed;
    }

    public Boolean getIsMusicAllowed() {
        return isMusicAllowed;
    }

    public void setIsMusicAllowed(Boolean isMusicAllowed) {
        this.isMusicAllowed = isMusicAllowed;
    }

    public Boolean getIsChattingAllowed() {
        return isChattingAllowed;
    }

    public void setIsChattingAllowed(Boolean isChattingAllowed) {
        this.isChattingAllowed = isChattingAllowed;
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

	public List <CarPoolingService> getCarPoolingServiceList() {
		return carPoolingServiceList;
	}

	public void setCarPoolingServiceList(List <CarPoolingService> carPoolingServiceList) {
		this.carPoolingServiceList = carPoolingServiceList;
	}

	
    
    
}
