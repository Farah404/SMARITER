package fr.isika.cda17.project3.model.personManagement.accounts;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Customer extends Person{
    
    private int phoneNumber;
    
    private String email;

    public Customer() {
	super();
    }

    public Customer(Long id, String firstName, String lastName, Account account, int phoneNumber, String email) {
	super(id, firstName, lastName, account);
	this.phoneNumber = phoneNumber;
	this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

}
