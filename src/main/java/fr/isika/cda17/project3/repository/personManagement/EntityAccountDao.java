package fr.isika.cda17.project3.repository.personManagement;

import java.util.Optional;

import fr.isika.cda17.project3.model.personManagement.EntityAccount;
import fr.isika.cda17.project3.repository.Dao;

public interface EntityAccountDao extends Dao <EntityAccount>{
    Optional<EntityAccount> findByEmail(final String email);
}
