package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;

@ManagedBean
@ViewScoped
public class EditEntityAccountBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityAccountDao entityAccountDao;

	private EntityAccount entityAccount;

	public void init() throws IOException {
		

			Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if (map.containsKey("accountId")) {
				String accountIdParamValue = map.get("accountId");
				System.err.println(accountIdParamValue);

				if (!accountIdParamValue.isEmpty()) {
					try {
					Long id = Long.valueOf(accountIdParamValue);

					// TODO : si pas de id => message d'erreur

					entityAccount = entityAccountDao.findById(id);

					if (entityAccount == null) {
						redirectError();
					}
					
					} catch (NumberFormatException e) {
						System.err.println("erreur : "+accountIdParamValue);
						redirectError();
					}

				} else {

					redirectError();

				}
			}
		
	}
	
	


	/*
	 * methods
	 */
	
	// creer une page Erreur parsonna
	public void redirectError() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect("listEntity.xhtml");
	}

	public EntityAccount getEntityAccount() {
		return entityAccount;
	}

	public void setEntityAccount(EntityAccount entityAccount) {
		this.entityAccount = entityAccount;
	}

	public String update() {
		entityAccountDao.update(entityAccount);
		System.out.println(entityAccount);
		return "listEntity.xhtml?faces-redirect=true";
	}

}
