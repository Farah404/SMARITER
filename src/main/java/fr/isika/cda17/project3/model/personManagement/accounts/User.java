package fr.isika.cda17.project3.model.personManagement.accounts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class User extends Person{
    
    private int phoneNumber;
    
    private Date birthDate;
    
    private int identityCardnumber;
    
    private int drivingPermitNumber;

    public User() {
	super();
    }

    public User(Long id, String firstName, String lastName, int phoneNumber, Date birthDate,
	    int identityCardnumber, int drivingPermitNumber) {
	super(id, firstName, lastName);
	this.phoneNumber = phoneNumber;
	this.birthDate = birthDate;
	this.identityCardnumber = identityCardnumber;
	this.drivingPermitNumber = drivingPermitNumber;
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
