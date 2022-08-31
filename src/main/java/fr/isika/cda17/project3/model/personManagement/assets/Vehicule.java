package fr.isika.cda17.project3.model.personManagement.assets;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Vehicule {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String brand;
    
    private String registrationNumber;
    
    private boolean hybrid;
    
    private boolean electric;
    
    private boolean manual;
    
    private Date technicalTestExpiration;
    
    private int availableSeats;
    
    @OneToOne(cascade=CascadeType.MERGE)
    private Insurance insurance;

    public Vehicule() {
	super();
    }

    public Vehicule(Long id, String brand, String registrationNumber, boolean isHybrid, boolean isElectric,
	    boolean isManual, Date technicalTestExpiration, Insurance insurance, int avilableSeats) {
	super();
	this.id = id;
	this.brand = brand;
	this.registrationNumber = registrationNumber;
	this.hybrid = isHybrid;
	this.electric = isElectric;
	this.manual = isManual;
	this.technicalTestExpiration = technicalTestExpiration;
	this.insurance = insurance;
	this.availableSeats = avilableSeats;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isHybrid() {
        return hybrid;
    }

    public void setHybrid(boolean isHybrid) {
        this.hybrid = isHybrid;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean isElectric) {
        this.electric = isElectric;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean isManual) {
        this.manual = isManual;
    }

    public Date getTechnicalTestExpiration() {
        return technicalTestExpiration;
    }

    public void setTechnicalTestExpiration(Date technicalTestExpiration) {
        this.technicalTestExpiration = technicalTestExpiration;
    }


    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Long getId() {
        return id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
  
}
