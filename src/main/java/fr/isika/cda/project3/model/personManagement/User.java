package fr.isika.cda.project3.model.personManagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class User extends Person{
    
    private String email;
    
    private int phoneNumber;
    
    private Date birthDate;
    
    private int identityCardnumber;
    
    private int drivingPermitNumber;

    public User() {
	super();
    }

    public User(Long id, String firstName, String lastName, String email, int phoneNumber, Date birthDate,
	    int identityCardnumber, int drivingPermitNumber) {
	super(id, firstName, lastName);
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.birthDate = birthDate;
	this.identityCardnumber = identityCardnumber;
	this.drivingPermitNumber = drivingPermitNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getIdentityCardnumber() {
        return identityCardnumber;
    }

    public void setIdentityCardnumber(int identityCardnumber) {
        this.identityCardnumber = identityCardnumber;
    }

    public int getDrivingPermitNumber() {
        return drivingPermitNumber;
    }

    public void setDrivingPermitNumber(int drivingPermitNumber) {
        this.drivingPermitNumber = drivingPermitNumber;
    }

}
