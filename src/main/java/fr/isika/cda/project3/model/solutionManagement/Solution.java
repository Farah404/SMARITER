package fr.isika.cda.project3.model.solutionManagement;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import fr.isika.cda.project3.model.personManagement.EntityAccount;

@Entity
public class Solution {

    @ManyToMany
    private List <EntityAccount> entityAccounts = new LinkedList<>();
    
}
