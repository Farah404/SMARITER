package fr.isika.cda17.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trajectory {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private int durationHours;
    
    private int stopNumber;
    
    private int stopDurationMinutes;
    
    private String pickUpAddress;
    
    private String deliveryAddress;
    
    @Enumerated
    private TrajectoryType trajectoryType;
    
    @OneToOne
    private Itinerary itinerary;

    public Trajectory() {
	super();
    }

    public Trajectory(Long id, int durationHours, int stopNumber, int stopDurationMinutes, String pickUpAddress,
	    String deliveryAddress, TrajectoryType trajectoryType, Itinerary itinerary) {
	super();
	this.id = id;
	this.durationHours = durationHours;
	this.stopNumber = stopNumber;
	this.stopDurationMinutes = stopDurationMinutes;
	this.pickUpAddress = pickUpAddress;
	this.deliveryAddress = deliveryAddress;
	this.trajectoryType = trajectoryType;
	this.itinerary = itinerary;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    public int getStopDurationMinutes() {
        return stopDurationMinutes;
    }

    public void setStopDurationMinutes(int stopDurationMinutes) {
        this.stopDurationMinutes = stopDurationMinutes;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public TrajectoryType getTrajectoryType() {
        return trajectoryType;
    }

    public void setTrajectoryType(TrajectoryType trajectoryType) {
        this.trajectoryType = trajectoryType;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Long getId() {
        return id;
    }
    
}
