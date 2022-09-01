package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.ParcelService;

@Stateless
public class ParcelServiceDaoImpl implements ParcelServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ParcelService create(ParcelService parcelService) {
	try {
	    entityManager.persist(parcelService);
	    return parcelService;
	} catch (Exception e) {
	    System.out.println("ParcelServiceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(ParcelService parcelService) {
	try {
	    ParcelService updatedParcelService = entityManager.find(ParcelService.class, parcelService.getId());
	    updatedParcelService.setPublicationDate(parcelService.getPublicationDate());
	    updatedParcelService.setExpirationDate(parcelService.getExpirationDate());
	    updatedParcelService.setStartDate(parcelService.getStartDate());
	    updatedParcelService.setEndDate(parcelService.getEndDate());
	    updatedParcelService.setReferenceNumber(parcelService.getReferenceNumber());
	    updatedParcelService.setIsRequest(parcelService.getIsRequest());
	    updatedParcelService.setPrice(parcelService.getPrice());

	    updatedParcelService.setBarCode(parcelService.getBarCode());
	    updatedParcelService.setWeightKilogrammes(parcelService.getWeightKilogrammes());
	    updatedParcelService.setAtypicalVolume(parcelService.isAtypicalVolume());
	    updatedParcelService.setFragile(parcelService.isFragile());

	    entityManager.persist(parcelService);
	} catch (Exception e) {
	    System.out.println("ParcelServiceDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    ParcelService deletedParcelService = entityManager.find(ParcelService.class, id);
	    entityManager.remove(deletedParcelService);
	} catch (Exception e) {
	    System.out.println("ParcelServiceDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public ParcelService findById(Long id) {
	return entityManager.find(ParcelService.class, id);

    }

    @Override
    public List<ParcelService> findAll() {
	List<ParcelService> pSList = this.entityManager
		.createQuery("SELECT ps FROM ParcelService ps", ParcelService.class).getResultList();
	return pSList;
    }

	@Override
	public List<ParcelService> findAllUserParcelServices(Long id) {
		List<ParcelService> psUserList = this.entityManager.createNamedQuery("ParcelService.findAllUserPS", ParcelService.class).setParameter("userid_param", id).getResultList();
		return psUserList;
	}

}
