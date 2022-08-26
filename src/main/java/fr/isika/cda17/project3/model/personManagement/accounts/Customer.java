package fr.isika.cda17.project3.model.personManagement.accounts;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Customer extends Person{
    
    private int phoneNumber;
    private String role;
    
    @OneToOne(cascade=CascadeType.ALL)
    private EntityAccount entityAccount;

    public Customer() {
	super();
    }

    public Customer(Long id, String firstName, String lastName, EntityAccount entityAccount, int phoneNumber, String role) {
	super(id, firstName, lastName);
	this.phoneNumber = phoneNumber;
	this.entityAccount=entityAccount;
	this.role=role;

    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	public EntityAccount getEntityAccount() {
		return entityAccount;
	}

	public void setEntityAccount(EntityAccount entityAccount) {
		this.entityAccount = entityAccount;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
