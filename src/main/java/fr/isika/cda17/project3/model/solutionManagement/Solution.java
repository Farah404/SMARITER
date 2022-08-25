package fr.isika.cda17.project3.model.solutionManagement;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;

@Entity
public class Solution {
    
    @Id
    @GeneratedValue
    private Long id;
    
    
    @Enumerated(EnumType.STRING)
    private PaymentSystemChoice paymentSystemChoice;
    
    @Enumerated(EnumType.STRING)
    private MessagingSystemChoice messagingSystemChoice;
    
    @Enumerated(EnumType.STRING)
    private PriceDeal priceDeal;
    
    private Boolean isRatingSystemIncluded;
    
    private Boolean isCarPoolingsolutionIncluded;
    
    private Boolean isCarRentalSolutionIncluded;
    
    private Boolean isParcelSolutionIncluded;
    
    private Boolean isPersonalAssistanceSolutionIncluded;
    
    private Boolean isPrivate;
    
      
    @ManyToMany
    private List <EntityAccount> entityAccounts = new LinkedList<>();
    
    @OneToOne
    private CustomerInvoice customerInvoice;
    
    @OneToOne
    private CarPoolingSolution carPoolingSolution;
    
    @OneToOne
    private ParcelSolution parcelSolution;
    
//    private Boolean parcelSolutionIncluded;
//       
//    private Boolean PersonalAssistanceSolutionIncluded;
//    
//    private Boolean Private;

    public Solution() {
	super();
    }

    public Solution(Long id, PaymentSystemChoice paymentSystemChoice, MessagingSystemChoice messagingSystemChoice,
	    PriceDeal priceDeal, Boolean isRatingSystemIncluded, Boolean isCarPoolingsolutionIncluded,
	    Boolean isCarRentalSolutionIncluded, Boolean isParcelSolutionIncluded,
	    Boolean isPersonalAssistanceSolutionIncluded, Boolean isPrivate, List<EntityAccount> entityAccounts,
	    CustomerInvoice customerInvoice, CarPoolingSolution carPoolingSolution, ParcelSolution parcelSolution, Boolean parcelSolutionIncluded,Boolean PersonalAssistanceSolutionIncluded) {
	super();
	this.id = id;
	this.paymentSystemChoice = paymentSystemChoice;
	this.messagingSystemChoice = messagingSystemChoice;
	this.priceDeal = priceDeal;
	this.isRatingSystemIncluded = isRatingSystemIncluded;
	this.isCarPoolingsolutionIncluded = isCarPoolingsolutionIncluded;
	this.isCarRentalSolutionIncluded = isCarRentalSolutionIncluded;
	this.isParcelSolutionIncluded = isParcelSolutionIncluded;
	this.isPersonalAssistanceSolutionIncluded = isPersonalAssistanceSolutionIncluded;
	this.isPrivate = isPrivate;
	this.entityAccounts = entityAccounts;
	this.customerInvoice = customerInvoice;
	this.carPoolingSolution = carPoolingSolution;
	this.parcelSolution = parcelSolution;
	//this.parcelSolutionIncluded= parcelSolutionIncluded;
	//this.PersonalAssistanceSolutionIncluded=PersonalAssistanceSolutionIncluded;
	
    }

	public Long getId() {
		return id;
	}



	public PaymentSystemChoice getPaymentSystemChoice() {
		return paymentSystemChoice;
	}

	public void setPaymentSystemChoice(PaymentSystemChoice paymentSystemChoice) {
		this.paymentSystemChoice = paymentSystemChoice;
	}

	public MessagingSystemChoice getMessagingSystemChoice() {
		return messagingSystemChoice;
	}

	public void setMessagingSystemChoice(MessagingSystemChoice messagingSystemChoice) {
		this.messagingSystemChoice = messagingSystemChoice;
	}

	public PriceDeal getPriceDeal() {
		return priceDeal;
	}

	public void setPriceDeal(PriceDeal priceDeal) {
		this.priceDeal = priceDeal;
	}

	public Boolean getIsRatingSystemIncluded() {
		return isRatingSystemIncluded;
	}

	public void setIsRatingSystemIncluded(Boolean isRatingSystemIncluded) {
		this.isRatingSystemIncluded = isRatingSystemIncluded;
	}

	public Boolean isCarPoolingsolutionIncluded() {
		return isCarPoolingsolutionIncluded;
	}

	public void setIsCarPoolingsolutionIncluded(Boolean isCarPoolingsolutionIncluded) {
		this.isCarPoolingsolutionIncluded = isCarPoolingsolutionIncluded;
	}

	public Boolean isCarRentalSolutionIncluded() {
		return isCarRentalSolutionIncluded;
	}

	public void setIsCarRentalSolutionIncluded(Boolean isCarRentalSolutionIncluded) {
		this.isCarRentalSolutionIncluded = isCarRentalSolutionIncluded;
	}

	public Boolean getIsParcelSolutionIncluded() {
		return isParcelSolutionIncluded;
	}

	public void setIsParcelSolutionIncluded(Boolean isParcelSolutionIncluded) {
		this.isParcelSolutionIncluded = isParcelSolutionIncluded;
	}

	public Boolean getIsPersonalAssistanceSolutionIncluded() {
		return isPersonalAssistanceSolutionIncluded;
	}

	public void setIsPersonalAssistanceSolutionIncluded(Boolean isPersonalAssistanceSolutionIncluded) {
		this.isPersonalAssistanceSolutionIncluded = isPersonalAssistanceSolutionIncluded;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public List<EntityAccount> getEntityAccounts() {
		return entityAccounts;
	}

	public void setEntityAccounts(List<EntityAccount> entityAccounts) {
		this.entityAccounts = entityAccounts;
	}

	public CustomerInvoice getCustomerInvoice() {
		return customerInvoice;
	}

	public void setCustomerInvoice(CustomerInvoice customerInvoice) {
		this.customerInvoice = customerInvoice;
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

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsCarPoolingsolutionIncluded() {
		return isCarPoolingsolutionIncluded;
	}

	public Boolean getIsCarRentalSolutionIncluded() {
		return isCarRentalSolutionIncluded;
	}
//
//	public Boolean getParcelSolutionIncluded() {
//		return parcelSolutionIncluded;
//	}
//
//	public void setParcelSolutionIncluded(Boolean parcelSolutionIncluded) {
//		this.parcelSolutionIncluded = parcelSolutionIncluded;
//	}
//
//	public Boolean getPersonalAssistanceSolutionIncluded() {
//		return PersonalAssistanceSolutionIncluded;
//	}
//
//	public void setPersonalAssistanceSolutionIncluded(Boolean personalAssistanceSolutionIncluded) {
//		PersonalAssistanceSolutionIncluded = personalAssistanceSolutionIncluded;
//	}
//
//	public Boolean getPrivate() {
//		return Private;
//	}

//	public void setPrivate(Boolean private1) {
//		Private = private1;
//	}

	
}