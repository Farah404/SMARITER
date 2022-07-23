package fr.isika.cda.project3.model.personManagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehicule {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String brand;
    
    private String registrationNumber;
    
    private Boolean isHybrid;
    
    private Boolean isElectric;
    
    private Boolean isManual;
    
    private Date technicalTestExpiration;
    
    @ManyToOne
    private UserAccount userAccount;
    
    @OneToOne
    private Insurance insurance;

    public Vehicule() {
	super();
    }

    public Vehicule(Long id, String brand, String registrationNumber, Boolean isHybrid, Boolean isElectric,
	    Boolean isManual, Date technicalTestExpiration, UserAccount userAccount, Insurance insurance) {
	super();
	this.id = id;
	this.brand = brand;
	this.registrationNumber = registrationNumber;
	this.isHybrid = isHybrid;
	this.isElectric = isElectric;
	this.isManual = isManual;
	this.technicalTestExpiration = technicalTestExpiration;
	this.userAccount = userAccount;
	this.insurance = insurance;
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

    public Boolean isHybrid() {
        return isHybrid;
    }

    public void setHybrid(boolean isHybrid) {
        this.isHybrid = isHybrid;
    }

    public Boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    public Boolean isManual() {
        return isManual;
    }

    public void setManual(boolean isManual) {
        this.isManual = isManual;
    }

    public Date getTechnicalTestExpiration() {
        return technicalTestExpiration;
    }

    public void setTechnicalTestExpiration(Date technicalTestExpiration) {
        this.technicalTestExpiration = technicalTestExpiration;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
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
  
}
