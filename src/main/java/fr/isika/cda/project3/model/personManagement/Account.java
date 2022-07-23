package fr.isika.cda.project3.model.personManagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Account {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String username;
    
    private String password;
    
    private String profilePicturePath;
    
    private Boolean isActive;
    
    private Date creationDate;
    
    @Enumerated
    private AccountType accountType;

    public Account() {
	super();
    }

    public Account(Long id, String username, String password, String profilePicturePath, Boolean isActive,
	    Date creationDate, AccountType accountType) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.profilePicturePath = profilePicturePath;
	this.isActive = isActive;
	this.creationDate = creationDate;
	this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }
    
    
    

}
