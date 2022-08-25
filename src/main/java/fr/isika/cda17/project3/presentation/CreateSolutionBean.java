package fr.isika.cda17.project3.presentation;

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
public class CreateSolutionBean {
	
	@Inject
	private SolutionDao solutionDao;
	
	private Solution solution = new Solution();
	
	public void create() {
		Solution created = solutionDao.create(solution);
		System.out.println(created);
	}
		
	
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution=solution;
	}
	


}
