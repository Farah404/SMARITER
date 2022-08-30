package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

<<<<<<< Updated upstream
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

=======
import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
>>>>>>> Stashed changes
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
    

	EntityAccount ea = new EntityAccount();

<<<<<<< Updated upstream
	ea.setEmail("EcoCar@test.com");
	ea.setPassword("123");

	em.persist(ea);

	
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
	u.setEmail("houda@gmail.COM");
	u.setUsername("houda");
	u.setPassword("1234");
	ue.setLastName("madi");
	ue.setPhoneNumber(0612121212);
	ue.setUserAccount(u);
	em.persist(ue);
    }
    
    
    
=======
	si.setCarRentalSolutionIncluded(false);
	si.setCarPoolingsolutionIncluded(true);
	si.setMessagingSystemChoice(MessagingSystemChoice.NONE);
	si.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
	si.setRatingSystemIncluded(true);
	si.setPriceDeal(PriceDeal.BUSINESS_UNLIMITED);
	si.setPersonalAssistanceSolutionIncluded(true);
	si.setParcelSolutionIncluded(true);
	
	em.persist(si);
  
	EntityAccount eb = new EntityAccount();
	eb.setName("EcoCar");
	eb.setPassword("1234");
	eb.setAccountType(AccountType.ENTITY);
	eb.setEmail("ecocar@text.com");
	em.persist(eb);

	
	Solution sosix = new Solution();
	so.setCarPoolingsolutionIncluded(true);
    so.setCarPoolingsolutionIncluded(true);
    so.setCarRentalSolutionIncluded(false);
    so.setRatingSystemIncluded(true);
    so.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
    so.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	em.persist(sosix);
	

	
	BankDetails b = new BankDetails();
	b.setBankName("Socièté Générale");

	UserAccount u = new UserAccount();
	u.setBankDetails(b);
	u.setUsername("BIASOO");

	Vehicule v = new Vehicule();
	v.setBrand("BMW");
	v.setRegistrationNumber("A1234B");
	v.setElectric(false);
	v.setHybrid(false);
	v.setManual(true);
	v.setUserAccount(u);

	Itinerary i = new Itinerary();
	i.setFirstStopAddress("gare de lyon part-dieu,69000");

	
	Trajectory t = new Trajectory();
	t.setDurationHours(1);
	t.setStopDurationMinutes(5);
	t.setPickUpAddress("gare de grenoble,38000");
	t.setDeliveryAddress("gare de lille flandre, 62000");
	t.setTrajectoryType(TrajectoryType.REGULAR);
	t.setItinerary(i);
	
	
	CarPoolingService c = new CarPoolingService();
	c.setCarPoolingType(CarPoolingType.HOME_TO_SCHOOL);
	c.setAvailableSeats(3);
	c.setIsPetAllowed(true);
	c.setIsSmokingAllowed(false);
	c.setIsMusicAllowed(false);
	c.setIsChattingAllowed(true);
	c.setVehicule(v);
	c.setTrajectory(t);
	
	em.persist(c);
	
	
	BankDetails ba = new BankDetails();
	ba.setBankName("Caisse d'épargne");
	
	UserAccount ua = new UserAccount();
	ua.setBankDetails(ba);
	ua.setUsername("JULOOO");

	Vehicule va = new Vehicule();
	va.setBrand("BMW");
	va.setRegistrationNumber("A4567B");
	va.setElectric(true);
	va.setHybrid(false);
	va.setManual(false);
	va.setUserAccount(ua);

	Itinerary ia = new Itinerary();
	ia.setFirstStopAddress("gare de chambéry challes-les-eaux,73000");
	
	Trajectory ta = new Trajectory();
	ta.setDurationHours(2);
	ta.setStopDurationMinutes(15);
	ta.setPickUpAddress("gare de grenoble,38000");
	ta.setDeliveryAddress("gare de lille europe, 62000");
	ta.setTrajectoryType(TrajectoryType.PUNCTUAL);
	ta.setItinerary(ia);
	
	
	CarPoolingService ca = new CarPoolingService();
	ca.setCarPoolingType(CarPoolingType.EVENTS);
	ca.setAvailableSeats(2);
	ca.setIsPetAllowed(false);
	ca.setIsSmokingAllowed(true);
	ca.setIsMusicAllowed(true);
	ca.setIsChattingAllowed(false);
	ca.setVehicule(va);
	ca.setTrajectory(ta);
	
	em.persist(ca);
	
	
	
	
	UserAccount ui =new UserAccount();
	ui.setUsername("MELIODAS");
	
	Vehicule vi =new Vehicule();
	vi.setBrand("Audi");
	vi.setElectric(false);
	vi.setRegistrationNumber("ZAZA1234");
	vi.setHybrid(false);
	vi.setManual(false);
	vi.setUserAccount(ui);
	
	CarRentalService cr =new CarRentalService();
	cr.setKeyPickUpAddress("26 rue de la martine,Brest");
	cr.setKeyDropOffAddress("5 bis des rue de la joie, Brest");
	cr.setPrice(50);
	cr.setEndDate("03/09/2022");
	cr.setStartDate("01/09/2022");
	cr.setServicetype(ServiceType.CAR_RENTAL);
	cr.setVehicule(vi);
	em.persist(cr);
	
	UserAccount uia =new UserAccount();
	uia.setUsername("ESCANOR");
	
	Vehicule via =new Vehicule();
	via.setBrand("Mercedes");
	via.setElectric(true);
	via.setRegistrationNumber("WAWZA4321");
	via.setHybrid(false);
	via.setManual(false);
	via.setUserAccount(uia);
	
	CarRentalService cra =new CarRentalService();
	cra.setKeyPickUpAddress("26 rue de la martine,Marseille");
	cra.setKeyDropOffAddress("5 bis des rue de la joie, Marseille");
	cra.setPrice(25);
	cra.setEndDate("09/09/2022");
	cra.setStartDate("05/09/2022");
	cra.setServicetype(ServiceType.CAR_RENTAL);
	cra.setVehicule(via);
	em.persist(cra);

	
	
	
	
	
	
    }
    
    
>>>>>>> Stashed changes

}