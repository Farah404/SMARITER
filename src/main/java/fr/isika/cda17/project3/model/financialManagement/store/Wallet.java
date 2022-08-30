package fr.isika.cda17.project3.model.financialManagement.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;
    
    private int ecoCoinsAmmount;
    
    @ManyToOne
    private Store store;

    public Wallet() {
	super();
    }
    
    

    public Wallet(Long id, int ecoCoinsAmmount, Store store) {
	super();
	this.id = id;
	this.ecoCoinsAmmount = ecoCoinsAmmount;
	this.store = store;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEcoCoinsAmmount() {
        return ecoCoinsAmmount;
    }

    public void setEcoCoinsAmmount(int ecoCoinsAmmount) {
        this.ecoCoinsAmmount = ecoCoinsAmmount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    
    
    

}
