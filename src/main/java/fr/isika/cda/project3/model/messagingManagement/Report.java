package fr.isika.cda.project3.model.messagingManagement;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.isika.cda.project3.model.personManagement.UserAccount;

@Entity
public class Report {
    
    @ManyToOne
    private UserAccount userAccount;

}
