package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;

@ManagedBean
@ViewScoped
public class CreateCustomerBean implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = -8688644566487799148L;

    @Inject
    private CustomerDao customerDao;

    private Customer customer = new Customer();
    
    public void create() {
	Customer created = customerDao.create(customer);
	System.out.println(created);
    }
    
    public String createStepOne() {
    	customerDao.create(customer);
    	System.err.println(customer.getId());
    	return "signUp.xhtml?customerId=" + customer.getId();
    }
    
    
    public void init() {
		Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(map.containsKey("customerId")) {
			String customerIdParamValue = map.get("customerId");
			Long id = Long.valueOf(customerIdParamValue);
			
			// TODO : si pas de id => message d'erreur
			if(id != null) {
				customer = customerDao.findById(id);
			} else {	
				//TODO: error
				return ;
				
			}
		}
	}
    
    public Customer getCustomer() {
	return customer;
    }
    public void setCustomer(Customer customer) {
	this.customer = customer;
    }
    
}
