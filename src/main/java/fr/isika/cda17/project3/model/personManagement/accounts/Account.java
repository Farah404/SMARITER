package fr.isika.cda17.project3.model.personManagement.accounts;

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
    
    private String email;
    
    private String password;
    
    private String profilePicturePath;
    
    private Boolean isActive;
    
    private Date creationDate;
    
    @Enumerated
    private AccountType accountType;

    public Account() {
	super();
    }

    public Account(Long id, String username, String email, String password, String profilePicturePath, Boolean isActive,
	    Date creationDate, AccountType accountType) {
	super();
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
	this.profilePicturePath = profilePicturePath;
	this.isActive = isActive;
	this.creationDate = creationDate;
	this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
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

}
