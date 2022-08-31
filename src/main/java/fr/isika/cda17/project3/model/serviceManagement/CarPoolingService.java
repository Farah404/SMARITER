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

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CarPoolingService extends Service{
    
    @Enumerated
    private CarPoolingType carPoolingType;
    
    private int availableSeats;
    
    private boolean petAllowed;
    
    private boolean smokingAllowed;
    
    private boolean musicAllowed;
    
    private boolean chattingAllowed;
    

    @ManyToMany
    private List <CarPoolingService> carPoolingServiceList = new ArrayList<CarPoolingService>();
    
    @OneToOne(cascade=CascadeType.ALL)
    private Trajectory trajectory;

    public CarPoolingService() {
	super();
    }


	public CarPoolingService(CarPoolingType carPoolingType, int availableSeats, boolean petAllowed,
	    boolean smokingAllowed, boolean musicAllowed, boolean chattingAllowed,
	    List<CarPoolingService> carPoolingServiceList, Trajectory trajectory) {
	super();
	this.carPoolingType = carPoolingType;
	this.availableSeats = availableSeats;
	this.petAllowed = petAllowed;
	this.smokingAllowed = smokingAllowed;
	this.musicAllowed = musicAllowed;
	this.chattingAllowed = chattingAllowed;
	this.carPoolingServiceList = carPoolingServiceList;
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

	public List <CarPoolingService> getCarPoolingServiceList() {
		return carPoolingServiceList;
	}

	public void setCarPoolingServiceList(List <CarPoolingService> carPoolingServiceList) {
		this.carPoolingServiceList = carPoolingServiceList;
	}

	@Override
	public String toString() {
		return "CarPoolingService [id="+ super.getId() +", carPoolingType=" + carPoolingType + ", availableSeats=" + availableSeats
				+ ", isPetAllowed=" + isPetAllowed + ", isSmokingAllowed=" + isSmokingAllowed + ", isMusicAllowed="
				+ isMusicAllowed + ", isChattingAllowed=" + isChattingAllowed + ", vehicule=" + vehicule + ", trajectory=" + trajectory + "]";
	}

	



}