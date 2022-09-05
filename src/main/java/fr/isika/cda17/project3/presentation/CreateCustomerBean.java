package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;

@ManagedBean
@ViewScoped
public class CreateCustomerBean implements Serializable {

    private static final long serialVersionUID = -8688644566487799148L;

    @Inject
    private CustomerDao customerDao;

    private Customer customer = new Customer();
    private EntityAccount entityAccount = new EntityAccount();
    private BankDetails bankDetails = new BankDetails();
    private BillingAddress billingAddress = new BillingAddress();

    public void create() {
	Customer created = customerDao.create(customer);
    }

    public String createStepOne() {
	entityAccount.setBankDetails(bankDetails);
	entityAccount.setBillingAddress(billingAddress);
	entityAccount.setCreationDate(LocalDateTime.now());
	entityAccount.setAccountType(AccountType.ENTITY);
	// set default values for Entity Account : isActive==true &&
	// profilePicturePath==basicOne
	entityAccount.setIsActive(true);
	entityAccount.setProfilePicturePath("media/gif/profilePictures/ProfileGif8.gif");
	customer.setEntityAccount(entityAccount);
	customerDao.create(customer);
	System.err.println(customer.getId());
	return "signUp.xhtml?faces-redirect=true&customerId=" + customer.getId();
    }

    public String update() {
	customerDao.update(customer);
	System.out.println(customer);
	return "logInSignUp.xhtml";
    }

    public void init() {
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	if (map.containsKey("customerId")) {
	    String customerIdParamValue = map.get("customerId");
	    Long id = Long.valueOf(customerIdParamValue);
	    if (id != null) {
		customer = customerDao.findById(id);
	    } else {
		System.err.println("no customerId on page");
		return;
	    }
	}
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public EntityAccount getEntityAccount() {
	return entityAccount;
    }

    public void setEntityAccount(EntityAccount entityAccount) {
	this.entityAccount = entityAccount;
    }

}
