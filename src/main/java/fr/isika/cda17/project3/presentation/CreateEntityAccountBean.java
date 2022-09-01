package fr.isika.cda17.project3.presentation;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;

@ManagedBean
@ViewScoped
public class CreateEntityAccountBean {

    @Inject
    private EntityAccountDao entityAccountDao;

    private EntityAccount entityAccount = new EntityAccount();

    public void create() {
	EntityAccount created = entityAccountDao.create(entityAccount);
	System.out.println(created);
    }

    public void init() {
	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	if (map.containsKey("accountId")) {
	    String accountIdParamValue = map.get("accountId");
	    Long id = Long.valueOf(accountIdParamValue);

	    // TODO : si pas de id => message d'erreur
	    if (id != null) {
		entityAccount = entityAccountDao.findById(id);
	    } else {
		// TODO: error
		return;

	    }
	}
    }

    public String showUpdate(Long id) {
	System.err.println(id);
	return "Testagain.xhtml?accountId=" + id;
    }

    public EntityAccount getEntityAccount() {
	return entityAccount;
    }

    public void setEntityAccount(EntityAccount entityAccount) {
	this.entityAccount = entityAccount;
    }
}
