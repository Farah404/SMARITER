package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.Optional;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.repository.Dao;

public interface UserAccountsDao extends Dao<UserAccount> {
    Optional<UserAccount> findByEmail(final String email);

}
