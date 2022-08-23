package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.Optional;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.Dao;

public interface EntityAccountDao extends Dao <EntityAccount>{
    Optional<EntityAccount> findByName(final String name);
}
