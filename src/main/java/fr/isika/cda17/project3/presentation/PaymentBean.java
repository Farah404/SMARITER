package fr.isika.cda17.project3.presentation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

    private BigDecimal amount;

    private String nonce;
    
    private String cardNumber;
    
    private String cardDate;
    
    private String cardCvv;
    
    private String cardName;
    
    private Long solutionId;
    

    // Below are the Braintree sandbox credentials
    private static BraintreeGateway gateway = null;
    private static String publicKey = "633dfv7hh5cvrh25";
    private static String privateKey = "9138d1a0acf5673f4a0ff57dc08dde65";
    private static String merchantId = "2zx4jdwmxyfkq8jb";
    

    public void init() {
	gateway = connectBraintreeGateway();
	generateClientToken();
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

	if (map.containsKey("solutionId")) {
	    String solutionIdParamValue = map.get("solutionId");
	    if (solutionIdParamValue != null && !solutionIdParamValue.isBlank()) {
		Long id = Long.valueOf(solutionIdParamValue);
		if (id != null) {
			solutionId=id;
		    
		}}}
	if (map.containsKey("solutionAmount")) {
	    String solutionAmountParamValue = map.get("solutionAmount");
	    if (solutionAmountParamValue != null && !solutionAmountParamValue.isBlank()) {
		Double amountToSet = Double.valueOf(solutionAmountParamValue);
		BigDecimal amountToSetBD = BigDecimal.valueOf(amountToSet);
		if (amountToSetBD != null) {
			amount=amountToSetBD;
		    
		}}}
    }

    // Make an endpoint which return client token.
    public void generateClientToken() {
	// client token will be generated at server side and return to client
	clientToken = gateway.clientToken().generate();
    }

    public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardDate() {
		return cardDate;
	}

	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}

	public String getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}

	// Connect to Braintree Gateway.
    public BraintreeGateway connectBraintreeGateway() {
	BraintreeGateway braintreeGateway = new BraintreeGateway(Environment.SANDBOX, merchantId, publicKey,
		privateKey);
	return braintreeGateway;
    }

    // Make payment
    public void doPaymentTransaction() {
//    	receivePaymentMethodNonce();

	TransactionRequest request = new TransactionRequest().amount(amount).paymentMethodNonce(nonce).creditCard().number(cardNumber).expirationDate("01/2024").cvv(cardCvv).done();

	CustomerRequest customerRequest = request.customer();
	customerRequest.email("notPatel@gmail.com");
	customerRequest.firstName("Falal");
	customerRequest.lastName("NotRacist");

	
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

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

}
