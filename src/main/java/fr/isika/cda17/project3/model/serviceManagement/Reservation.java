package fr.isika.cda17.project3.model.serviceManagement;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade=CascadeType.MERGE)
    private Service service;

    @ManyToMany
    private List <UserAccount> Useraccounts = new LinkedList<>();
    
    @OneToOne(cascade=CascadeType.ALL)
    private ServiceInvoice serviceinvoice;

    public Reservation() {
	super();
    }

    public Reservation(Long id, Service service, List<UserAccount> useraccounts, ServiceInvoice serviceinvoice) {
	super();
	this.id = id;
	this.service = service;
	Useraccounts = useraccounts;
	this.serviceinvoice = serviceinvoice;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<UserAccount> getUseraccounts() {
        return Useraccounts;
    }

    public void setUseraccounts(List<UserAccount> useraccounts) {
        Useraccounts = useraccounts;
    }

    public ServiceInvoice getServiceinvoice() {
        return serviceinvoice;
    }

    public void setServiceinvoice(ServiceInvoice serviceinvoice) {
        this.serviceinvoice = serviceinvoice;
    }

    public Long getId() {
        return id;
    }
    
    



}