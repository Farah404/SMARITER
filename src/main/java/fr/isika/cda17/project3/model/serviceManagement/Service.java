package fr.isika.cda17.project3.model.serviceManagement;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Service {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private LocalDateTime publicationDate;
    
    private LocalDateTime expirationDate;
    
    private Date startDate;
    
    private Date endDate;
    
    private int referenceNumber;
    
    private boolean isRequest;
    
    private double price;
    
    @Enumerated
    private ServiceType servicetype;

    @OneToOne
    private UserAccount userAccountProvider;
    
    @OneToMany
    private List<UserAccount> userAccountsPurchasers = new LinkedList<>();
    
    @ManyToMany
    private List <UserAccount> userAccounts = new LinkedList<>();

    public Service() {
	super();
    }

    public Service(Long id, LocalDateTime publicationDate, LocalDateTime expirationDate, Date startDate, Date endDate,
	    int referenceNumber, boolean isRequest, double price, ServiceType servicetype,
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

    
    public UserAccount getUserAccountProvider() {
		return userAccountProvider;
	}

	public void setUserAccountProvider(UserAccount userAccountProvider) {
		this.userAccountProvider = userAccountProvider;
	}

	public List<UserAccount> getUserAccountsPurchasers() {
		return userAccountsPurchasers;
	}

	public void setUserAccountsPurchasers(List<UserAccount> userAccountsPurchasers) {
		this.userAccountsPurchasers = userAccountsPurchasers;
	}

	public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
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

    public boolean getIsRequest() {
        return isRequest;
    }

    public void setIsRequest(boolean isRequest) {
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