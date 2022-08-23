package fr.isika.cda17.project3.model.personManagement;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Administrator extends Person {
    
    private String employeeCode;

   
    public Administrator() {
	super();
    }

    public Administrator(Long id, String firstName, String lastName, Account account, String employeeCode) {
	super(id, firstName, lastName, account);
	this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }


}
