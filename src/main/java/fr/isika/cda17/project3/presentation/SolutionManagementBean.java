package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PriceDeal;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;


@ManagedBean
@ViewScoped
public class SolutionManagementBean implements Serializable {
	
	private static final String LIST_SOLUTION_XHTML= "listSolution.xhtml";
	
	private static final long serialVersionUID = 1L;

	@Inject
	private SolutionDao solutionDao;

	private List<Solution> solutiontList;

	private Solution solution;
	
	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.containsKey("solutionId")) {
			String solutionIdParamValue = map.get("solutionId");
			System.err.println(solutionIdParamValue);
			if (solutionIdParamValue != null && !solutionIdParamValue.isBlank()) {
				Long id = Long.valueOf(solutionIdParamValue);
				if(id != null) {
					solution = solutionDao.findById(id);
					if (solution == null) {
						redirectError();
					}
				} else {
					redirectError();
				}
			} else {
				redirectError();
			}
		}
	}

	public void redirectError() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(LIST_SOLUTION_XHTML);
	}

	public String updapte() {
		solutionDao.update(solution);
		System.out.println((solution));
		return LIST_SOLUTION_XHTML;
	}
	
	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}


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