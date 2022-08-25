package fr.isika.cda17.project3.repository.personManagement.accounts;
import java.util.Optional;

import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;
import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;

import fr.isika.cda17.project3.repository.Dao;

public interface AdministratorDao extends Dao <Administrator>{
    
	 Optional<AdministratorAccount> findByEmail(final String email);
  
}