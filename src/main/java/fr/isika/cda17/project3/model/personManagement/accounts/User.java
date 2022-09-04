package fr.isika.cda17.project3.model.personManagement.accounts;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
			@NamedQuery(name = "user.findByUserAccountId", query = "SELECT u FROM User u WHERE u.userAccount.id = :u_param"),
			@NamedQuery(name = "user.findByShoppingCartId", query = "SELECT u FROM User u WHERE u.userAccount.shoppingCart.id = :shopping_param")
			}
		)
public class User extends Person {

    private int phoneNumber;

    private Date birthDate;

    private int identityCardnumber;

    private int drivingPermitNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAccount userAccount;

    public User() {
	super();
    }

    public User(Long id, String firstName, String lastName, int phoneNumber, Date birthDate, int identityCardnumber,
	    int drivingPermitNumber, UserAccount userAccount) {
	super(id, firstName, lastName);
	this.phoneNumber = phoneNumber;
	this.birthDate = birthDate;
	this.identityCardnumber = identityCardnumber;
	this.drivingPermitNumber = drivingPermitNumber;
	this.userAccount = userAccount;
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

    public UserAccount getUserAccount() {
	return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
	this.userAccount = userAccount;
    }

}
