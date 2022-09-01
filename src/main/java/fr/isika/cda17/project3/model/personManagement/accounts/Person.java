package fr.isika.cda17.project3.model.personManagement.accounts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    public Person() {
	super();
    }

    public Person(Long id, String firstName, String lastName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public Long getId() {
	return id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

}
