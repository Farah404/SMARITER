package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Account;
import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;

import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.Person;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;

import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PriceDeal;
import fr.isika.cda17.project3.model.solutionManagement.Solution;

@Singleton
@Startup
public class DataSet {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void initData() {
    

	AdministratorAccount aa = new AdministratorAccount();
	aa.setAccountType(AccountType.ADMINISTRATOR);
	aa.setEmail("devTeam@smariter.com");
	aa.setPassword("smariter123");
	aa.setUsername("SmartAdmin");
	em.persist(aa);
	
	Administrator a = new Administrator();
	a.setEmployeeCode("EC102");
	a.setFirstName("First");
	a.setLastName("Last");
	a.setAdministratorAccount(aa);
	em.persist(a);
	
	BankDetails bd = new BankDetails();
	bd.setBankName("BankTest");
	bd.setIban("123456789");
	bd.setSwift("456456");
	em.persist(bd);
	
	BillingAddress ba = new BillingAddress();
	ba.setAddressLine("3 rue isika");
	ba.setCity("Paris");
	ba.setCountry("France");
	ba.setPostalCode(0000);
	ba.setRegion("France");
	em.persist(ba);
	
	Solution s = new Solution();
	s.setCarPoolingsolutionIncluded(true);
	s.setCarRentalSolutionIncluded(true);
	s.setParcelSolutionIncluded(true);
	s.setPersonalAssistanceSolutionIncluded(false);
	s.setMessagingSystemChoice(MessagingSystemChoice.SERVICE_RELATED_MESSAGING);
	s.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
	s.setPriceDeal(PriceDeal.BUSINESS_UNLIMITED);
	s.setSolutionName("EcoCar");
	em.persist(s);
	
	EntityAccount ea = new EntityAccount();
	ea.setAccountType(AccountType.ENTITY);
	ea.setEmail("test@test.com");
	ea.setPassword("123");
	ea.setUsername("CustomerTest");
	ea.setName("EcoCar");
	ea.setSiretNumber(8);
	ea.setBankDetails(bd);
	ea.setBillingAddress(ba);
	ea.setSolution(s);
	em.persist(ea);	
	
	Customer test = new Customer();
	test.setFirstName("firstName");
	test.setLastName("lastName");
	test.setPhoneNumber(0);
	test.setRole("Customer");
	test.setEntityAccount(ea);
	em.persist(test);
	
	

	UserAccount u = new UserAccount();
	User ue = new User();
	u.setEmail("houda@gmail.com");
	u.setUsername("houda");
	u.setPassword("1234");
	ue.setLastName("madi");
	ue.setPhoneNumber(0612121212);
	ue.setUserAccount(u);
	u.setAccountType(AccountType.USER);
	em.persist(ue);
    }
    
    
    

}