package fr.isika.cda17.project3.model.financialManagement.invoice;


import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.financialManagement.store.PurchaseType;
import fr.isika.cda17.project3.model.financialManagement.store.Store;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class StoreInvoice extends Invoice{
    
    
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


}
