package fr.isika.cda.project3.model.personManagement;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda.project3.model.financialManagement.BankDetails;
import fr.isika.cda.project3.model.financialManagement.BillingAddress;
import fr.isika.cda.project3.model.financialManagement.ShoppingCart;
import fr.isika.cda.project3.model.solutionManagement.Service;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class UserAccount extends Account{
    
    @OneToOne
    private ShoppingCart shoppingCart;
    
    @OneToOne
    private BankDetails bankDetails;
    
    @OneToOne
    private BillingAddress billingAddress;
    
    @ManyToMany
    private List <Service> services = new LinkedList<>();
    
    public UserAccount() {
	super();
    }

    public UserAccount(Long id, String username, String password, String profilePicturePath, boolean isActive,
	    Date creationDate, AccountType accountType, ShoppingCart shoppingCart, BankDetails bankDetails,
	    BillingAddress billingAddress, List<Service> services) {
	super(id, username, password, profilePicturePath, isActive, creationDate, accountType);
	this.shoppingCart = shoppingCart;
	this.bankDetails = bankDetails;
	this.billingAddress = billingAddress;
	this.services = services;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    

}
