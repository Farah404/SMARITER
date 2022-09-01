package fr.isika.cda17.project3.model.serviceManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Itinerary {

    @Id
    @GeneratedValue
    private Long id;

    private String firstStopAddress;

    private String secondStopAddress;

    private String thirdStopAddress;

    public Itinerary() {
	super();
    }

    public Itinerary(Long id, String firstStopAddress, String secondStopAddress, String thirdStopAddress) {
	super();
	this.id = id;
	this.firstStopAddress = firstStopAddress;
	this.secondStopAddress = secondStopAddress;
	this.thirdStopAddress = thirdStopAddress;
    }

    public String getFirstStopAddress() {
	return firstStopAddress;
    }

    public void setFirstStopAddress(String firstStopAddress) {
	this.firstStopAddress = firstStopAddress;
    }

    public String getSecondStopAddress() {
	return secondStopAddress;
    }

    public void setSecondStopAddress(String secondStopAddress) {
	this.secondStopAddress = secondStopAddress;
    }

    public String getThirdStopAddress() {
	return thirdStopAddress;
    }

    public void setThirdStopAddress(String thirdStopAddress) {
	this.thirdStopAddress = thirdStopAddress;
    }

    public Long getId() {
	return id;
    }

}
