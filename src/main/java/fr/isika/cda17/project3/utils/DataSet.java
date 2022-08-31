package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.personManagement.assets.VehiculePowerType;
import fr.isika.cda17.project3.model.personManagement.assets.VehiculeType;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;

import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.personManagement.assets.VehiculeType;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;

import fr.isika.cda17.project3.model.personManagement.assets.Insurance;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;

import fr.isika.cda17.project3.model.personManagement.accounts.Person;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;

import fr.isika.cda17.project3.model.personManagement.assets.Insurance;


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

		BankDetails b = new BankDetails();
		b.setBankName("Socièté Générale");
		em.persist(b);

		UserAccount uz = new UserAccount();
		uz.setBankDetails(b);
		uz.setUsername("BIASOO");
		em.persist(uz);
		
		Vehicule v = new Vehicule();
		v.setBrand("BMW");
		v.setRegistrationNumber("A1234B");
		v.setVehiculeType(VehiculeType.MANUAL);
		v.setVehiculePowerType(VehiculePowerType.DIESEL);
		v.setUserAccount(uz);
		em.persist(v);
		
		Itinerary i = new Itinerary();
		i.setFirstStopAddress("gare de lyon part-dieu,69000");
		em.persist(i);

		Trajectory t = new Trajectory();
		t.setDurationHours(1);
		t.setStopDurationMinutes(5);
		t.setPickUpAddress("gare de grenoble,38000");
		t.setDeliveryAddress("gare de lille flandre, 62000");
		t.setTrajectoryType(TrajectoryType.REGULAR);
		t.setItinerary(i);
		em.persist(t);

		CarPoolingService c = new CarPoolingService();
		c.setCarPoolingType(CarPoolingType.HOME_TO_SCHOOL);
		c.setAvailableSeats(3);
		c.setPetAllowed(true);
		c.setSmokingAllowed(false);
		c.setMusicAllowed(false);
		c.setChattingAllowed(true);
		c.setTrajectory(t);
		c.setPrice(10);
		c.setUserAccountProvider(uz);
//TODO		c.setEndDate("22/09/1011");
//TODO		c.setStartDate("23/09/2022");

		em.persist(c);


		BankDetails baa = new BankDetails();
		baa.setBankName("Caisse d'épargne");
		em.persist(baa);
		
		UserAccount ua = new UserAccount();
		ua.setBankDetails(baa);
		ua.setUsername("JULOOO");
		em.persist(ua);
		
		Vehicule va = new Vehicule();
		va.setBrand("BMW");
		va.setRegistrationNumber("A4567B");
		va.setVehiculeType(VehiculeType.MANUAL);
		va.setVehiculePowerType(VehiculePowerType.DIESEL);
		va.setUserAccount(ua);
		em.persist(va);
		
		Itinerary ia = new Itinerary();
		ia.setFirstStopAddress("gare de chambéry challes-les-eaux,73000");
		em.persist(ia);
		
		Trajectory ta = new Trajectory();
		ta.setDurationHours(2);
		ta.setStopDurationMinutes(15);
		ta.setPickUpAddress("gare de grenoble,38000");
		ta.setDeliveryAddress("gare de lille europe, 62000");
		ta.setTrajectoryType(TrajectoryType.PUNCTUAL);
		ta.setItinerary(ia);
		em.persist(ta);

		CarPoolingService ca = new CarPoolingService();
		ca.setCarPoolingType(CarPoolingType.EVENTS);
		ca.setAvailableSeats(2);
		ca.setPetAllowed(false);
		ca.setSmokingAllowed(true);
		ca.setMusicAllowed(true);
		ca.setChattingAllowed(false);
		ca.setTrajectory(ta);
		ca.setPrice(30);
		ca.setUserAccountProvider(ua);
//TODO		ca.setStartDate("23/10/2022");
//TODO		ca.setEndDate("23/10/2022");

		em.persist(ca);




		UserAccount ui =new UserAccount();
		ui.setUsername("MELIODAS");

		Vehicule vi =new Vehicule();
		vi.setBrand("Audi");
		vi.setVehiculeType(VehiculeType.MANUAL);
		vi.setVehiculePowerType(VehiculePowerType.DIESEL);
		vi.setRegistrationNumber("ZAZA1234");
		vi.setUserAccount(ui);

		CarRentalService cr =new CarRentalService();
		cr.setKeyPickUpAddress("26 rue de la martine,Brest");
		cr.setKeyDropOffAddress("5 bis des rue de la joie, Brest");
		cr.setPrice(50);
//TODO		cr.setEndDate("03/09/2022");
//TODO		cr.setStartDate("01/09/2022");
		cr.setServicetype(ServiceType.CAR_RENTAL);
		cr.setVehicule(vi);
		cr.setUserAccountProvider(ui);
		em.persist(cr);

		UserAccount uia =new UserAccount();
		uia.setUsername("ESCANOR");

		Vehicule via =new Vehicule();
		via.setBrand("Mercedes");
		via.setVehiculeType(VehiculeType.MANUAL);
		via.setVehiculePowerType(VehiculePowerType.DIESEL);
		via.setRegistrationNumber("WAWZA4321");
		via.setUserAccount(uia);

		CarRentalService cra =new CarRentalService();
		cra.setKeyPickUpAddress("26 rue de la martine,Marseille");
		cra.setKeyDropOffAddress("5 bis des rue de la joie, Marseille");
		cra.setPrice(25);
//TODO		cra.setEndDate("09/09/2022");
//TODO		cra.setStartDate("05/09/2022");
		cra.setServicetype(ServiceType.CAR_RENTAL);
		cra.setVehicule(via);
		cra.setUserAccountProvider(uia);
		em.persist(cra);

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

//	User dependencies
	BankDetails bdU = new BankDetails();
	bd.setBankName("BankTest");
	bd.setIban("123456789");
	bd.setSwift("456456");
	em.persist(bd);
	
	BillingAddress baU = new BillingAddress();
	ba.setAddressLine("3 rue isika");
	ba.setCity("Paris");
	ba.setCountry("France");
	ba.setPostalCode(0000);
	ba.setRegion("France");
	em.persist(ba);
	
	Insurance iU = new Insurance();
	iU.setInsuranceAgencyName("AXA XVIIIe");
//TODO	iU.setInsuranceContractExpiration(null);
	iU.setInsuranceContractNumber("135903U5B");
	em.persist(iU);
	
	Vehicule vU = new Vehicule();
	vU.setAvailableSeats(4);
	vU.setBrand("Brand");
	vU.setVehiculePowerType(VehiculePowerType.HYBRID);
	vU.setVehiculeType(VehiculeType.MANUAL);
	vU.setInsurance(iU);
	vU.setRegistrationNumber("AA-404-ZZ");
//TODO	vU.setTechnicalTestExpiration(null);
	em.persist(vU);
	
	Wallet wU = new Wallet();
	wU.setInternalCurrencyAmount(50);
//TODO	wU.setStore(null);
	em.persist(wU);
	
	ShoppingCart sCU = new ShoppingCart();
//TODO	sCU.setStore(null);
	em.persist(sCU);
	
	UserAccount uAU = new UserAccount();
	uAU.setEmail("houda@test.com");
	uAU.setUsername("houda");
	uAU.setPassword("1234");
	uAU.setAccountType(AccountType.USER);
	uAU.setVehicule(vU);
	uAU.setBankDetails(bdU);
	uAU.setBillingAddress(baU);
	uAU.setShoppingCart(sCU);
	uAU.setWallet(wU);
	em.persist(uAU);
	
	User u = new User();
	u.setLastName("madi");
	u.setPhoneNumber(0612121212);
	u.setUserAccount(uAU);
//TODO	u.setBirthDate(null);
	u.setDrivingPermitNumber(135315315);
	u.setFirstName("Houda");
	u.setIdentityCardnumber(1141414141);
	em.persist(u);
    }

    
  
    
   // Pour list carPool
	 CarPoolingService ca = new CarPoolingService();
	 Trajectory t = new Trajectory();
	 Vehicule v = new Vehicule();
	 v.setVehiculeType(VehiculeType.MANUAL​);
	 Itinerary i = new Itinerary();
	 UserAccount ua = new UserAccount();
	 ca.setAvailableSeats(3);
	 ca.setIsChattingAllowed(false);
	 ca.setTrajectory(t);
	 ca.setVehicule(v);
	 v.setBrand("BMW");
	 t.setPickUpAddress("poissy");
	 v.setUserAccount(ua);
	 t.setItinerary(i);
	 ua.setUsername("hou");
	 i.setFirstStopAddress("poissy");
	 
	 em.persist(ca);


	// Pour list Rental
	 
	    
	    
		 CarRentalService cr = new CarRentalService();
		 cr.setServicetype(ServiceType.CAR_RENTAL);
		 cr.setKeyDropOffAddress("nante");
		 cr.setPrice(12);
		 Vehicule v1 = new Vehicule();
		 cr.setVehicule(v1);
		 v1.setVehiculeType(VehiculeType.MANUAL​);
		 UserAccount user = new UserAccount();
		 v1.setUserAccount(user);
		 user.setUsername("carR");
		
		
		 user.setUsername("hou");
		
		 
		 em.persist(cr);
		 em.persist(v1);
		 em.persist(user);

		
		
		
		
    }
}