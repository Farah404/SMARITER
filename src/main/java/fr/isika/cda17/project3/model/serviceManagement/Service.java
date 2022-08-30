package fr.isika.cda17.project3.model.serviceManagement;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Service {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private Date publicationDate;
    
    private Date expirationDate;
    
    private Date startDate;
    
    private Date endDate;
    
    private int referenceNumber;
    
    private Boolean isRequest;
    
    private double price;
    
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List <Reservation> reservations = new LinkedList<>();
    
    @Enumerated
    private ServiceType servicetype;
    
    

	@ManyToMany
    private List <UserAccount> userAccounts = new LinkedList<>();

    public Service() {
	super();
    }

    public Service(Long id, Date publicationDate, Date expirationDate, Date startDate, Date endDate,
	    int referenceNumber, Boolean isRequest, double price,List <Reservation> reservations, ServiceType servicetype,
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
	this.reservations = reservations;
	this.servicetype = servicetype;
	this.userAccounts = userAccounts;
	
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservation) {
		this.reservations = reservation;
	}
}
