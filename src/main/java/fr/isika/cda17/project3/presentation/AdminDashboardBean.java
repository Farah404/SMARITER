package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.repository.personManagement.accounts.AdministratorDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.CustomerDao;

@ManagedBean
@ViewScoped
public class AdminDashboardBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
    private AdministratorDao administratorDao;
	
	private Administrator administrator;

	
	public void init(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		System.out.println(id);
		if(id != null) {
		    administrator = administratorDao.findByAdminAccountId(id);
//		customer => entityAccount == id
		if (administrator == null) {
			System.out.println("this is bullshit");
			}
		}
		else {
			System.out.println("id null");
		}
	}


	public AdministratorDao getAdministratorDao() {
	    return administratorDao;
	}


	public void setAdministratorDao(AdministratorDao administratorDao) {
	    this.administratorDao = administratorDao;
	}


	public Administrator getAdministrator() {
	    return administrator;
	}


	public void setAdministrator(Administrator administrator) {
	    this.administrator = administrator;
	}

}
