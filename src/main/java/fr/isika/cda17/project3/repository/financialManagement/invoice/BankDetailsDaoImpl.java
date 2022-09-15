package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;

@Stateless
public class BankDetailsDaoImpl implements BankDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BankDetails create(BankDetails bankDetails) {
	try {
	    entityManager.persist(bankDetails);
	    return bankDetails;
	} catch (Exception e) {
	    System.out.println("BankDetailsDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(BankDetails bankDetails) {
	try {
	    BankDetails updatedBankDetails = entityManager.find(BankDetails.class, bankDetails.getId());
	    updatedBankDetails.setBankName(bankDetails.getBankName());
	    updatedBankDetails.setSwift(bankDetails.getSwift());
	    updatedBankDetails.setIban(bankDetails.getIban());
	    entityManager.persist(bankDetails);
	} catch (Exception e) {
	    System.out.println("BankDetailsDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    BankDetails deletedBankDetails = entityManager.find(BankDetails.class, id);
	    entityManager.remove(deletedBankDetails);
	} catch (Exception e) {
	    System.out.println("BankDetailsDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public BankDetails findById(Long id) {
	return entityManager.find(BankDetails.class, id);

    }

    @Override
    public List<BankDetails> findAll() {
	return this.entityManager.createQuery("SELECT bd FROM BankDetails bd", BankDetails.class).getResultList();
    }

}
