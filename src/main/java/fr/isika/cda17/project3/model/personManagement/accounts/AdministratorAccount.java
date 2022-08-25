package fr.isika.cda17.project3.model.personManagement.accounts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class AdministratorAccount extends Account{
    
    public AdministratorAccount() {
	super();
    }
    
  

}
