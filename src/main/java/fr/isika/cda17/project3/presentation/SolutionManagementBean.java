package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PriceDeal;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;


@ManagedBean
@ViewScoped
public class SolutionManagementBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private SolutionDao solutionDao;

	private List<Solution> solutiontList;
	

	public PaymentSystemChoice[] paymentSystemChoice() {
		return PaymentSystemChoice.values();
	}

	public MessagingSystemChoice[] messagingSystemChoice() {
		return MessagingSystemChoice.values();
	}

	public PriceDeal[] priceDeals() {
		return PriceDeal.values();
	}
	
	@PostConstruct
	public void feeshinit() {
		refresh();
	}

	public void delete(Long id) {
		solutionDao.delete(id);
		refresh();
	}

	private void refresh() {
		solutiontList = solutionDao.findAll();
		
	}

	public List<Solution> getSolutiontList() {
		return solutiontList;
	}

	public void setSolutiontList(List<Solution> solutiontList) {
		this.solutiontList = solutiontList;
	}

	public SolutionDao getSolutionDao() {
	    return solutionDao;
	}

	public void setSolutionDao(SolutionDao solutionDao) {
	    this.solutionDao = solutionDao;
	}

}