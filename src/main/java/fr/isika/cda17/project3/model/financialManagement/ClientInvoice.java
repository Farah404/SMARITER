package fr.isika.cda17.project3.model.financialManagement;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ClientInvoice extends Invoice{
    
    private double price;

    
    public ClientInvoice() {
	super();
    }

    public ClientInvoice(double price) {
	super();
	this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    


}
