package fr.isika.cda17.project3.model.financialManagement.store;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;

    private double internalCurrencyAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;

    public Wallet() {
	super();
    }

    public Wallet(Long id, double ecoCoinsAmmount, Store store) {
	super();
	this.id = id;
	this.internalCurrencyAmount = ecoCoinsAmmount;
	this.store = store;
    }

    public Long getId() {
	return id;
    } 

    public double getInternalCurrencyAmount() {
	return internalCurrencyAmount;
    }

    public void setInternalCurrencyAmount(double internalCurrencyAmount) {
	this.internalCurrencyAmount = internalCurrencyAmount;
    }

    public Store getStore() {
	return store;
    }

    public void setStore(Store store) {
	this.store = store;
    }
    public Wallet withAddedValue(final double value) {
    	this.internalCurrencyAmount = this.internalCurrencyAmount+value;
    	return this;
    }
    public Wallet withSubstractedValue(final double value) {
    	this.internalCurrencyAmount = this.internalCurrencyAmount-value;
    	return this;
    }
}
