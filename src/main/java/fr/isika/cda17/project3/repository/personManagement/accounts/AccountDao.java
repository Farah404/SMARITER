package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.Optional;

import fr.isika.cda17.project3.model.personManagement.accounts.Account;
import fr.isika.cda17.project3.repository.Dao;

public interface AccountDao extends Dao<Account>{
	Optional<Account> findByEmail(final String email);

}
