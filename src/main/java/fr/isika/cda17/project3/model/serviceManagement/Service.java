package fr.isika.cda17.project3.model.serviceManagement;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Service {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private LocalDateTime publicationDate;

    private String expirationDate;

    private String startDate;
    

    private String endDate;

    private int referenceNumber;

    private boolean isRequest;

    private double price;
    
    @Enumerated(EnumType.STRING)
    private ServiceType servicetype;
    
    @ManyToMany
    private List <UserAccount> userAccounts = new LinkedList<>();

    public Service() {
	super();
    }

    public Service(Long id, LocalDateTime publicationDate, String expirationDate, String startDate, String endDate,
	    int referenceNumber, Boolean isRequest, double price, ServiceType servicetype,
	    List<UserAccount> userAccounts) {
	super();
	this.id = id;
	this.publicationDate = publicationDate;
	this.expirationDate = expirationDate;
	this.startDate = startDate;
	this.endDate = endDate;
	this.referenceNumber = referenceNumber;
	this.isRequest = isRequest;
	this.price = price;
	this.servicetype = servicetype;
	this.userAccounts = userAccounts;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

 

    public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setRequest(boolean isRequest) {
		this.isRequest = isRequest;
	}

	public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Boolean getIsRequest() {
        return isRequest;
    }

    public void setIsRequest(Boolean isRequest) {
        this.isRequest = isRequest;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ServiceType getServicetype() {
        return servicetype;
    }

    public void setServicetype(ServiceType servicetype) {
        this.servicetype = servicetype;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public Long getId() {
        return id;
    }

}
