package fr.isika.cda17.project3.model.financialManagement.invoice;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.financialManagement.store.PurchaseType;
import fr.isika.cda17.project3.model.financialManagement.store.Store;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StoreInvoice extends Invoice {

    @Enumerated
    private PurchaseType purchaseType;

    @ManyToOne
    private UserAccount userAccount;

    @ManyToOne
    private Store store;
    
    private double amount;
    
    private double internalCurrencyAmount;

    public StoreInvoice() {
	super();
    }

    public StoreInvoice(Long id, PurchaseType purchaseType, UserAccount userAccount, Store store, double amount, double internalCurrencyAmount) {
	super();
	this.purchaseType = purchaseType;
	this.userAccount = userAccount;
	this.store = store;
	this.amount=amount;
	this.internalCurrencyAmount = internalCurrencyAmount;
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
    
    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	public double getInternalCurrencyAmount() {
		return internalCurrencyAmount;
	}

	public void setInternalCurrencyAmount(double internalCurrencyAmount) {
		this.internalCurrencyAmount = internalCurrencyAmount;
	}

	public StoreInvoice withStoreInvoiceType() {
    	InvoiceType invoiceType = InvoiceType.STORE_INVOICE;
    	this.invoiceType=invoiceType;
    	return this;
    }
    
    public StoreInvoice withUserAccountPurchaser(final UserAccount userAccountPurchaser) {
    	this.userAccount=userAccountPurchaser;
    	return this;
    }
    
    public StoreInvoice withCurrencyType() {
    	PurchaseType purchaseType = PurchaseType.INTERNAL_CURRENCY;
    	this.purchaseType=purchaseType;
    	return this;
    }
    
    public StoreInvoice withSubscriptionType() {
    	PurchaseType purchaseType=PurchaseType.SUBSCRIPTION;
    	this.purchaseType=purchaseType;
    	return this;
    }
    
    public StoreInvoice withStore(final Store store) {
    	this.store = store;
    	return this;
    }
    
    public StoreInvoice withAmount(final double amount) {
    	this.amount=amount;
    	return this;
    }
    
    public StoreInvoice withInternalCurrencyAmount(final double internalCurrencyAmount) {
    	this.internalCurrencyAmount=internalCurrencyAmount;
    	return this;
    }
    
}
