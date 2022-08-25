package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.inject.Inject;

import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class EditSolutionBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SolutionDao solutionDao;
	
	private Solution solution;
	
	
	public void init() throws IOException {
		
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.containsKey("solutionId")) {
			String solutionIdParamValue = map.get("solutionId");
			System.err.println(solutionIdParamValue);

			if (!solutionIdParamValue.isEmpty()) {
				try {
				Long id = Long.valueOf(solutionIdParamValue);

				// TODO : si pas de id => message d'erreur

				solution = solutionDao.findById(id); 

				if (solution == null) {
					redirectError();
				}
				
				} catch (NumberFormatException e) {
					System.err.println("erreur : "+solutionIdParamValue);
					redirectError();
				}

			} else {

				redirectError();

			}
		}
	
}
	
	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}


public void redirectError() throws IOException{
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	ec.redirect("listSolution.xhtml");
}
	public String updapte() {
		solutionDao.update(solution);
		System.out.println((solution));
		return "listSolution.xhtml";
	}
}
