package fr.isika.cda17.project3.model.financialManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Store store;

    public Wallet() {
	super();
    }

    public Wallet(Long id, Store store) {
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
