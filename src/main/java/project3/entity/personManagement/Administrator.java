package project3.entity.personManagement;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Administrator extends Person {
    
    private String employeeCode;

   
    public Administrator() {
	super();
    }

    public Administrator(Long id, String firstName, String lastName, String employeeCode) {
	super(id, firstName, lastName);
	this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }


}