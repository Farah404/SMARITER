package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.Optional;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.repository.Dao;

public interface CustomerDao extends Dao <Customer> {
	Customer findByEntityAccountId(Long id);
}
