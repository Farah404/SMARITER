package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;

import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.model.serviceManagement.Service;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ReservationDao;

@ManagedBean
@SessionScoped
public class CarPoolingReservationBean implements Serializable {
	
	private static final String LIST_CARPOOLINGSERVICE_XHTML = "listCarPoolingService.xhtml";

	/**
	 * 
	 */
	private static final long serialVersionUID = -1025290862154591864L;

	@Inject
	private UserAccountsDao userAccontDao;

	

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;

	private Reservation reservation = new Reservation();
	private ServiceInvoice serviceInvoice = new ServiceInvoice();

	private CarPoolingService carPooling;
	private UserAccount user = new UserAccount();
	
	
	public void init() throws IOException {
		System.out.println("INITIALISATION RESERVATIONBEAN");
		
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("carPoolingServiceId")) {
			String carPoolingServiceIdParamValue = map.get("carPoolingServiceId");
			System.err.println("carPoolingServiceIdParamValue : " + carPoolingServiceIdParamValue);
			if (carPoolingServiceIdParamValue != null && !carPoolingServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(carPoolingServiceIdParamValue);
				if (id != null) {
					carPooling = carPoolingServiceDao.findById(id);
					if (carPooling == null) {
						redirectError();
					}
					System.out.println(carPooling);
					
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
		ec.redirect(LIST_CARPOOLINGSERVICE_XHTML);
	}

	public void reservation() {
		
		//carPooling = carPoolingServiceDao.findById(id);
		
		System.out.println("DEBUT CREATION");

		reservation.setService(carPooling);
		serviceInvoice.setService(carPooling);
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String email = (String) session.getAttribute("email");
		
		
		if(email != null && !email.isBlank()) {
			
			Optional<UserAccount> optional = userAccontDao.findByEmail(email);
			if(optional.isPresent()) {
				serviceInvoice.setUserAccount(optional.get());
				
				
				if (carPooling.getAvailableSeats() > 0) {
					// reservationDao.create(reservation);
		
					reservation.setServiceinvoice(serviceInvoice);
					carPooling.getReservations().add(reservation);
					carPooling.setAvailableSeats(carPooling.getAvailableSeats() - 1);
		
					carPoolingServiceDao.update(carPooling);
					System.out.println("reservation : "+reservation.getId());
		
				} else {
					System.out.println("reservation failed, no seats available");
				}
			} else {
				System.out.println("reservation failed, no user with email : " + email);
			}
		
		} else {
			System.out.println("reservation failed, email unknown : " + email);
		}
		System.out.println("FIN CREATION");
	}

	public CarPoolingService getCarPooling() {
		return carPooling;
	}

	public void setCarPooling(CarPoolingService carPooling) {
		this.carPooling = carPooling;
	}

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

}
