package fr.isika.cda17.project3.presentation;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.Transaction.Type;
import com.braintreegateway.TransactionCreditCardRequest;
import com.braintreegateway.TransactionOptionsRequest;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;
import com.braintreegateway.ValidationErrors;

import fr.isika.cda17.project3.repository.financialManagement.brainTree.BrainTreeDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;

@ManagedBean
@ViewScoped
public class PaymentBean {

    @Inject
    private CustomerDao customerDao;

    @Inject
    private BrainTreeDao brainTreeDao;

//    private Customer customer;
//
//    private BrainTree brainTree;

    private String clientToken;

    private BigDecimal amount = BigDecimal.valueOf(0);

    private String nonce;

    // Below are the Braintree sandbox credentials
    private static BraintreeGateway gateway = null;
    private static String publicKey = "633dfv7hh5cvrh25";
    private static String privateKey = "9138d1a0acf5673f4a0ff57dc08dde65";
    private static String merchantId = "2zx4jdwmxyfkq8jb";

    public void init() {
	gateway = connectBraintreeGateway();
	generateClientToken();
    }

    // Make an endpoint which return client token.
    public void generateClientToken() {
	// client token will be generated at server side and return to client
	clientToken = gateway.clientToken().generate();
    }

    // Connect to Braintree Gateway.
    public BraintreeGateway connectBraintreeGateway() {
	BraintreeGateway braintreeGateway = new BraintreeGateway(Environment.SANDBOX, merchantId, publicKey,
		privateKey);
	return braintreeGateway;
    }

    // Make payment
    public void doPaymentTransaction() {
    	receivePaymentMethodNonce();

	TransactionRequest request = new TransactionRequest().amount(amount).paymentMethodNonce(nonce)
		.type(Type.SALE);

	CustomerRequest customerRequest = request.customer();
	customerRequest.email("cpatel@gmail.com");
	customerRequest.firstName("Chirag");
	customerRequest.lastName("Patel");

	
//	TransactionCreditCardRequest tccr = request.creditCard()
//		.number("1234567891234567").cardholderName("Patel Chirag").cvv("200").expirationDate("11/23");
	
	TransactionOptionsRequest options = request.options();
	options.submitForSettlement(true);
	
	// Done the transaction request
	options.done();

	// Create transaction ...
	Result<Transaction> result = gateway.transaction().sale(request);
	boolean isSuccess = result.isSuccess();

	if (isSuccess) {
	    Transaction transaction = result.getTarget();
	    displayTransactionInfo(transaction);
	} else {
	    ValidationErrors errors = result.getErrors();
	    validationError(errors);
	}
    }

    public BigDecimal getAmount() {
	return amount;
    }

    public String getNonce() {
	return nonce;
    }

    public void setClientToken(String clientToken) {
	this.clientToken = clientToken;
    }

    public String getClientToken() {
	return clientToken;
    }

    // Make an endpoint which receive payment method nonce from client and do
    // payment.
    public void receivePaymentMethodNonce() {
//	String nonceFromTheClient = "fake-valid-mastercard-nonce";
    	nonce = "fake-valid-mastercard-nonce";
//	return nonceFromTheClient;
    }

    private void displayTransactionInfo(Transaction transaction) {
	System.out.println(" ------ Transaction Info ------ ");
	System.out.println(" Transaction Id  : " + transaction.getId());
	System.out.println(" Processor Response Text : " + transaction.getProcessorResponseText());
    }

    private void validationError(ValidationErrors errors) {
	List<ValidationError> error = errors.getAllDeepValidationErrors();
	for (ValidationError er : error) {
	    System.out.println(" error code : " + er.getCode());
	    System.out.println(" error message  : " + er.getMessage());
	}
    }

    public void setAmount(BigDecimal amount) {
	this.amount = amount;
    }

    public void setNonce(String nonce) {
	this.nonce = nonce;

    }

}