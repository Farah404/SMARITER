package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.constraintvalidators.NullValidator;

@ManagedBean
@ViewScoped
public class TemplateBean implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = -3690438985865445753L;
	
	private String templateToUse;
		
	public String templatePath() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session.getAttribute("email") == null){
			templateToUse="template/template.xhtml";
			System.out.println("session sans authentification :"+templateToUse);
			return templateToUse;
		}else {
			templateToUse ="template/templateWhenConnected.xhtml";
			System.out.println("session authentifiee : "+templateToUse);
			return templateToUse;
		}
	}

	public String getTemplateToUse() {
		return templateToUse;
	}

}
