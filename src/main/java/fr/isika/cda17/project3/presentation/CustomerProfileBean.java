package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;

@ManagedBean
@ViewScoped
public class CustomerProfileBean implements Serializable {


    private static final long serialVersionUID = 1L;

    @Inject
    private CustomerDao customerDao;

    private Customer customer;


    public void init(){
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	System.out.println(id);
	if(id != null) {
	    customer = customerDao.findByEntityAccountId(id);
	    //		customer => entityAccount == id
	    if (customer == null) {
		System.out.println("this is bullshit");
	    }
	}
	else {
	    System.out.println("id null");
	}
    }

    public Customer getCustomer() {
	return customer;
    }


    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public String updateStepOne() {
	return "updateCustomerProfile.xhtml?faces-redirect=true";
    }

    public String update() {
	customerDao.update(customer);
	System.out.println(customer);
	return "customerProfile.xhtml?faces-redirect=true";
    }



}
