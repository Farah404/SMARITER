package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;

@ManagedBean
@ViewScoped
public class UpdateCustomerProfileBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CustomerDao customerDao;
    private Customer customer;

    public void init() throws IOException {
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	if (map.containsKey("customerId")) {
	    String customerIdParamValue = map.get("customerId");
	    System.err.println(customerIdParamValue);
	    if (!customerIdParamValue.isEmpty()) {
		try {
		    Long id = Long.valueOf(customerIdParamValue);
		    customer = customerDao.findByEntityAccountId(id);
		    if (customer == null) {
			redirectError();
		    }
		} catch (NumberFormatException e) {
		    System.err.println("erreur : " + customerIdParamValue);
		    redirectError();
		}
	    } else {
		redirectError();
	    }

	}
    }

    public void redirectError() throws IOException {
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	ec.redirect("listEntity.xhtml");
    }

    public String update() {
	customerDao.update(customer);
	System.out.println(customer);
	return "customerProfile.xhtml?faces-redirect=true";
    }
}
