package fr.isika.cda.project3.model.personManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.isika.cda.project3.model.solutionManagement.Service;

@Entity
public class Rating {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String comment;
    
    @ManyToOne
    private UserAccount userAccount;
    
    @ManyToOne
    private Service service;

    public Rating(Long id, String comment, UserAccount userAccount, Service service) {
	super();
	this.id = id;
	this.comment = comment;
	this.userAccount = userAccount;
	this.service = service;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
