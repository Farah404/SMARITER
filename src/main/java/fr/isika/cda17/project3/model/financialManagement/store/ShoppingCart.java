package fr.isika.cda17.project3.model.financialManagement.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Store store;

    public ShoppingCart() {
	super();
    }

    public ShoppingCart(Long id, Store store) {
	super();
	this.id = id;
	this.store = store;
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
