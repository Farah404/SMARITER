package fr.isika.cda17.project3.model.serviceManagement;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
    
    private boolean isPetAllowed;
    
    private boolean isSmokingAllowed;
    
    private boolean isMusicAllowed;
    
    private boolean isChattingAllowed;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Vehicule vehicule;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Trajectory trajectory;

    public CarPoolingService() {
	super();
    }

    public CarPoolingService(Long id, LocalDateTime publicationDate, LocalDateTime expirationDate, LocalDateTime startDate, LocalDateTime endDate,
			int referenceNumber, boolean isRequest, double price, ServiceType servicetype,
			List<UserAccount> userAccounts, CarPoolingType carPoolingType, int availableSeats, boolean isPetAllowed,
		    boolean isSmokingAllowed, boolean isMusicAllowed, boolean isChattingAllowed, Vehicule vehicule, Trajectory trajectory) {
		super(id, publicationDate, expirationDate, startDate, endDate, referenceNumber, isRequest, price, servicetype,
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

    public boolean getIsPetAllowed() {
        return isPetAllowed;
    }

    public void setIsPetAllowed(Boolean isPetAllowed) {
        this.isPetAllowed = isPetAllowed;
    }

    public boolean getIsSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setIsSmokingAllowed(boolean isSmokingAllowed) {
        this.isSmokingAllowed = isSmokingAllowed;
    }

    public boolean getIsMusicAllowed() {
        return isMusicAllowed;
    }

    public void setIsMusicAllowed(boolean isMusicAllowed) {
        this.isMusicAllowed = isMusicAllowed;
    }

    public boolean getIsChattingAllowed() {
        return isChattingAllowed;
    }

    public void setIsChattingAllowed(boolean isChattingAllowed) {
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
    
}