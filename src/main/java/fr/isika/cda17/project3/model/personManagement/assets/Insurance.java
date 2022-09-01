package fr.isika.cda17.project3.model.personManagement.assets;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Insurance {

    @Id
    @GeneratedValue
    private Long id;

    private String insuranceAgencyName;

    private String insuranceContractNumber;

    private Date insuranceContractExpiration;

    public Insurance() {
	super();
    }

    public Insurance(Long id, String insuranceAgencyName, String insuranceContractNumber,
	    Date insuranceContractExpiration) {
	super();
	this.id = id;
	this.insuranceAgencyName = insuranceAgencyName;
	this.insuranceContractNumber = insuranceContractNumber;
	this.insuranceContractExpiration = insuranceContractExpiration;
    }

    public String getInsuranceAgencyName() {
	return insuranceAgencyName;
    }

    public void setInsuranceAgencyName(String insuranceAgencyName) {
	this.insuranceAgencyName = insuranceAgencyName;
    }

    public String getInsuranceContractNumber() {
	return insuranceContractNumber;
    }

    public void setInsuranceContractNumber(String insuranceContractNumber) {
	this.insuranceContractNumber = insuranceContractNumber;
    }

    public Date getInsuranceContractExpiration() {
	return insuranceContractExpiration;
    }

    public void setInsuranceContractExpiration(Date insuranceContractExpiration) {
	this.insuranceContractExpiration = insuranceContractExpiration;
    }

    public Long getId() {
	return id;
    }
}
