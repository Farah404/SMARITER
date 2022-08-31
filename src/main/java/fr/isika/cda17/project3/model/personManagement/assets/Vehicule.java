package fr.isika.cda17.project3.model.personManagement.assets;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	public Vehicule(Long id, String brand, String registrationNumber, String technicalTestExpiration, UserAccount userAccount, Insurance insurance) {
		super();
		this.id = id;
		this.brand = brand;
		this.registrationNumber = registrationNumber;
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

	public VehiculeType getVehiculeType() {
		return vehiculeType;
	}
	public void setVehiculeType(VehiculeType vehiculeType) {
		this.vehiculeType = vehiculeType;
	}

	public Boolean isAutomatic() {
		return VehiculeType.AUTOMATIC.equals(vehiculeType);
	}

	public Boolean isManual() {
		return VehiculeType.MANUAL.equals(vehiculeType);
	}


	public VehiculePowerType getVehiculePowerType() {
		return vehiculePowerType;
	}

	public void setVehiculePowerType(VehiculePowerType vehiculePowerType) {
		this.vehiculePowerType = vehiculePowerType;
	}

	public Boolean isPetrol() {
		return vehiculePowerType.equals(vehiculePowerType);
	}
	public Boolean isElectric() {
		return vehiculePowerType.equals(vehiculePowerType);
	}
	public Boolean isHybrid() {
		return vehiculePowerType.equals(vehiculePowerType);
	}
	public Boolean isDiesel() {
		return vehiculePowerType.equals(vehiculePowerType);
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


}
