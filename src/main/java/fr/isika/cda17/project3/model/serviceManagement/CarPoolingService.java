package fr.isika.cda17.project3.model.serviceManagement;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
	@NamedQuery(name = "CarPoolingService.findAllUserCPS", query = "SELECT cps FROM CarPoolingService cps WHERE cps.userAccountProvider.id = :userid_param"),
	@NamedQuery(name = "CarPoolingService.findByReferenceNumber", query = "SELECT cps FROM CarPoolingService cps WHERE cps.referenceNumber = :referencenumber_param")
})
public class CarPoolingService extends Service {

    @Enumerated(EnumType.STRING)
    private CarPoolingType carPoolingType;

    private int availableSeats;

    private boolean petAllowed;

    private boolean smokingAllowed;

    private boolean musicAllowed;

    private boolean chattingAllowed;

    @OneToOne(cascade = CascadeType.ALL)
    private Trajectory trajectory;

    public CarPoolingService() {
	super();
    }

    public CarPoolingService(CarPoolingType carPoolingType, int availableSeats, boolean petAllowed,
	    boolean smokingAllowed, boolean musicAllowed, boolean chattingAllowed,
	    Trajectory trajectory) {
	super();
	this.carPoolingType = carPoolingType;
	this.availableSeats = availableSeats;
	this.petAllowed = petAllowed;
	this.smokingAllowed = smokingAllowed;
	this.musicAllowed = musicAllowed;
	this.chattingAllowed = chattingAllowed;
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

    public boolean isPetAllowed() {
	return petAllowed;
    }

    public void setPetAllowed(boolean petAllowed) {
	this.petAllowed = petAllowed;
    }

    public boolean isSmokingAllowed() {
	return smokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
	this.smokingAllowed = smokingAllowed;
    }

    public boolean isMusicAllowed() {
	return musicAllowed;
    }

    public void setMusicAllowed(boolean musicAllowed) {
	this.musicAllowed = musicAllowed;
    }

    public boolean isChattingAllowed() {
	return chattingAllowed;
    }

    public void setChattingAllowed(boolean chattingAllowed) {
	this.chattingAllowed = chattingAllowed;
    }

    public Trajectory getTrajectory() {
	return trajectory;
    }

    public void setTrajectory(Trajectory trajectory) {
	this.trajectory = trajectory;
    }

    public Service withTrajectory(Trajectory trajectory) {
	this.trajectory = trajectory;
	return this;
    }
}
