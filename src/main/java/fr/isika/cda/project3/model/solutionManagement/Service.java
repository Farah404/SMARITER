package fr.isika.cda.project3.model.solutionManagement;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import fr.isika.cda.project3.model.personManagement.UserAccount;

@Entity
public class Service {
    
    @ManyToMany
    private List <UserAccount> userAccounts = new LinkedList<>();

}
