package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;
import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.ParcelSolution;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PriceDeal;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class CreateSolutionBean implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SolutionDao solutionDao;
	
	private Solution solution = new Solution();
	
	private CarPoolingSolution carPoolingSolution= new CarPoolingSolution();
	private ParcelSolution parcelSolution = new ParcelSolution();
	private CustomerInvoice customerInvoice = new CustomerInvoice();
	
	public PaymentSystemChoice[] paymentSystemValue() {
		return PaymentSystemChoice.values();
	}
	public PriceDeal[] priceDeal() {
		return PriceDeal.values();
	}
	public MessagingSystemChoice[] messagingSystemChoicesValues() {
		return MessagingSystemChoice.values();
	}
	
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
	public CarPoolingSolution getCarPoolingSolution() {
		return carPoolingSolution;
	}
	public void setCarPoolingSolution(CarPoolingSolution carPoolingSolution) {
		this.carPoolingSolution = carPoolingSolution;
	}
	public ParcelSolution getParcelSolution() {
		return parcelSolution;
	}
	public void setParcelSolution(ParcelSolution parcelSolution) {
		this.parcelSolution = parcelSolution;
	}
	public CustomerInvoice getCustomerInvoice() {
		return customerInvoice;
	}
	public void setCustomerInvoice(CustomerInvoice customerInvoice) {
		this.customerInvoice = customerInvoice;
	}


}
