package fr.isika.cda17.project3.model.financialManagement.invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.Service;

@Entity
public class ServiceInvoice extends Invoice{

	@OneToOne
    private UserAccount userAccountProvider;
	
	@OneToOne
	private UserAccount userAccountPurchaser;

    @OneToOne
    private Service service;

    public ServiceInvoice() {
	super();
    }

    
	public ServiceInvoice(UserAccount userAccountProvider, UserAccount userAccountPurchaser, Service service) {
		super();
		this.userAccountProvider = userAccountProvider;
		this.userAccountPurchaser = userAccountPurchaser;
		this.service = service;
	}


	public UserAccount getUserAccountProvider() {
		return userAccountProvider;
	}

	public void setUserAccountProvider(UserAccount userAccountProvider) {
		this.userAccountProvider = userAccountProvider;
	}

	public UserAccount getUserAccountPurchaser() {
		return userAccountPurchaser;
	}

	public void setUserAccountPurchaser(UserAccount userAccountPurchaser) {
		this.userAccountPurchaser = userAccountPurchaser;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public ServiceInvoice withUserAccountProvider(final UserAccount userAccountProvider) {
		this.userAccountProvider = userAccountProvider;
		return this;
	}
	public ServiceInvoice withUserAccountPurchaser(final UserAccount userAccountPurchaser) {
		this.userAccountPurchaser = userAccountPurchaser;
		return this;
	}
	public ServiceInvoice withService(final Service service) {
		this.service = service;
		return this;
	}
	public ServiceInvoice withServiceInvoiceType() {
		InvoiceType invoiceType=InvoiceType.CUSTOMER_INVOICE;
		this.invoiceType=invoiceType;
		return this;
	}
}
