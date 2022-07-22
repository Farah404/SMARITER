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
import fr.isika.cda.project3.model.solutionManagement.Solution;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class EntityAccount extends Account {
    
    private String name;
    
    private int siretNumber;
    
    private boolean isPrivate;
    
    @OneToOne
    private ShoppingCart shoppingCart;
    
    @OneToOne
    private BankDetails bankDetails;
    
    @OneToOne
    private BillingAddress billingAddress;
    
    @ManyToMany
    private List <Solution> solutions = new LinkedList<>();

    public EntityAccount(Long id, String username, String password, String profilePicturePath, boolean isActive,
	    Date creationDate, AccountType accountType, String name, int siretNumber, boolean isPrivate,
	    ShoppingCart shoppingCart, BankDetails bankDetails, BillingAddress billingAddress,
	    List<Solution> solutions) {
	super(id, username, password, profilePicturePath, isActive, creationDate, accountType);
	this.name = name;
	this.siretNumber = siretNumber;
	this.isPrivate = isPrivate;
	this.shoppingCart = shoppingCart;
	this.bankDetails = bankDetails;
	this.billingAddress = billingAddress;
	this.solutions = solutions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSiretNumber() {
        return siretNumber;
    }

    public void setSiretNumber(int siretNumber) {
        this.siretNumber = siretNumber;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
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

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
    
}