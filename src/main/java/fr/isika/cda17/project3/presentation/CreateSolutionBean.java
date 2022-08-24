package fr.isika.cda17.project3.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;
import fr.isika.cda17.project3.model.solutionManagement.ParcelSolution;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class CreateSolutionBean {
	
	@Inject
	private SolutionDao solutionDao;
	
	private Solution solution = new Solution();
	
	CarPoolingSolution carPoolingSolution= new CarPoolingSolution();
	ParcelSolution parcelSolution = new ParcelSolution();
	CustomerInvoice customerInvoice = new CustomerInvoice();	
	
	public void create() {
		solution.setCarPoolingSolution(carPoolingSolution);
		solution.setParcelSolution(parcelSolution);
		solution.setCustomerInvoice(customerInvoice);
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
