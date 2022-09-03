package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;
import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.ParcelSolution;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PriceDeal;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.model.solutionManagement.TemplateChoice;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class CreateSolutionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SolutionDao solutionDao;

    @Inject
    private CustomerDao customerDao;
    
    @Inject
    private EntityAccountDao entityAccountDao;
    
    private Solution solution = new Solution();
    
    private Customer customer;
    
    private EntityAccount entityAccount;

    private CarPoolingSolution carPoolingSolution = new CarPoolingSolution();
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
    
    public TemplateChoice[] templateChoiceValues() {
    	return TemplateChoice.values();
        }

    public String create() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    if(session != null) {
    	Long id = Long.valueOf(session.getAttribute("id").toString());
        customer = customerDao.findByEntityAccountId(id);
        solution.setCarPoolingSolution(carPoolingSolution);
    	solution.setParcelSolution(parcelSolution);
    	solution.setCustomerInvoice(customerInvoice);
    	solution.setCustomer(customer);
    	customer.getEntityAccount().setSolution(solution);  
    	customerDao.update(customer);
    	customer = customerDao.findByEntityAccountId(id);
    	Long idSolution = customer.getEntityAccount().getSolution().getId();
    	return "paymentForm.xhtml?faces-redirect=true&solutionId="+ idSolution;
    }
    else {
    	return "logInSignUp.xhtml";
    }
    
    }

    public Solution getSolution() {
	return solution;
    }

    public void setSolution(Solution solution) {
	this.solution = solution;
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
