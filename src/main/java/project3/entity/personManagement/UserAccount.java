package project3.entity.personManagement;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import project3.entity.financialManagement.BankDetails;
import project3.entity.financialManagement.BillingAddress;
import project3.entity.financialManagement.ShoppingCart;
import project3.entity.financialManagement.Wallet;
import project3.entity.solutionManagement.Reservation;
import project3.entity.solutionManagement.Service;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class UserAccount extends Account{

    @OneToOne
    private ShoppingCart shoppingCart;

    @OneToOne
    private BankDetails bankDetails;

    @OneToOne
    private BillingAddress billingAddress;
    
    @OneToOne
    private Wallet wallet;

    @ManyToMany
    private List <Service> services = new LinkedList<>();

    @ManyToMany
    private List <Reservation> reservations = new LinkedList<>();
    


    public UserAccount() {
	super();
    }

    public UserAccount(Long id, String username, String password, String profilePicturePath, boolean isActive,
	    Date creationDate, AccountType accountType, ShoppingCart shoppingCart, BankDetails bankDetails,
	    BillingAddress billingAddress, Wallet wallet, List<Service> services, List<Reservation> reservations) {
	super(id, username, password, profilePicturePath, isActive, creationDate, accountType);
	this.shoppingCart = shoppingCart;
	this.bankDetails = bankDetails;
	this.billingAddress = billingAddress;
	this.wallet = wallet;
	this.services = services;
	this.reservations = reservations;
    }

    
    
    public UserAccount(ShoppingCart shoppingCart, BankDetails bankDetails, BillingAddress billingAddress, Wallet wallet,
			List<Service> services, List<Reservation> reservations) {
		super();
		this.shoppingCart = shoppingCart;
		this.bankDetails = bankDetails;
		this.billingAddress = billingAddress;
		this.wallet = wallet;
		this.services = services;
		this.reservations = reservations;
	}

	public ShoppingCart getShoppingCart() {
	return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
    }

    public BankDetails getBankDetails() {
	return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
	this.bankDetails = bankDetails;
    }

    public BillingAddress getBillingAddress() {
	return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
	this.billingAddress = billingAddress;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public List<Service> getServices() {
	return services;
    }

    public void setServices(List<Service> services) {
	this.services = services;
    }

    public List<Reservation> getReservations() {
	return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
    }


}