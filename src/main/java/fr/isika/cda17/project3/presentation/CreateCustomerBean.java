package fr.isika.cda17.project3.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.Customer;
import fr.isika.cda17.project3.repository.personManagement.CustomerDao;

@ManagedBean
@ViewScoped
public class CreateCustomerBean {
    
    @Inject
    private CustomerDao customerDao;

    private Customer customer = new Customer();
    
    public void create() {
	Customer created = customerDao.create(customer);
	System.out.println(created);
    }
    
    public Customer getCustomer() {
	return customer;
    }
    public void setCustomer(Customer customer) {
	this.customer = customer;
    }
    
}
