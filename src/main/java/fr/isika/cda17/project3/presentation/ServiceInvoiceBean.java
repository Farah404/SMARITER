package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class ServiceInvoiceBean {
	@Inject
	private ServiceInvoiceDao serviceInvoiceDao;

	@Inject
	private UserDao userDao;
	
	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;
	
	@Inject
	private CarRentalServiceDao carRentalServiceDao;
	
	@Inject
	private ParcelServiceDao parcelServiceDao;
	
	@Inject
	private PersonalAssistanceServiceDao personalAssistanceServiceDao;
	
	private ServiceInvoice serviceInvoice;
	
	private User userPurchaser;
	
	private User userProvider;
	
	private ServiceType serviceType;
	
	private String referenceNumber;
	
	private double servicePrice;
	
	private String serviceTypeFrLabel="";
	
//	private LocalDate dueDate;
//	
//	private LocalDate stampDate;

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("serviceInvoiceId")) {
			String serviceInvoiceIdParamValue = map.get("serviceInvoiceId");
			if (serviceInvoiceIdParamValue != null && !serviceInvoiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(serviceInvoiceIdParamValue);
				if (id != null) {

					serviceInvoice = serviceInvoiceDao.findById(id);
					userPurchaser = userDao.findByUserAccountId(serviceInvoice.getUserAccountPurchaser().getId());
					userProvider = userDao.findByUserAccountId(serviceInvoice.getUserAccountProvider().getId());
					if (carPoolingServiceDao.findServiceType(serviceInvoice.getService().getId()) != null) {
						serviceType=carPoolingServiceDao.findServiceType(serviceInvoice.getService().getId());
						serviceTypeFrLabel="Covoiturage";
					}
						else {
							if(carRentalServiceDao.findServiceType(serviceInvoice.getService().getId()) != null) {
								serviceType=carRentalServiceDao.findServiceType(serviceInvoice.getService().getId());
								serviceTypeFrLabel="Location";
						}
							else {
								if(parcelServiceDao.findServiceType(serviceInvoice.getService().getId()) != null) {
									serviceType=parcelServiceDao.findServiceType(serviceInvoice.getService().getId());
									serviceTypeFrLabel="Transport de colis";
								}
								else {
									serviceType=personalAssistanceServiceDao.findServiceType(serviceInvoice.getService().getId());
									serviceTypeFrLabel="Aide à la personne";
								}
							}
					}
					
					if (!carPoolingServiceDao.findReferenceNumber(serviceInvoice.getService().getId()).equals("")) {
						referenceNumber=carPoolingServiceDao.findReferenceNumber(serviceInvoice.getService().getId());
					}
						else {
							if(!carRentalServiceDao.findReferenceNumber(serviceInvoice.getService().getId()).equals("")) {
								referenceNumber=carRentalServiceDao.findReferenceNumber(serviceInvoice.getService().getId());
						}
							else {
								if(!parcelServiceDao.findReferenceNumber(serviceInvoice.getService().getId()).equals("")) {
									referenceNumber=parcelServiceDao.findReferenceNumber(serviceInvoice.getService().getId());
								}
								else {
									referenceNumber=personalAssistanceServiceDao.findReferenceNumber(serviceInvoice.getService().getId());
								}
							}
					}
					
					if (carPoolingServiceDao.findServicePrice(serviceInvoice.getService().getId()) != 0) {
						servicePrice=carPoolingServiceDao.findServicePrice(serviceInvoice.getService().getId());
					}
						else {
							if(carRentalServiceDao.findServicePrice(serviceInvoice.getService().getId()) != 0) {
								servicePrice=carRentalServiceDao.findServicePrice(serviceInvoice.getService().getId());
						}
							else {
								if(parcelServiceDao.findServicePrice(serviceInvoice.getService().getId()) != 0) {
									servicePrice=parcelServiceDao.findServicePrice(serviceInvoice.getService().getId());
								}
								else {
									servicePrice=personalAssistanceServiceDao.findServicePrice(serviceInvoice.getService().getId());
								}
							}
					}
				}
			}
		}
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public double getServicePrice() {
		return servicePrice;
	}

	public User getUserPurchaser() {
		return userPurchaser;
	}

	public User getUserProvider() {
		return userProvider;
	}

	public ServiceInvoice getServiceInvoice() {
		return serviceInvoice;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}
	public String getServiceTypeFrLabel() {
		return serviceTypeFrLabel;
	}

}
