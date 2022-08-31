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

@Singleton
@Startup
public class DataSet {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void initData() {
	

	
	BankDetails b = new BankDetails();
	b.setBankName("Socièté Générale");

	UserAccount uz = new UserAccount();
	uz.setBankDetails(b);
	uz.setUsername("BIASOO");

	Vehicule v = new Vehicule();
	v.setBrand("BMW");
	v.setRegistrationNumber("A1234B");
	v.setVehiculeType(VehiculeType.MANUAL);
	v.setVehiculePowerType(VehiculePowerType.DIESEL);
	v.setUserAccount(uz);

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
	c.setPrice(10);

	
	em.persist(c);
	
	
	BankDetails baa = new BankDetails();
	baa.setBankName("Caisse d'épargne");
	
	UserAccount ua = new UserAccount();
	ua.setBankDetails(baa);
	ua.setUsername("JULOOO");

	Vehicule va = new Vehicule();
	va.setBrand("BMW");
	va.setRegistrationNumber("A4567B");
	va.setVehiculeType(VehiculeType.MANUAL);
	va.setVehiculePowerType(VehiculePowerType.DIESEL);
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
	ca.setPrice(30);
	ca.setStartDate("VehiculePowerType");
	
	
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
	cr.setEndDate("03/09/2022");
	cr.setStartDate("01/09/2022");
	cr.setServicetype(ServiceType.CAR_RENTAL);
	cr.setVehicule(vi);
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
	cra.setEndDate("09/09/2022");
	cra.setStartDate("05/09/2022");
	cra.setServicetype(ServiceType.CAR_RENTAL);
	cra.setVehicule(via);
	em.persist(cra);

	

	
    }
    
    


}