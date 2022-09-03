package fr.isika.cda17.project3.model.serviceManagement;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Service {

	@Id
	@GeneratedValue
	private Long id;

	private LocalDateTime publicationDate;

	private LocalDateTime expirationDate;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private int referenceNumber;

	private boolean request;

	private boolean unavailable;

	private double price;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Reservation> reservations = new LinkedList<>();

	@Enumerated(EnumType.STRING)
	private ServiceType servicetype;

	@OneToOne
	private UserAccount userAccountProvider;

	@OneToMany
	private List<UserAccount> userAccountsPurchasers = new LinkedList<>();

	public Service() {
		super();
	}

	

	public Service(Long id, LocalDateTime publicationDate, LocalDateTime expirationDate, LocalDateTime startDate,
			LocalDateTime endDate, int referenceNumber, boolean request, boolean unavailable, double price,
			List<Reservation> reservations, ServiceType servicetype, UserAccount userAccountProvider,
			List<UserAccount> userAccountsPurchasers) {
		super();
		this.id = id;
		this.publicationDate = publicationDate;
		this.expirationDate = expirationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.referenceNumber = referenceNumber;
		this.request = request;
		this.unavailable = unavailable;
		this.price = price;
		this.reservations = reservations;
		this.servicetype = servicetype;
		this.userAccountProvider = userAccountProvider;
		this.userAccountsPurchasers = userAccountsPurchasers;
	}



	public boolean isUnavailable() {
		return unavailable;
	}

	public void setUnavailable(boolean isUnavailable) {
		this.unavailable = isUnavailable;
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean isRequest) {
		this.request = isRequest;
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

	public Long getId() {
		return id;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void addPurchaser(UserAccount purchaser) {
		if (!this.userAccountsPurchasers.contains(purchaser)) {
			this.userAccountsPurchasers.add(purchaser);
		}
	}

	public Service withPurchaser(final UserAccount account) {
		this.addPurchaser(account);
		return this;
	}

	public Service withRequest(final boolean isRequest) {
		this.request = isRequest;
		return this;
	}

	public Service withServiceType(final ServiceType serviceType) {
		this.servicetype = serviceType;
		return this;
	}

	public Service withPublicationDate(final LocalDateTime publicationDate) {
		this.setPublicationDate(publicationDate);
		return this;
	}

	public Service withStartDate(final LocalDateTime startDate) {
		this.setStartDate(startDate);
		return this;
	}

	public Service withEndDate(final LocalDateTime endDate) {
		this.setEndDate(endDate);
		return this;
	}
	
	public Service withProvider(final UserAccount userAccount) {
		this.setUserAccountProvider(userAccount);
		return this;
	}

}