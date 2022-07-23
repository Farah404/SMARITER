package fr.isika.cda.project3.model.financialManagement;


import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.isika.cda.project3.model.personManagement.UserAccount;

@Entity
public class StoreInvoice {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated
    private PurchaseType purchaseType;
    
    @ManyToOne
    private UserAccount userAccount;
    
    @ManyToOne
    private Store store;

    public StoreInvoice() {
	super();
    }

    public StoreInvoice(Long id, PurchaseType purchaseType, UserAccount userAccount, Store store) {
	super();
	this.id = id;
	this.purchaseType = purchaseType;
	this.userAccount = userAccount;
	this.store = store;
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Long getId() {
        return id;
    }

}
