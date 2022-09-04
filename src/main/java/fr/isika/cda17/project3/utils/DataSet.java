package fr.isika.cda17.project3.utils;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.financialManagement.store.Store;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;
import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Insurance;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.model.personManagement.assets.VehiculePowerType;
import fr.isika.cda17.project3.model.personManagement.assets.VehiculeType;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingType;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.serviceManagement.Trajectory;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;
import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.ParcelSolution;
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

	// Admin Account
	AdministratorAccount ad = new AdministratorAccount();
	ad.setProfilePicturePath(null);
	ad.setIsActive(true);
	ad.setCreationDate(LocalDateTime.now());
	ad.setAccountType(AccountType.ADMINISTRATOR);
	ad.setEmail("admin.smariter@gmail.com");
	ad.setPassword("admin");
	ad.setUsername("Administartor");
	ad.setIsActive(true);
	em.persist(ad);

	Administrator adm = new Administrator();
	adm.setAdministratorAccount(ad);
	adm.setEmployeeCode("ze125 R3");
	adm.setFirstName("François");
	adm.setLastName("noel");
	em.persist(adm);

	// Solution "Je veux depanner"
	CarPoolingSolution cs = new CarPoolingSolution();
	cs.setAvailableSeatsOption(true);
	cs.setCarPoolingTypeOption(true);
	cs.setMusicAllowedOption(false);
	cs.setPetAllowedOption(true);
	cs.setSmokingAllowedOption(true);
	cs.setChattingAllowedOption(false);
	em.persist(cs);
	ParcelSolution ps = new ParcelSolution();
	ps.setAtypicalVolumeOption(false);
	ps.setFragileOoption(true);
	ps.setWeightKilogrammesOption(true);
	em.persist(ps);
	Solution so = new Solution();
	so.setCarPoolingSolution(cs);
	so.setCarPoolingsolutionIncluded(true);
	so.setCarRentalSolutionIncluded(false);
	so.setRatingSystemIncluded(false);
	so.setSolutionName("Je veux dépanner");
	so.setParcelSolutionIncluded(true);
	so.setParcelSolution(ps);
	so.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
	so.setPersonalAssistanceSolutionIncluded(true);
	so.setPriceDeal(PriceDeal.BUSINESS_UNLIMITED);
	so.setMessagingSystemChoice(MessagingSystemChoice.SERVICE_RELATED_MESSAGING);
	so.setRatingSystemIncluded(true);
	em.persist(so);
	BankDetails ba = new BankDetails();
	ba.setBankName("BNP");
	ba.setIban("z12 698743 54ry");
	ba.setSwift("z123");
	em.persist(ba);
	BillingAddress bi = new BillingAddress();
	bi.setAddressLine("13, rue de paris");
	bi.setCity("brest");
	bi.setCountry("France");
	bi.setRegion("Bretagne");
	bi.setPostalCode(29200);
	em.persist(bi);
	EntityAccount ea = new EntityAccount();
	ea.setProfilePicturePath(null);
	ea.setIsActive(true);
	ea.setCreationDate(LocalDateTime.now());
	ea.setEmail("jules.company@gmail.com");
	ea.setPassword("jules");
	ea.setName("Bias");
	ea.setSolution(so);
	ea.setBankDetails(ba);
	ea.setAccountType(AccountType.ENTITY);
	ea.setSiretNumber(573002678);
	ea.setBillingAddress(bi);
	em.persist(ea);
	Customer cu = new Customer();
	cu.setFirstName("jules");
	cu.setLastName("Bias");
	cu.setPhoneNumber(672438672);
	cu.setEntityAccount(ea);
	cu.setRole("Directeur");
	so.setCustomer(cu);
	em.persist(cu);

	// Solution "EcoCar"
	CarPoolingSolution cs1 = new CarPoolingSolution();
	cs1.setAvailableSeatsOption(true);
	cs1.setCarPoolingTypeOption(true);
	cs1.setMusicAllowedOption(true);
	cs1.setPetAllowedOption(true);
	cs1.setSmokingAllowedOption(true);
	cs1.setChattingAllowedOption(true);
	em.persist(cs1);
	ParcelSolution ps1 = new ParcelSolution();
	ps1.setAtypicalVolumeOption(true);
	ps1.setFragileOoption(true);
	ps1.setWeightKilogrammesOption(true);
	em.persist(ps1);
	Solution so1 = new Solution();
	so1.setCarPoolingSolution(cs1);
	so1.setCarPoolingsolutionIncluded(true);
	so1.setCarRentalSolutionIncluded(true);
	so1.setRatingSystemIncluded(false);
	so1.setSolutionName("EcoCar");
	so1.setParcelSolutionIncluded(true);
	so1.setParcelSolution(ps1);
	so1.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
	so1.setPersonalAssistanceSolutionIncluded(true);
	so1.setPriceDeal(PriceDeal.BUSINESS_VIP);
	so1.setMessagingSystemChoice(MessagingSystemChoice.SERVICE_RELATED_MESSAGING);
	so1.setRatingSystemIncluded(false);
	em.persist(so1);
	BankDetails ba1 = new BankDetails();
	ba1.setBankName("LCL");
	ba1.setIban("z12 91543 54ry");
	ba1.setSwift("p693");
	em.persist(ba1);
	BillingAddress bi1 = new BillingAddress();
	bi1.setAddressLine("7, Av du prado");
	bi1.setCity("Marseille");
	bi1.setCountry("France");
	bi1.setRegion("BProvence-Alpes-Côte d'Azur");
	bi1.setPostalCode(13000);
	em.persist(bi1);
	EntityAccount ea1 = new EntityAccount();
	ea1.setProfilePicturePath(null);
	ea1.setIsActive(true);
	ea1.setCreationDate(LocalDateTime.now());
	ea1.setEmail("farah.company@gmail.com");
	ea1.setPassword("farah");
	ea1.setName("Ecolo");
	ea1.setSolution(so1);
	ea1.setBankDetails(ba1);
	ea1.setAccountType(AccountType.ENTITY);
	ea1.setSiretNumber(573002678);
	ea1.setBillingAddress(bi1);
	em.persist(ea1);
	Customer cu1 = new Customer();
	cu1.setFirstName("Farah");
	cu1.setLastName("Taleb");
	cu1.setPhoneNumber(651293872);
	cu1.setRole("Directeur");
	cu1.setEntityAccount(ea1);
	so1.setCustomer(cu1);
	em.persist(cu1);

	// Solution "EcoMobil"
	CarPoolingSolution cs2 = new CarPoolingSolution();
	cs2.setAvailableSeatsOption(true);
	cs2.setCarPoolingTypeOption(false);
	cs2.setMusicAllowedOption(false);
	cs2.setPetAllowedOption(true);
	cs2.setSmokingAllowedOption(true);
	cs2.setChattingAllowedOption(false);
	em.persist(cs2);
	ParcelSolution ps2 = new ParcelSolution();
	ps2.setAtypicalVolumeOption(true);
	ps2.setFragileOoption(true);
	ps2.setWeightKilogrammesOption(true);
	em.persist(ps2);
	Solution so2 = new Solution();
	so2.setCarPoolingSolution(cs2);
	so2.setCarPoolingsolutionIncluded(true);
	so2.setCarRentalSolutionIncluded(true);
	so2.setRatingSystemIncluded(false);
	so2.setSolutionName("EcoMobil'");
	so2.setParcelSolutionIncluded(true);
	so2.setParcelSolution(ps2);
	so2.setPaymentSystemChoice(PaymentSystemChoice.MONETARY);
	so2.setPersonalAssistanceSolutionIncluded(false);
	so2.setPriceDeal(PriceDeal.BUSINESS_BASIC);
	so2.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	so2.setRatingSystemIncluded(false);
	em.persist(so2);
	BankDetails ba2 = new BankDetails();
	ba2.setBankName("Société Générale");
	ba2.setIban("z12 692143 54ry");
	ba2.setSwift("z143");
	em.persist(ba2);
	Store s2 = new Store();
	s2.setBatchOneName("ECOMOBIL'");
	s2.setBatchOneQuantity(1);
	em.persist(s2);
	BillingAddress bi2 = new BillingAddress();
	bi2.setAddressLine("10,Av du la valliette");
	bi2.setCity("Aix-en-provence");
	bi2.setCountry("France");
	bi2.setRegion("BProvence-Alpes-Côte d'Azur");
	bi2.setPostalCode(13000);
	em.persist(bi2);
	EntityAccount ea2 = new EntityAccount();
	ea2.setProfilePicturePath(null);
	ea2.setIsActive(true);
	ea2.setCreationDate(LocalDateTime.now());
	ea2.setEmail("houda.company@gmail.com");
	ea2.setPassword("houda");
	ea2.setName("EcoTransport");
	ea2.setSolution(so2);
	ea2.setBankDetails(ba2);
	ea2.setAccountType(AccountType.ENTITY);
	ea2.setSiretNumber(573002678);
	ea2.setBillingAddress(bi2);
	em.persist(ea2);
	Customer cu2 = new Customer();
	cu2.setFirstName("Houda");
	cu2.setLastName("Madi");
	cu2.setPhoneNumber(623576202);
	cu2.setRole("directeur");
	cu2.setEntityAccount(ea2);
	so2.setCustomer(cu2);
	em.persist(cu2);

	// Solution "GoCar"
	CarPoolingSolution cs15 = new CarPoolingSolution();
	cs15.setAvailableSeatsOption(true);
	cs15.setCarPoolingTypeOption(false);
	cs15.setMusicAllowedOption(true);
	cs15.setPetAllowedOption(false);
	cs15.setSmokingAllowedOption(false);
	cs15.setChattingAllowedOption(false);
	em.persist(cs15);
	ParcelSolution ps15 = new ParcelSolution();
	ps15.setAtypicalVolumeOption(true);
	ps15.setFragileOoption(true);
	ps15.setWeightKilogrammesOption(true);
	em.persist(ps15);
	Solution so15 = new Solution();
	so15.setCarPoolingSolution(cs15);
	so15.setCarPoolingsolutionIncluded(true);
	so15.setCarRentalSolutionIncluded(true);
	so15.setRatingSystemIncluded(false);
	so15.setSolutionName("GO CAR");
	so15.setParcelSolutionIncluded(true);
	so15.setParcelSolution(ps15);
	so15.setPaymentSystemChoice(PaymentSystemChoice.MONETARY);
	so15.setPersonalAssistanceSolutionIncluded(false);
	so15.setPriceDeal(PriceDeal.BUSINESS_VIP);
	so15.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	so15.setRatingSystemIncluded(false);
	em.persist(so15);
	BankDetails ba15 = new BankDetails();
	ba15.setBankName("Société Générale");
	ba15.setIban("z115 69151415 54ry");
	ba15.setSwift("z1415");
	em.persist(ba15);
	BillingAddress bi15 = new BillingAddress();
	bi15.setAddressLine("10,Av du la valliette");
	bi15.setCity("Aix-en-provence");
	bi15.setCountry("France");
	bi15.setRegion("BProvence-Alpes-Côte d'Azur");
	bi15.setPostalCode(115000);
	em.persist(bi15);
	EntityAccount ea15 = new EntityAccount();
	ea15.setProfilePicturePath(null);
	ea15.setIsActive(true);
	ea15.setCreationDate(LocalDateTime.now());
	ea15.setEmail("houda.company@gmail.com");
	ea15.setPassword("houda");
	ea15.setName("EcoTransport");
	ea15.setSolution(so15);
	ea15.setBankDetails(ba15);
	ea15.setAccountType(AccountType.ENTITY);
	ea15.setSiretNumber(57115678);
	ea15.setBillingAddress(bi15);
	em.persist(ea15);
	Customer cu15 = new Customer();
	cu15.setFirstName("Houda");
	cu15.setLastName("Madi");
	cu15.setPhoneNumber(615155015);
	cu15.setRole("Directeur");
	cu15.setEntityAccount(ea15);
	so15.setCustomer(cu15);
	em.persist(cu15);

////////////////////////***************************************************************////////////////////////////    

	// Services - Car Rental

	User us = new User();
	us.setDrivingPermitNumber(8365530);
	us.setPhoneNumber(629182054);
	us.setFirstName("zack");
	us.setLastName("Ghan");
	us.setIdentityCardnumber(1423576987);
	em.persist(us);

	Wallet w = new Wallet();
	w.setInternalCurrencyAmount(140);
	em.persist(w);

	BankDetails ba3 = new BankDetails();
	ba3.setBankName("Société Générale");
	ba3.setIban("z12 69642r3 54ry");
	ba3.setSwift("542");
	em.persist(ba3);

	BillingAddress bi3 = new BillingAddress();
	bi3.setAddressLine("40,Av la ville");
	bi3.setCity("Monteplier");
	bi3.setCountry("France");
	bi3.setRegion("BProvence-Alpes-Côte d'Azur");
	bi3.setPostalCode(13005);
	em.persist(bi3);

	Insurance i = new Insurance();
	i.setInsuranceAgencyName("Axa assurance");
	i.setInsuranceContractNumber("Z2864XC43");
	em.persist(i);

	UserAccount u = new UserAccount();
	u.setProfilePicturePath(null);
	u.setIsActive(true);
	u.setCreationDate(LocalDateTime.now());
	u.setAccountType(AccountType.USER);
	u.setBankDetails(ba3);
	u.setBillingAddress(bi3);
	u.setEmail("zack.get@gmail.com");
	u.setPassword("zack");
	u.setUsername("Zack");
	u.setWallet(w);
	us.setUserAccount(u);
	em.persist(u);

	Vehicule v = new Vehicule();
	v.setBrand("BMW");
	v.setInsurance(i);
	v.setRegistrationNumber("AS852XZ");
	v.setVehiculePowerType(VehiculePowerType.HYBRID);
	v.setVehiculeType(VehiculeType.AUTOMATIC);
	v.setUserAccount(u);
	u.setVehicule(v);
	v.setAvailableSeats(5);
	em.persist(u);

	ServiceInvoice si = new ServiceInvoice();
	em.persist(si);

	Reservation r = new Reservation();
	r.setServiceinvoice(si);
	em.persist(r);

	BankDetails ba4 = new BankDetails();
	ba4.setBankName("Société Générale");
	ba4.setIban("z12 69642r3 54ry");
	ba4.setSwift("542");
	em.persist(ba4);

	BillingAddress bi4 = new BillingAddress();
	bi4.setAddressLine("40,Av la ville");
	bi4.setCity("Monteplier");
	bi4.setCountry("France");
	bi4.setRegion("BProvence-Alpes-Côte d'Azur");
	bi4.setPostalCode(13005);
	em.persist(bi4);

	UserAccount u1 = new UserAccount();
	u1.setProfilePicturePath(null);
	u1.setCreationDate(LocalDateTime.now());
	u1.setIsActive(true);
	u1.setAccountType(AccountType.USER);
	u1.setBankDetails(ba4);
	u1.setBillingAddress(bi4);
	u1.setEmail("adam.get@gmail.com");
	u1.setPassword("adam");
	u1.setUsername("adam");
	si.setUserAccountProvider(u1);
	em.persist(u1);

	User us1 = new User();
	us1.setDrivingPermitNumber(8365530);
	us1.setPhoneNumber(629182054);
	us1.setFirstName("adam");
	us1.setLastName("Alam");
	us1.setIdentityCardnumber(1423576987);
	us1.setUserAccount(u1);
	em.persist(us1);

	CarRentalService cr = new CarRentalService();
	cr.setKeyDropOffAddress("Poissy, gare");
	cr.setKeyPickUpAddress("Poissy,gare");
	cr.setServicetype(ServiceType.CAR_RENTAL);
	cr.setPrice(150);
	cr.setReferenceNumber("4");
	cr.setUserAccountProvider(u);
	cr.setVehicule(v);
	r.setService(cr);

	si.setService(cr);
	em.persist(cr);

	// Service - Car Rental
	User us2 = new User();
	us2.setDrivingPermitNumber(8365530);
	us2.setPhoneNumber(629182054);
	us2.setFirstName("Jin");
	us2.setLastName("Bang");
	us2.setIdentityCardnumber(148098587);
	em.persist(us2);

	Wallet w1 = new Wallet();
	w1.setInternalCurrencyAmount(251);
	em.persist(w1);

	BankDetails ba5 = new BankDetails();
	ba5.setBankName("LCL");
	ba5.setIban("z12 6735SH4 54ry");
	ba5.setSwift("095");
	em.persist(ba5);

	BillingAddress bi5 = new BillingAddress();
	bi5.setAddressLine("40,Av la ville");
	bi5.setCity("Monteplier");
	bi5.setCountry("France");
	bi5.setRegion("BProvence-Alpes-Côte d'Azur");
	bi5.setPostalCode(13005);
	em.persist(bi5);

	Insurance i1 = new Insurance();
	i1.setInsuranceAgencyName("Axa assurance");
	i1.setInsuranceContractNumber("Z23E24vXC43");
	em.persist(i1);

	UserAccount u4 = new UserAccount();
	u4.setIsActive(true);
	u4.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u4.setCreationDate(LocalDateTime.now());
	u4.setAccountType(AccountType.USER);
	u4.setBankDetails(ba3);
	u4.setBillingAddress(bi3);
	u4.setEmail("cia.get@gmail.com");
	u4.setPassword("cia");
	u4.setUsername("cia");
	u4.setWallet(w1);
	us2.setUserAccount(u4);
	em.persist(u4);

	Vehicule v1 = new Vehicule();
	v1.setBrand("Clio");
	v1.setInsurance(i);
	v1.setRegistrationNumber("AS852XZ");
	v1.setVehiculePowerType(VehiculePowerType.DIESEL);
	v1.setVehiculeType(VehiculeType.MANUAL);
	v1.setUserAccount(u4);
	u4.setVehicule(v1);
	v1.setAvailableSeats(5);
	em.persist(v1);

	ServiceInvoice si1 = new ServiceInvoice();
	em.persist(si1);

	Reservation r1 = new Reservation();
	r1.setServiceinvoice(si1);
	em.persist(r1);

	BankDetails ba6 = new BankDetails();
	ba6.setBankName("BNP");
	ba6.setIban("g76 69642r3 54ry");
	ba6.setSwift("835");
	em.persist(ba6);

	BillingAddress bi6 = new BillingAddress();
	bi6.setAddressLine("13,Av de paris");
	bi6.setCity("Marseille");
	bi6.setCountry("France");
	bi6.setRegion("BProvence-Alpes-Côte d'Azur");
	bi6.setPostalCode(13010);
	em.persist(bi6);

	UserAccount u5 = new UserAccount();
	u5.setIsActive(true);
	u5.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u5.setCreationDate(LocalDateTime.now());
	u5.setAccountType(AccountType.USER);
	u5.setBankDetails(ba6);
	u5.setBillingAddress(bi6);
	u5.setEmail("carla.get@gmail.com");
	u5.setPassword("carla");
	u5.setUsername("Carla");
	si1.setUserAccountProvider(u5);
	em.persist(u5);

	User us3 = new User();
	us3.setDrivingPermitNumber(8365530);
	us3.setPhoneNumber(629182054);
	us3.setFirstName("Mark");
	us3.setLastName("ghanim");
	us3.setIdentityCardnumber(1845676987);
	us3.setUserAccount(u5);
	em.persist(us3);

	CarRentalService cr1 = new CarRentalService();
	cr1.setKeyDropOffAddress("28 Pl. Vivaux, 13002 Marseille");
	cr1.setKeyPickUpAddress("28 Pl. Vivaux, 13002 Marseille");
	cr1.setServicetype(ServiceType.CAR_RENTAL);
	cr1.setPrice(150);
	cr1.setReferenceNumber("3");
	cr1.setUserAccountProvider(u4);
	cr1.setVehicule(v1);
	cr1.setEndDate(null);
	cr1.setStartDate(null);
	r1.setService(cr1);

//	so2.setService(cr1);
	si1.setService(cr1);
	em.persist(cr1);

	CarRentalService cr2 = new CarRentalService();
	cr2.setKeyDropOffAddress("28 Pl. Vivaux, 13002 Marseille");
	cr2.setKeyPickUpAddress("28 Pl. Vivaux, 13002 Marseille");
	cr2.setServicetype(ServiceType.CAR_RENTAL);
	cr2.setPrice(360);
	cr2.setReferenceNumber("7");
	cr2.setUserAccountProvider(u4);
	cr2.setVehicule(v1);
	cr2.setEndDate(null);
	cr2.setStartDate(null);
//	so2.setService(cr2);

	em.persist(cr2);

	// Service Car Rental

	BankDetails ba14 = new BankDetails();
	ba14.setBankName("Banque Postale");
	ba14.setIban("g76 69642r3 54ry");
	ba14.setSwift("628");
	em.persist(ba14);

	BillingAddress bi14 = new BillingAddress();
	bi14.setAddressLine("Zone des Bornes du Temps, All. du vieux berger");
	bi14.setCity("Saint-Sauveur");
	bi14.setCountry("France");
	bi14.setRegion("Picardie");
	bi14.setPostalCode(80470);
	em.persist(bi14);

	UserAccount u14 = new UserAccount();
	u14.setIsActive(true);
	u14.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u14.setCreationDate(LocalDateTime.now());
	u14.setAccountType(AccountType.USER);
	u14.setBankDetails(ba14);
	u14.setBillingAddress(bi14);
	u14.setEmail("juliette.get@gmail.com");
	u14.setPassword("juliette");
	u14.setUsername("juliette");
	em.persist(u14);

	User us13 = new User();
	us13.setDrivingPermitNumber(52789330);
	us13.setPhoneNumber(622765278);
	us13.setFirstName("Juliette");
	us13.setLastName("Agath");
	us13.setIdentityCardnumber(75326987);
	us13.setUserAccount(u14);
	em.persist(us13);

	Vehicule v12 = new Vehicule();
	v12.setBrand("Volkswagen Golf5");
	v12.setRegistrationNumber("BDU6429");
	v12.setVehiculePowerType(VehiculePowerType.DIESEL);
	v12.setVehiculeType(VehiculeType.MANUAL);
	v12.setUserAccount(u14);
	u14.setVehicule(v12);
	v12.setAvailableSeats(4);
	em.persist(v12);

	Insurance i12 = new Insurance();
	i12.setInsuranceAgencyName("MAIIF assurance");
	i12.setInsuranceContractNumber("h4338653vXC43");
	v12.setInsurance(i12);
	em.persist(i12);

	CarRentalService cr3 = new CarRentalService();
	cr3.setKeyDropOffAddress("Ferme du Toulay, 80470 Ailly-sur-Somme");
	cr3.setKeyPickUpAddress("Ferme du Toulay, 80470 Ailly-sur-Somme");
	cr3.setServicetype(ServiceType.CAR_RENTAL);
	cr3.setPrice(241);
	cr3.setReferenceNumber("3");
	cr3.setUserAccountProvider(u14);
	cr3.setVehicule(v12);
	cr3.setEndDate(null);
	cr3.setStartDate(null);

//	so1.setService(cr3);

	em.persist(cr3);

////////////////////////***************************************************************////////////////////////////    

	// Service Carpooling

	User us5 = new User();
	us5.setDrivingPermitNumber(1265530);
	us5.setPhoneNumber(183182054);
	us5.setFirstName("Norman");
	us5.setLastName("ali");
	us5.setIdentityCardnumber(142927587);
	em.persist(us5);

	Store s5 = new Store();
	s5.setMonthlySubscriptionName("Yearly");
	s5.setBatchOnePrice(20);
	em.persist(s5);

	Wallet w3 = new Wallet();
	w3.setStore(s5);
	w3.setInternalCurrencyAmount(140);
	em.persist(w3);

	BankDetails ba7 = new BankDetails();
	ba7.setBankName("BNP");
	ba7.setIban("z12 69642r3 55V3");
	ba7.setSwift("122");
	em.persist(ba7);

	BillingAddress bi7 = new BillingAddress();
	bi7.setAddressLine("40,Av la ville");
	bi7.setCity("Monteplier");
	bi7.setCountry("France");
	bi7.setRegion("BProvence-Alpes-Côte d'Azur");
	bi7.setPostalCode(13005);
	em.persist(bi7);

	Insurance i2 = new Insurance();
	i2.setInsuranceAgencyName("Axa assurance");
	i2.setInsuranceContractNumber("Z412XC43");
	em.persist(i2);

	UserAccount u6 = new UserAccount();
	u6.setIsActive(true);
	u6.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u6.setCreationDate(LocalDateTime.now());
	u6.setAccountType(AccountType.USER);
	u6.setBankDetails(ba7);
	u6.setBillingAddress(bi7);
	u6.setEmail("Norman.get@gmail.com");
	u6.setPassword("Norman");
	u6.setUsername("Norman");
	u6.setWallet(w3);
	us5.setUserAccount(u6);
	em.persist(u6);

	Vehicule v3 = new Vehicule();
	v3.setBrand("Volvo");
	v3.setInsurance(i2);
	v3.setRegistrationNumber("157v432");
	v3.setVehiculePowerType(VehiculePowerType.ELECTRIC);
	v3.setVehiculeType(VehiculeType.AUTOMATIC);
	v3.setUserAccount(u6);
	u6.setVehicule(v3);
	em.persist(v3);

	ServiceInvoice si2 = new ServiceInvoice();
	em.persist(si2);

	Reservation r2 = new Reservation();
	r2.setServiceinvoice(si2);
	em.persist(r2);

	BankDetails ba8 = new BankDetails();
	ba8.setBankName("Société Générale");
	ba8.setIban("z12 69642r3 54ry");
	ba8.setSwift("542");
	em.persist(ba8);

	BillingAddress bi8 = new BillingAddress();
	bi8.setAddressLine("12, Av prado");
	bi8.setCity("Marseille");
	bi8.setCountry("France");
	bi8.setRegion("BProvence-Alpes-Côte d'Azur");
	bi8.setPostalCode(13005);
	em.persist(bi8);

	UserAccount u3 = new UserAccount();
	u3.setIsActive(true);
	u3.setCreationDate(LocalDateTime.now());
	u3.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u3.setAccountType(AccountType.USER);
	u3.setBankDetails(ba8);
	u3.setBillingAddress(bi8);
	u3.setEmail("Constantine.get@gmail.com");
	u3.setPassword("constantine");
	u3.setUsername("Constantine");
	u3.setProfilePicturePath(null);
	si.setUserAccountProvider(u3);

	em.persist(u3);

	User us4 = new User();
	us4.setDrivingPermitNumber(8365530);
	us4.setPhoneNumber(629182054);
	us4.setFirstName("Constantine");
	us4.setLastName("Book");
	us4.setIdentityCardnumber(1423576987);
	us4.setUserAccount(u3);
	em.persist(us4);

	Trajectory t = new Trajectory();
	t.setDeliveryAddress(null);
	t.setStopNumber(2);
	t.setTrajectoryType(TrajectoryType.PUNCTUAL);
	t.setPickUpAddress("Chem. de Virebelle, 13600 La Ciotat");
	t.setDurationHours(1);
	t.setDeliveryAddress("1 Av. Jean Monnet, 13127 Vitrolles");
	em.persist(t);

	CarPoolingService cps = new CarPoolingService();
	cps.setPetAllowed(false);
	cps.setMusicAllowed(true);
	cps.setPrice(21);
	cps.setAvailableSeats(3);
	cps.setStartDate(null);
	cps.setEndDate(null);
	cps.setCarPoolingType(CarPoolingType.HOME_TO_WORK);
	cps.setSmokingAllowed(false);
	cps.setServicetype(ServiceType.CAR_POOLING);
	cps.setUserAccountProvider(u6);
	cps.setTrajectory(t);
	si2.setService(cps);
	r2.setService(cps);
//	so1.setService(cps);
	cps.setReferenceNumber("1");
	em.persist(cps);

	CarPoolingService cps0 = new CarPoolingService();
	cps0.setPetAllowed(false);
	cps0.setMusicAllowed(true);
	cps0.setPrice(19);
	cps0.setAvailableSeats(3);
	cps0.setStartDate(null);
	cps0.setEndDate(null);
//	so1.setService(cps0);
	cps0.setCarPoolingType(CarPoolingType.HOME_TO_WORK);
	cps0.setSmokingAllowed(false);
	cps0.setServicetype(ServiceType.CAR_POOLING);
	cps0.setUserAccountProvider(u6);
	cps0.setTrajectory(t);

	cps0.setReferenceNumber("13");
	em.persist(cps0);

	// Service Carpooling
	User us7 = new User();
	us7.setDrivingPermitNumber(912430);
	us7.setPhoneNumber(631202054);
	us7.setFirstName("Alia");
	us7.setLastName("Rose");
	us7.setIdentityCardnumber(142927587);
	em.persist(us7);

	Store s6 = new Store();
	s6.setMonthlySubscriptionName("Yearly");
	s6.setBatchOnePrice(20);
	em.persist(s6);

	Wallet w4 = new Wallet();
	w4.setStore(s6);
	w4.setInternalCurrencyAmount(140);
	em.persist(w4);

	BankDetails ba9 = new BankDetails();
	ba9.setBankName("BNP");
	ba9.setIban("t57 987v42r3 55V3");
	ba9.setSwift("124");
	em.persist(ba9);

	BillingAddress bi9 = new BillingAddress();
	bi9.setAddressLine("61 Av. Frederic et Irene Joliot Curie");
	bi9.setCity("Nanterre");
	bi9.setCountry("France");
	bi9.setRegion("Ile De France");
	bi9.setPostalCode(9200);
	em.persist(bi9);

	Insurance i3 = new Insurance();
	i3.setInsuranceAgencyName("POSITIVE ASSURANCE-Assurance Auto");
	i3.setInsuranceContractNumber("r3469b4");
	em.persist(i3);

	UserAccount u8 = new UserAccount();
	u8.setIsActive(true);
	u8.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u8.setCreationDate(LocalDateTime.now());
	u8.setAccountType(AccountType.USER);
	u8.setBankDetails(ba9);
	u8.setBillingAddress(bi9);
	u8.setEmail("Alia.get@gmail.com");
	u8.setPassword("Alia");
	u8.setUsername("Alia");
	u8.setWallet(w4);
	us7.setUserAccount(u8);
	em.persist(u8);

	Vehicule v4 = new Vehicule();
	v4.setBrand("Merceds");
	v4.setInsurance(i3);
	v4.setRegistrationNumber("46g423");
	v4.setVehiculePowerType(VehiculePowerType.HYBRID);
	v4.setVehiculeType(VehiculeType.AUTOMATIC);
	v4.setUserAccount(u8);
	u8.setVehicule(v4);
	em.persist(v4);

	ServiceInvoice si3 = new ServiceInvoice();
	em.persist(si3);

	Reservation r3 = new Reservation();
	r3.setServiceinvoice(si3);
	em.persist(r3);

	BankDetails ba10 = new BankDetails();
	ba10.setBankName("LCL");
	ba10.setIban("t62 op712n7 d40v");
	ba10.setSwift("901");
	em.persist(ba10);

	BillingAddress bi10 = new BillingAddress();
	bi10.setAddressLine("ZI les Estroublans, 17 Avenue de Londres");
	bi10.setCity("Vitrolles");
	bi10.setCountry("France");
	bi10.setRegion("BProvence-Alpes-Côte d'Azur");
	bi10.setPostalCode(13127);
	em.persist(bi10);

	UserAccount u9 = new UserAccount();
	u9.setIsActive(true);
	u9.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u9.setCreationDate(LocalDateTime.now());
	u9.setAccountType(AccountType.USER);
	u9.setBankDetails(ba10);
	u9.setBillingAddress(bi10);
	u9.setEmail("Lina.get@gmail.com");
	u9.setPassword("lina");
	u9.setUsername("Lina");
	u9.setProfilePicturePath(null);
	si3.setUserAccountProvider(u9);

	em.persist(u9);

	User us8 = new User();
	us8.setDrivingPermitNumber(8365530);
	us8.setPhoneNumber(629182054);
	us8.setFirstName("Lina");
	us8.setLastName("Jade");
	us8.setIdentityCardnumber(781236987);
	us8.setUserAccount(u9);
	em.persist(us8);

	Trajectory t1 = new Trajectory();
	t1.setDeliveryAddress(null);
	t1.setStopNumber(0);
	t1.setTrajectoryType(TrajectoryType.REGULAR);
	t1.setPickUpAddress("chemin Saint Pierre, Av. du 8 Mai 1945, 13700 Marignane");
	t1.setDurationHours(2);
	t1.setDeliveryAddress("Quai Jean Jaurès, 84800 L'Isle-sur-la-Sorgue");
	em.persist(t1);

	CarPoolingService cps1 = new CarPoolingService();
	cps1.setPetAllowed(false);
	cps1.setMusicAllowed(false);
	cps1.setPrice(12);
	cps1.setAvailableSeats(2);
	cps1.setStartDate(null);
	cps1.setEndDate(null);
	cps1.setCarPoolingType(CarPoolingType.TRAVEL);
	cps1.setSmokingAllowed(false);
	cps1.setServicetype(ServiceType.CAR_POOLING);
	cps1.setUserAccountProvider(u8);
	cps1.setTrajectory(t1);
//	so1.setService(cps1);
	si3.setService(cps1);
	r3.setService(cps1);
	cps1.setReferenceNumber("2");
	em.persist(cps1);

	// Service Carpooling
	User us9 = new User();
	us9.setDrivingPermitNumber(76125);
	us9.setPhoneNumber(631202054);
	us9.setFirstName("Louise");
	us9.setLastName("Candia");
	us9.setIdentityCardnumber(542976);
	em.persist(us9);

	Wallet w5 = new Wallet();
	w5.setInternalCurrencyAmount(160);
	em.persist(w5);

	BankDetails ba11 = new BankDetails();
	ba11.setBankName("LCL");
	ba11.setIban("u757 4z7v42r3 55V3");
	ba11.setSwift("614");
	em.persist(ba11);

	BillingAddress bi11 = new BillingAddress();
	bi11.setAddressLine("19 Av. André Mussat");
	bi11.setCity("Rennes");
	bi11.setCountry("France");
	bi11.setRegion("Bretagne");
	bi11.setPostalCode(3500);
	em.persist(bi11);

	Insurance i4 = new Insurance();
	i4.setInsuranceAgencyName("MACIF Assurances");
	i4.setInsuranceContractNumber("v568h4");
	em.persist(i4);

	UserAccount u11 = new UserAccount();
	u11.setIsActive(true);
	u11.setCreationDate(LocalDateTime.now());
	u11.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u11.setAccountType(AccountType.USER);
	u11.setBankDetails(ba11);
	u11.setBillingAddress(bi11);
	u11.setEmail("Louise.get@gmail.com");
	u11.setPassword("Louise");
	u11.setUsername("Louise");
	u11.setWallet(w4);
	us9.setUserAccount(u11);
	em.persist(u11);

	Vehicule v5 = new Vehicule();
	v5.setBrand("Volvo");
	v5.setInsurance(i4);
	v5.setRegistrationNumber("b56h31");
	v5.setVehiculePowerType(VehiculePowerType.HYBRID);
	v5.setVehiculeType(VehiculeType.AUTOMATIC);
	v5.setUserAccount(u11);
	u11.setVehicule(v5);
	em.persist(v5);

	Trajectory t2 = new Trajectory();
	t2.setStopNumber(0);
	t2.setTrajectoryType(TrajectoryType.REGULAR);
	t2.setPickUpAddress("Av. des Promenades, 22000 Saint-Brieuc");
	t2.setDurationHours(2);
	t2.setDeliveryAddress("Rte de Saint-Renan, 29820 Guilers");
	em.persist(t2);

	CarPoolingService cps3 = new CarPoolingService();
	cps3.setPetAllowed(true);
	cps3.setMusicAllowed(true);
	cps3.setPrice(12);
	cps3.setAvailableSeats(3);
	cps3.setStartDate(null);
	cps3.setEndDate(null);
	cps3.setCarPoolingType(CarPoolingType.EVENTS);
	cps3.setSmokingAllowed(true);
	cps3.setServicetype(ServiceType.CAR_POOLING);
	cps3.setUserAccountProvider(u11);
	cps3.setTrajectory(t2);
//	so1.setService(cps3);
	cps3.setReferenceNumber("8");

	em.persist(cps3);

	// Service Carpooling
	User us11 = new User();
	us11.setDrivingPermitNumber(51452703);
	us11.setPhoneNumber(69368103);
	us11.setFirstName("Chloé");
	us11.setLastName("Romy");
	us11.setIdentityCardnumber(1563772);
	em.persist(us11);

	Wallet w6 = new Wallet();

	w4.setInternalCurrencyAmount(373);
	em.persist(w6);

	BankDetails ba22 = new BankDetails();
	ba22.setBankName("BNP");
	ba22.setIban("123 4z7v42r3 B816");
	ba22.setSwift("198");
	em.persist(ba22);

	BillingAddress bi22 = new BillingAddress();
	bi22.setAddressLine("19 Av. André Mussat");
	bi22.setCity("Bordeaux");
	bi22.setCountry("France");
	bi22.setRegion("Bretagne");
	bi22.setPostalCode(3500);
	em.persist(bi22);

	Insurance i5 = new Insurance();
	i5.setInsuranceAgencyName("MACIF Assurances");
	i5.setInsuranceContractNumber("r6529h3");
	em.persist(i5);

	UserAccount u12 = new UserAccount();
	u12.setAccountType(AccountType.USER);
	u12.setBankDetails(ba22);
	u12.setBillingAddress(bi22);
	u12.setEmail("chloe.get@gmail.com");
	u12.setPassword("chloe");
	u12.setUsername("chloe");
	u12.setWallet(w4);
	us11.setUserAccount(u12);
	u12.setProfilePicturePath("webapp/media/img/EA-Will.png");
	u12.setIsActive(true);
	u12.setCreationDate(LocalDateTime.now());
	em.persist(u12);

	Vehicule v6 = new Vehicule();
	v6.setBrand("peugeot 208");
	v6.setInsurance(i5);
	v6.setRegistrationNumber("4327h");
	v6.setVehiculePowerType(VehiculePowerType.PETROL);
	v6.setVehiculeType(VehiculeType.MANUAL);
	v6.setUserAccount(u12);
	u12.setVehicule(v6);
	em.persist(v5);

	Trajectory t3 = new Trajectory();

	t3.setStopNumber(3);
	t3.setTrajectoryType(TrajectoryType.REGULAR);
	t3.setPickUpAddress("505 Rue Irène Joliot Curie, 76620 Le Havre");
	t3.setDurationHours(3);
	t3.setDeliveryAddress("Av. de la Défense Passive, 80080 Amiens");
	em.persist(t3);

	CarPoolingService cps4 = new CarPoolingService();

	cps4.setPetAllowed(true);
	cps4.setMusicAllowed(true);
	cps4.setPrice(20);
	cps4.setStartDate(null);
	cps4.setEndDate(null);
	cps4.setAvailableSeats(1);
	cps4.setCarPoolingType(CarPoolingType.TRAVEL);
	cps4.setSmokingAllowed(false);
	cps4.setServicetype(ServiceType.CAR_POOLING);
	cps4.setUserAccountProvider(u12);
	cps4.setTrajectory(t3);
//	so1.setService(cps4);
	cps4.setReferenceNumber("10");

	em.persist(cps4);

	CarPoolingService cps5 = new CarPoolingService();
	cps5.setPetAllowed(true);
	cps5.setMusicAllowed(true);
	cps5.setStartDate(null);
	cps5.setEndDate(null);
	cps5.setPrice(30);
	cps5.setAvailableSeats(1);
	cps5.setCarPoolingType(CarPoolingType.TRAVEL);
	cps5.setSmokingAllowed(false);
	cps5.setServicetype(ServiceType.CAR_POOLING);
	cps5.setUserAccountProvider(u12);
	cps5.setTrajectory(t3);
//	so1.setService(cps5);
	cps5.setReferenceNumber("9");

	em.persist(cps5);

////////////////////////***************************************************************//////////////////////////// 

	// Service Parcel Service

	User u20 = new User();
	u20.setDrivingPermitNumber(1267853);
	u20.setFirstName("Louis");
	u20.setLastName("Arno");
	u20.setIdentityCardnumber(712893403);
	u20.setPhoneNumber(683285319);
	em.persist(u20);
	UserAccount  ua20 = new UserAccount();
	ua20.setEmail("louis.get@gmail.com");
	ua20.setProfilePicturePath("webapp/media/img/EA-Will.png");
	ua20.setPassword("louis");
	ua20.setCreationDate(LocalDateTime.now());
	ua20.setAccountType(AccountType.USER);
	ua20.setUsername("louis");
	u20.setUserAccount(ua20);
	em.persist(ua20);

	Vehicule v20 = new Vehicule();
	v20.setBrand("Acura");
	v20.setUserAccount(ua20);
	v20.setVehiculeType(VehiculeType.MANUAL);
	v20.setRegistrationNumber("v4578954h33");
	v20.setVehiculePowerType(VehiculePowerType.PETROL);
	v20.setTechnicalTestExpiration(null);
	ua20.setVehicule(v20);
	v20.setAvailableSeats(4);
	em.persist(v20);

	Insurance i20 = new Insurance();
	i20.setInsuranceAgencyName("Axa Assurance");
	i20.setInsuranceContractExpiration(null);
	i20.setInsuranceContractNumber("4247h32589");
	v20.setInsurance(i20);
	em.persist(i20);

	BillingAddress bi20 = new BillingAddress();
	bi20.setAddressLine("0359 Rte de Lyon, 01360 Balan");
	bi20.setCity("Balan");
	bi20.setCountry("France");
	bi20.setPostalCode(01360);
	bi20.setRegion("Grand Est");
	ua20.setBillingAddress(bi20);
	em.persist(bi20);

	BankDetails ba20 = new BankDetails();
	ba20.setBankName("LCL");
	ba20.setIban("r57743996543");
	ua20.setBankDetails(ba20);
	ba20.setSwift("743");
	em.persist(ba20);

	ParcelService pc = new ParcelService();
	pc.setAtypicalVolume(true);
	pc.setEndDate(null);
	pc.setExpirationDate(null);
	pc.setFragile(true);
	pc.setPrice(20);
	pc.setReferenceNumber("15");
	pc.setPublicationDate(LocalDateTime.now());
	pc.setUserAccountProvider(ua20);
	pc.setServicetype(ServiceType.PARCEL);
//	so1.setService(pc);
	pc.setWeightKilogrammes(20);
	pc.setVehicule(v20);
	pc.setStartDate(null);
	em.persist(pc);

	Trajectory t20 = new Trajectory();
	t20.setDeliveryAddress("01250 Hautecourt-Romanèche");
	t20.setDurationHours(3);
	t20.setPickUpAddress("La Drague, 05130 Jarjayes");
	t20.setTrajectoryType(TrajectoryType.PUNCTUAL);
	pc.setTrajectory(t20);
	em.persist(t20);

	ServiceInvoice si20 = new ServiceInvoice();
	si20.setService(pc);
	si20.setUserAccountProvider(u12);
	em.persist(si20);

	Reservation r20 = new Reservation();
	r20.setService(pc);
	r20.setServiceinvoice(si20);
	em.persist(r20);

	ServiceInvoice si4 = new ServiceInvoice();
	si4.setUserAccountProvider(u11);
	si4.setService(cr2);
	em.persist(si4);

	Reservation r4 = new Reservation();
	r4.setServiceinvoice(si4);
	r4.setService(cr2);
	em.persist(r4);

	ParcelService pc1 = new ParcelService();
	pc1.setAtypicalVolume(true);
	pc1.setEndDate(null);
	pc1.setExpirationDate(null);
	pc1.setFragile(true);
	pc1.setPrice(40);
	pc1.setReferenceNumber("18");
	pc1.setPublicationDate(LocalDateTime.now());
	pc1.setUserAccountProvider(ua20);
	pc1.setServicetype(ServiceType.PARCEL);
//	so1.setService(pc1);
	pc1.setWeightKilogrammes(20);
	pc1.setVehicule(v20);
	pc1.setStartDate(null);
	pc1.setTrajectory(t20);
	em.persist(pc1);

	ParcelService pc2 = new ParcelService();
	pc2.setAtypicalVolume(true);
	pc2.setEndDate(null);
	pc2.setExpirationDate(null);
	pc2.setFragile(true);
	pc2.setPrice(27);
	pc2.setReferenceNumber("16");
	pc2.setPublicationDate(LocalDateTime.now());
	pc2.setUserAccountProvider(u8);
	pc2.setServicetype(ServiceType.PARCEL);
//	so1.setService(pc2);
	pc2.setWeightKilogrammes(20);
	pc2.setVehicule(v4);
	pc2.setStartDate(null);
	pc2.setTrajectory(t1);
	em.persist(pc2);

	Trajectory t6 = new Trajectory();
	t6.setDeliveryAddress("14 Rue des Agglomérés, 92000 Nanterre");
	t6.setDurationHours(2);
	t6.setTrajectoryType(TrajectoryType.PUNCTUAL);
	t6.setPickUpAddress("ZAC du, Le Clos Saint-Martin, 77000 Vaux-le-Pénil");
	em.persist(t6);

	User u22 = new User();
	u22.setBirthDate(null);
	u22.setDrivingPermitNumber(654378789);
	u22.setFirstName("Mael");
	u22.setPhoneNumber(652954184);
	u22.setLastName("Qadim");
	em.persist(u22);

	BankDetails ba32 = new BankDetails();
	ba32.setBankName("credit agricole");
	ba32.setIban("r3578434vh5");
	ba32.setSwift("134");
	em.persist(ba32);

	Vehicule v22 = new Vehicule();
	v22.setBrand("Alfa Rome");
	v22.setRegistrationNumber("v468904");
	v22.setTechnicalTestExpiration(null);
	v22.setVehiculeType(VehiculeType.MANUAL);
	v22.setVehiculePowerType(VehiculePowerType.PETROL);
	v22.setAvailableSeats(3);
	em.persist(v22);

	UserAccount ua2 = new UserAccount();
	v22.setUserAccount(ua2);
	ua2.setAccountType(AccountType.USER);
	ua2.setIsActive(true);
	ua2.setBankDetails(ba32);
	ua2.setEmail("mael.get@gmail.com");
	ua2.setCreationDate(LocalDateTime.now());
	ua2.setProfilePicturePath("webapp/media/img/EA-Will.png");
	ua2.setUsername("mael");
	ua2.setVehicule(v22);
	ua2.setPassword("mael");
	u22.setUserAccount(ua2);
	em.persist(ua2);

	ParcelService pc3 = new ParcelService();
	pc3.setServicetype(ServiceType.PARCEL);
	pc3.setAtypicalVolume(false);
	pc3.setEndDate(null);
	pc3.setFragile(false);
	pc3.setPublicationDate(LocalDateTime.now());
	pc3.setReferenceNumber("21");
	pc3.setPrice(46);
	pc3.setTrajectory(t6);
	pc3.setUserAccountProvider(ua2);
	pc3.setWeightKilogrammes(50);
	pc3.setVehicule(v22);
	em.persist(pc3);

////////////////////////***************************************************************//////////////////////////// 
	// Service Personal Assistance
	PersonalAssistanceService pe = new PersonalAssistanceService();
	pe.setEndDate(null);
	pe.setExpirationDate(null);
	pe.setStartDate(null);
	pe.setServicetype(ServiceType.PERSONAL_ASSISTANCE);
	pe.setReferenceNumber("1");
	pe.setPrice(15);
	pe.setPersonalAssistanceType(PersonalAssistanceType.GROCERY);
	pe.setUserAccountProvider(ua2);
//	so1.setService(pe);
	em.persist(pe);

	Trajectory t26 = new Trajectory();
	t26.setTrajectoryType(TrajectoryType.PUNCTUAL);
	t26.setPickUpAddress("4 Rue Notre Dame du Port, 63000 Clermont-Ferrand");
	t26.setDeliveryAddress("La Ferme de Valérie, 23170 Lussat");
	t26.setDurationHours(2);
	pe.setTrajectory(t26);
	em.persist(t26);

	User u25 = new User();
	u25.setBirthDate(null);
	u25.setFirstName("Yamina");
	u25.setPhoneNumber(686302736);
	u25.setDrivingPermitNumber(782340871);
	u25.setIdentityCardnumber(836462989);
	u25.setLastName("ando");
	em.persist(u25);

	UserAccount ua10 = new UserAccount();
	ua10.setEmail("yamina.get@gmail.com");
	ua10.setIsActive(true);
	u25.setUserAccount(ua10);
	ua10.setPassword("yamina");
	ua10.setUsername("Yamina");
	ua10.setProfilePicturePath("webapp/media/img/EA-Will.png");
	ua10.setCreationDate(LocalDateTime.now());
	em.persist(ua10);

	BankDetails ba25 = new BankDetails();
	ba25.setBankName("LCL");
	ba25.setIban("hr67876554790");
	ba25.setSwift("172");
	ua10.setBankDetails(ba25);
	em.persist(ba25);

	Vehicule v25 = new Vehicule();
	v25.setUserAccount(ua10);
	ua10.setVehicule(v25);
	v25.setBrand("peugeot 208");
	v25.setVehiculePowerType(VehiculePowerType.PETROL);
	v25.setVehiculeType(VehiculeType.MANUAL);
	v25.setRegistrationNumber("f83264200283G3");
	v25.setAvailableSeats(3);
	em.persist(v25);

	PersonalAssistanceService pe1 = new PersonalAssistanceService();
	pe1.setStartDate(null);
	pe1.setPublicationDate(LocalDateTime.now());
	pe1.setServicetype(ServiceType.PERSONAL_ASSISTANCE);
	pe1.setPrice(15);
	pe1.setPersonalAssistanceType(PersonalAssistanceType.MEDICAL);
	pe1.setUrgent(false);
	pe1.setUserAccountProvider(ua10);
	pe1.setExpirationDate(null);
	pe1.setReferenceNumber("2");
//	so1.setService(pe1);
	em.persist(pe1);

	Trajectory t25 = new Trajectory();
	t25.setPickUpAddress("4 Gd Rue des Tavernes, 95420 Cléry-en-Vexin");
	t25.setTrajectoryType(TrajectoryType.PUNCTUAL);
	t25.setDeliveryAddress("57 Rue des Champs, 76190 Yvetot");
	t25.setDurationHours(3);
	t25.setTrajectoryType(TrajectoryType.REGULAR);
	pe1.setTrajectory(t25);

	em.persist(t25);

	ServiceInvoice s25 = new ServiceInvoice();
	s25.setService(pe1);
	s25.setUserAccountProvider(ua2);
	em.persist(s25);

	Reservation r25 = new Reservation();
	r25.setServiceinvoice(s25);
	r25.setService(pe1);
	em.persist(r25);

	PersonalAssistanceService pe2 = new PersonalAssistanceService();
	pe2.setStartDate(null);
	pe2.setPublicationDate(LocalDateTime.now());
	pe2.setServicetype(ServiceType.PERSONAL_ASSISTANCE);
	pe2.setPrice(20);
	pe2.setPersonalAssistanceType(PersonalAssistanceType.MEDICAL);
	pe2.setUrgent(true);
	pe2.setUserAccountProvider(ua10);
	pe2.setExpirationDate(null);
	pe2.setReferenceNumber("2");
//	so1.setService(pe2);
	em.persist(pe2);

	Trajectory t27 = new Trajectory();
	t27.setDeliveryAddress("15 Chem. de l'Abbaye d'Ardennes, 14000 Caen");
	t27.setPickUpAddress("Rte de la Brique, 50700 Valognes");
	pe2.setTrajectory(t27);
	t27.setDurationHours(3);
	t27.setTrajectoryType(TrajectoryType.PUNCTUAL);
	em.persist(t27);

    }

}