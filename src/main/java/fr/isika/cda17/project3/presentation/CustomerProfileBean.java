package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

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

    public void init() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	if (id != null) {
	    customer = customerDao.findByEntityAccountId(id);
	}
    }

    public String goToInvoice() {
	return "customerInvoice.xhtml?faces-redirect=true&solutionId="+customer.getEntityAccount().getSolution().getId();
    }

    public String updateStepOne() {
	return "updateCustomerProfile.xhtml?faces-redirect=true";
    }

    public String update() {
	customerDao.update(customer);
	return "customerProfile.xhtml?faces-redirect=true";
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

}
