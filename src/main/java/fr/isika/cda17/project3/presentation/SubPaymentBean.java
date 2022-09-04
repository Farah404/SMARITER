package fr.isika.cda17.project3.presentation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.braintreegateway.TransactionOptionsRequest;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;
import com.braintreegateway.ValidationErrors;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;
import fr.isika.cda17.project3.model.financialManagement.invoice.InvoiceType;
import fr.isika.cda17.project3.model.financialManagement.invoice.StoreInvoice;
import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.financialManagement.brainTree.BrainTreeDao;
import fr.isika.cda17.project3.repository.financialManagement.invoice.CustomerInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.invoice.StoreInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.store.ShoppingCartDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class SubPaymentBean {
    
    @Inject
    private StoreInvoiceDao storeInvoiceDao;
    
    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Inject
    private UserDao userDao;
    
    private String clientToken;

    private BigDecimal amount;

    private String nonce;
    
    private String cardNumber;
    
    private String cardDate;
    
    private String cardCvv;
    
    private String cardName;
    
    private ShoppingCart shoppingCart;
    
    private StoreInvoice storeInvoice;
    
    private User user;

    // BrainTreeSandbox Credentials
    private static BraintreeGateway gateway = null;
    private static String publicKey = "633dfv7hh5cvrh25";
    private static String privateKey = "9138d1a0acf5673f4a0ff57dc08dde65";
    private static String merchantId = "2zx4jdwmxyfkq8jb";
    

    public void init() {
	gateway = connectBraintreeGateway();
	generateClientToken();
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

	if (map.containsKey("shoppingCartId")) {
	    String solutionIdParamValue = map.get("shoppingCartId");
	    if (solutionIdParamValue != null && !solutionIdParamValue.isBlank()) {
		Long id = Long.valueOf(solutionIdParamValue);
		if (id != null) {
			shoppingCart=shoppingCartDao.findById(id);
			amount=BigDecimal.valueOf(shoppingCart.getToBePaidEurosAmount());
		    user = userDao.findByShoppingCartId(shoppingCart.getId());
		}
		}
	    }
	
    }


    public void generateClientToken() {
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

    public BraintreeGateway connectBraintreeGateway() {
	BraintreeGateway braintreeGateway = new BraintreeGateway(Environment.SANDBOX, merchantId, publicKey,
		privateKey);
	return braintreeGateway;
    }

    // Make payment
    public String doSolutionPaymentTransaction() {
//    	receivePaymentMethodNonce();

	TransactionRequest request = new TransactionRequest().amount(amount)
			.paymentMethodNonce(nonce).creditCard().number(cardNumber).expirationDate("01/2024").cvv(cardCvv).done();

	CustomerRequest customerRequest = request.customer();
	customerRequest.email(user.getUserAccount().getEmail());
	customerRequest.firstName(user.getFirstName());
	customerRequest.lastName(user.getLastName());

	
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
	 // Generating invoice
	    double internalCurrencyAmountSelected = (shoppingCart.getBoughtBatchOneQuantity() * shoppingCart.getBatchOneQuantity())
	    		+(shoppingCart.getBoughtBatchTwoQuantity() * shoppingCart.getBatchTwoQuantity())
	    		+(shoppingCart.getBoughtBatchThreeQuantity()*shoppingCart.getBatchThreeQuantity())
	    		+(shoppingCart.getBoughtMonthlySubscriptionQuantity() * shoppingCart.getMonthlySubscriptionQuantity())
	    		+(shoppingCart.getBoughtTrimestrialSubscriptionQuantity() * shoppingCart.getBoughtTrimestrialSubscriptionQuantity())
	    		+(shoppingCart.getBoughtSemestrialSubscriptionQuantity() * shoppingCart.getBoughtSemestrialSubscriptionQuantity());
	    
	    storeInvoice = ((StoreInvoice) new StoreInvoice()
	    		.withIssueDate()
	    		.withInvoiceNumber(createInvoiceNumber()))
	    		.withStoreInvoiceType()
	    		.withCurrencyType()
	    		.withUserAccountPurchaser(user.getUserAccount())
	    		.withAmount(shoppingCart.getToBePaidEurosAmount())
	    		.withInternalCurrencyAmount(internalCurrencyAmountSelected);
	    storeInvoiceDao.create(storeInvoice);
		
		return "subStoreInvoice.xhtml?faces-redirect=true&storeInvoiceId="+ storeInvoice.getId();
	} else {
	    ValidationErrors errors = result.getErrors();
	    validationError(errors);
//	    TODO : delete solution created without payment
//	    solutionDao.delete(solution.getId());
//	    ARUJUNAO errors = > Solution - Customer - EntityAccount Bermuda Triangle
	    return "paymentError.xhtml";
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
//    public void receivePaymentMethodNonce() {
//	String nonceFromTheClient = "fake-valid-mastercard-nonce";
//    	nonce = "fake-valid-mastercard-nonce";
//	return nonceFromTheClient;
//    }

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

    public String createInvoiceNumber() {
    	int ref = storeInvoiceDao.findAll().size()+1;
	    String invoiceNumber= "2022-00"+ref+"-ST";
	    return invoiceNumber;
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
