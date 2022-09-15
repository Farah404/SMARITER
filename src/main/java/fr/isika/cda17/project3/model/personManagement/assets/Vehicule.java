package fr.isika.cda17.project3.model.personManagement.assets;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    private String registrationNumber;

    private int availableSeats;

    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculeType;

    @Enumerated(EnumType.STRING)
    private VehiculePowerType vehiculePowerType;

    private String technicalTestExpiration;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserAccount userAccount;

    @OneToOne(cascade = CascadeType.ALL)
    private Insurance insurance;

    public Vehicule() {
	super();
    }

    public Vehicule(Long id, String brand, String registrationNumber, String technicalTestExpiration,
	    UserAccount userAccount, Insurance insurance, int availableSeats) {
	super();
	this.id = id;
	this.brand = brand;
	this.registrationNumber = registrationNumber;
	this.technicalTestExpiration = technicalTestExpiration;
	this.userAccount = userAccount;
	this.insurance = insurance;
	this.availableSeats = availableSeats;
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

    public VehiculeType getVehiculeType() {
	return vehiculeType;
    }

    public void setVehiculeType(VehiculeType vehiculeType) {
	this.vehiculeType = vehiculeType;
    }

    public VehiculePowerType getVehiculePowerType() {
	return vehiculePowerType;
    }

    public void setVehiculePowerType(VehiculePowerType vehiculePowerType) {
	this.vehiculePowerType = vehiculePowerType;
    }

    public String getTechnicalTestExpiration() {
	return technicalTestExpiration;
    }

    public void setTechnicalTestExpiration(String technicalTestExpiration) {
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

    public int getAvailableSeats() {
	return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
    }

}
