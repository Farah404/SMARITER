package project3.entity.solutionManagement;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import project3.entity.financialManagement.ClientInvoice;
import project3.entity.personManagement.EntityAccount;

@Entity
public class Solution {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Enumerated
    private PaymentSystemChoice paymentSystemChoice;
    
    @Enumerated
    private MessagingSystemChoice messagingSystemChoice;
    
    @Enumerated
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
    private ClientInvoice clientInvoice;
    
    @OneToOne
    private CarPoolingSolution carPoolingSolution;
    
    @OneToOne
    private ParcelSolution parcelSolution;

    public Solution() {
	super();
    }

    public Solution(Long id, PaymentSystemChoice paymentSystemChoice, MessagingSystemChoice messagingSystemChoice,
	    PriceDeal priceDeal, Boolean isRatingSystemIncluded, Boolean isCarPoolingsolutionIncluded,
	    Boolean isCarRentalSolutionIncluded, Boolean isParcelSolutionIncluded,
	    Boolean isPersonalAssistanceSolutionIncluded, Boolean isPrivate, List<EntityAccount> entityAccounts,
	    ClientInvoice clientInvoice, CarPoolingSolution carPoolingSolution, ParcelSolution parcelSolution) {
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
	this.clientInvoice = clientInvoice;
	this.carPoolingSolution = carPoolingSolution;
	this.parcelSolution = parcelSolution;
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

    public boolean isRatingSystemIncluded() {
        return isRatingSystemIncluded;
    }

    public void setRatingSystemIncluded(Boolean isRatingSystemIncluded) {
        this.isRatingSystemIncluded = isRatingSystemIncluded;
    }

    public boolean isCarPoolingsolutionIncluded() {
        return isCarPoolingsolutionIncluded;
    }

    public void setCarPoolingsolutionIncluded(Boolean isCarPoolingsolutionIncluded) {
        this.isCarPoolingsolutionIncluded = isCarPoolingsolutionIncluded;
    }

    public boolean isCarRentalSolutionIncluded() {
        return isCarRentalSolutionIncluded;
    }

    public void setCarRentalSolutionIncluded(Boolean isCarRentalSolutionIncluded) {
        this.isCarRentalSolutionIncluded = isCarRentalSolutionIncluded;
    }

    public boolean isParcelSolutionIncluded() {
        return isParcelSolutionIncluded;
    }

    public void setParcelSolutionIncluded(Boolean isParcelSolutionIncluded) {
        this.isParcelSolutionIncluded = isParcelSolutionIncluded;
    }

    public boolean isPersonalAssistanceSolutionIncluded() {
        return isPersonalAssistanceSolutionIncluded;
    }

    public void setPersonalAssistanceSolutionIncluded(Boolean isPersonalAssistanceSolutionIncluded) {
        this.isPersonalAssistanceSolutionIncluded = isPersonalAssistanceSolutionIncluded;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<EntityAccount> getEntityAccounts() {
        return entityAccounts;
    }

    public void setEntityAccounts(List<EntityAccount> entityAccounts) {
        this.entityAccounts = entityAccounts;
    }

    public ClientInvoice getClientInvoice() {
        return clientInvoice;
    }

    public void setClientInvoice(ClientInvoice clientInvoice) {
        this.clientInvoice = clientInvoice;
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

    public Long getId() {
        return id;
    }
    
}
