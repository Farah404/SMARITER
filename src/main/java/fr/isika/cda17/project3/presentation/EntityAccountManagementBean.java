package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;

@ManagedBean
@ViewScoped
public class EntityAccountManagementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityAccountDao entityAccountDao;

    private List<EntityAccount> entityAccountList;

    @PostConstruct
    private void init() {
	refresh();
    }

    public String showUpdate(Long id) {
	System.err.println(id);
	return "editEntity.xhtml?faces-redirect=true&accountId=" + id;
    }

    public void delete(Long id) {
	entityAccountDao.delete(id);
	refresh();
    }

    private void refresh() {
	entityAccountList = entityAccountDao.findAll();
    }

    public List<EntityAccount> getEntityAccountList() {
	return entityAccountList;
    }

    public void setEntityAccountList(List<EntityAccount> entityAccountList) {
	this.entityAccountList = entityAccountList;
    }

}
