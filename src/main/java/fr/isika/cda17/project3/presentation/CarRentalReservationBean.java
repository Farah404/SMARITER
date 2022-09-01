package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ReservationDao;

@ManagedBean
@SessionScoped
public class CarRentalReservationBean implements Serializable{

	/**
	 * 
	 */
	
	private static final String LIST_CARRENTALSERVICE_XHTML = "listCarRentalService.xhtml";
	private static final long serialVersionUID = -1025290862154591864L;

	@Inject
	private CarRentalServiceDao carRentalServiceDao;
	
	@Inject
	private UserAccountsDao userAccontDao;
  
	@Inject
	private ReservationDao reservationDao;
     
	private Reservation reservation = new Reservation();
	private ServiceInvoice serviceInvoice = new ServiceInvoice();
	private UserAccount user = new UserAccount();
	private CarRentalService carRental;
/*
 * methodes
 */
	public void init() throws IOException {
		System.out.println("INITIALISATION RESERVATIONBEAN");
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("carRentalServiceId")) {
			String carRentalServiceIdParamValue = map.get("carRentalServiceId");
			System.err.println(carRentalServiceIdParamValue);
			if (carRentalServiceIdParamValue != null && !carRentalServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(carRentalServiceIdParamValue);
				if(id != null) {
					carRental = carRentalServiceDao.findById(id);
					if (carRental == null) {
						redirectError();
					}
				} else {
					redirectError();
				}
			} else {
				redirectError();
			}
		}
	}
	
	public void redirectError() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(LIST_CARRENTALSERVICE_XHTML);
	}
	
public void reservation() {
		

		System.out.println("DEBUT CREATION");

		reservation.setService(carRental);
		serviceInvoice.setService(carRental);
		
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		String email = (String) session.getAttribute("email");
//		
//		System.out.println(carRental);
//		if(email != null && !email.isBlank()) {
//			
//			Optional<UserAccount> optional = userAccontDao.findByEmail(email);
//			if(optional.isPresent()) {
//				serviceInvoice.setUserAccount(optional.get());
//			
				reservation.setServiceinvoice(serviceInvoice);
				carRental.getReservations().add(reservation);
				reservationDao.create(reservation);
				carRentalServiceDao.update(carRental);
					
//				System.out.println("reservation : "+reservation.getId());
//	
//			} else {
//				System.out.println("reservation failed, no user with email : " + email);
//			}
//		
//		} else {
//			System.out.println("reservation failed, email unknown : " + email);
//		}
		System.out.println("FIN CREATION");
	}
	
	
	
	
	
  /**
   * 
    getters et setters
   */




	public Reservation getReservation() {
		return reservation;
	}



	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}



	public ServiceInvoice getServiceInvoice() {
		return serviceInvoice;
	}



	public void setServiceInvoice(ServiceInvoice serviceInvoice) {
		this.serviceInvoice = serviceInvoice;
	}



	public UserAccount getUser() {
		return user;
	}



	public void setUser(UserAccount user) {
		this.user = user;
	}
	public CarRentalService getCarRental() {
		return carRental;
	}
	public void setCarRental(CarRentalService carRental) {
		this.carRental = carRental;
	}
}
