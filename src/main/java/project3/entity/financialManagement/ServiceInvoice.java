package project3.entity.financialManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import project3.entity.personManagement.UserAccount;
import project3.entity.solutionManagement.Service;

@Entity
public class ServiceInvoice {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private UserAccount userAccount;
    
    @OneToOne
    private Service service;

    public ServiceInvoice() {
	super();
    }

    public ServiceInvoice(Long id, UserAccount userAccount, Service service) {
	super();
	this.id = id;
	this.userAccount = userAccount;
	this.service = service;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    
    
    

}