package fr.isika.cda17.project3.model.financialManagement.invoice;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CustomerInvoice extends Invoice {

    private double price;

    public CustomerInvoice() {
	super();
    }

    public CustomerInvoice(double price) {
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
