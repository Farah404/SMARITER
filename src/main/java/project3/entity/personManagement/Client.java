package project3.entity.personManagement;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Client extends Person{
    
    private int phoneNumber;
    
    private String email;

    public Client() {
	super();
    }

    public Client(Long id, String firstName, String lastName, int phoneNumber, String email) {
	super(id, firstName, lastName);
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
