package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;


@ManagedBean
@ViewScoped
public class SolutionManagementBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private SolutionDao solutionDao;

	private List<Solution> solutiontList;

	@PostConstruct
	private void init() {
		refresh();
	}

	/*
	 * methods
	 */

	public String showUpdate(Long id) {
		//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		System.err.println(id);
		//ec.redirect("editSolution.xhtml?solutionId=" + id);
		return "editSolution.xhtml?faces-redirect=true&solutionId=" + id;
	}

	public void delete(Long id) {
		solutionDao.delete(id);
		refresh();
	}

	private void refresh() {
		solutiontList = solutionDao.findAll();
		
	}

	/*
	 * getters and setters
	 */


	public List<Solution> getSolutiontList() {
		return solutiontList;
	}

	public void setSolutiontList(List<Solution> solutiontList) {
		this.solutiontList = solutiontList;
	}


}
