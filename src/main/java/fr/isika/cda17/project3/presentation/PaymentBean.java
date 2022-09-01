package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Request;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

import fr.isika.cda17.project3.model.financialManagement.brainTree.BrainTree;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.repository.financialManagement.brainTree.BrainTreeDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;
@ManagedBean
@ViewScoped
public class PaymentBean implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -3492910063337920040L;

	@Inject
	private CustomerDao customerDao;

	@Inject
	private BrainTreeDao brainTreeDao;

	private Customer customer;

	private BrainTree brainTree;


	private static BraintreeGateway gateway = new BraintreeGateway(
			  Environment.SANDBOX,
			  "2zx4jdwmxyfkq8jb",
			  "633dfv7hh5cvrh25",
			  "9138d1a0acf5673f4a0ff57dc08dde65"
			);
		public String clientTokenRequest() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		if(id != null) {
			customer = customerDao.findByEntityAccountId(id);
		}
		ClientTokenRequest clientTokenRequest = new ClientTokenRequest().customerId(customer.getId().toString());
		// pass clientToken to your front-end
		System.out.println(clientTokenRequest);
		String clientToken = gateway.clientToken().generate(clientTokenRequest);
		System.out.println(clientToken);
		return clientToken;
	}

//	  @Override
//	public Object handle(Request request, Response response) {
//	    return gateway.clientToken().generate();
//	  }	
//	  @Override
//	public Object handle(Request request, Response response) {
//	    String nonceFromTheClient = request.queryParams("payment_method_nonce");
//	@Override
//	public Object handle(Request request, Response response) {
//	    String nonceFromTheClient = request.queryParams("payment_method_nonce");



	public String processTransaction() {
		BrainTree created = brainTreeDao.create(brainTree);
        System.out.println("Processing transaction");
        TransactionRequest request = new TransactionRequest().amount(new BigDecimal(brainTree.getChargeAmount()))
                .paymentMethodNonce(brainTree.getNonce()).deviceData(brainTree.getDeviceData()).options()
                .submitForSettlement(true).done();
        Result<Transaction> transactionResult = gateway.transaction().sale(request);
        Transaction transaction;
        if (transactionResult.isSuccess()) {
        	System.out.println("TransactionSucceed");
            transaction = transactionResult.getTarget();
            return transaction.getId();
        }else {
        	System.out.println("TransactionFailed");
        	transaction=null;
        	return transaction.getId();
        }
}

	public BrainTree getBrainTree() {
		return brainTree;
	}

	public void setBrainTree(BrainTree brainTree) {
		this.brainTree = brainTree;
	}

}