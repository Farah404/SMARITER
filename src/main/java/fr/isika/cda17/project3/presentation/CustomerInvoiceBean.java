package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class CustomerInvoiceBean {
	@Inject
	SolutionDao solutionDao;

	private Solution solution;
	
	private LocalDate dueDate;
	
	private LocalDate stampDate;

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("solutionId")) {
			String solutionIdParamValue = map.get("solutionId");
			System.err.println(solutionIdParamValue);
			if (solutionIdParamValue != null && !solutionIdParamValue.isBlank()) {
				Long id = Long.valueOf(solutionIdParamValue);
				if (id != null) {

					solution = solutionDao.findById(id);
					dueDate = LocalDate.now().plusDays(15);
					stampDate = LocalDate.now();
				}
			}
		}
	}

	public Solution getSolution() {
		return solution;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getStampDate() {
		return stampDate;
	}

	public void setStampDate(LocalDate stampDate) {
		this.stampDate = stampDate;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
}
