package fr.isika.cda17.project3.model.personManagement.accounts;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
@NamedQuery(name = "administrator.findByAdminAccountId", query = "SELECT aa FROM Administrator aa WHERE aa.administratorAccount.id = :c_param")
public class Administrator extends Person {
    
    private String employeeCode;

    @OneToOne(cascade=CascadeType.ALL)
    private AdministratorAccount administratorAccount;
    
    public Administrator() {
	super();
    }

    public Administrator(String employeeCode, AdministratorAccount administratorAccount) {
	super();
	this.employeeCode = employeeCode;
	this.administratorAccount = administratorAccount;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public AdministratorAccount getAdministratorAccount() {
        return administratorAccount;
    }

    public void setAdministratorAccount(AdministratorAccount administratorAccount) {
        this.administratorAccount = administratorAccount;
    }




}
