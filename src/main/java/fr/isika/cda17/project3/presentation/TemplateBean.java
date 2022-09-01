package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;

@ManagedBean
@ViewScoped
public class TemplateBean implements Serializable {

    private static final long serialVersionUID = -3690438985865445753L;

    private String templateToUse;

    public String templatePath() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	if (session.getAttribute("email") == null) {
	    templateToUse = "template/template.xhtml";
	    System.out.println("authentification == None :" + templateToUse);
	    return templateToUse;
	} else {
	    if (session.getAttribute("accountType") == AccountType.USER) {
		templateToUse = "template/template.xhtml";
		System.out.println("authentification == User :" + templateToUse);
		return templateToUse;
	    } else {
		templateToUse = "template/templateWhenConnected.xhtml";
		System.out.println("authentification == True : " + templateToUse);
		return templateToUse;
	    }
	}
    }

    public String subtemplatePath() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	if (session.getAttribute("email") == null) {
	    templateToUse = "subTemplate/subTemplate.xhtml";
	    System.out.println("authentification == None :" + templateToUse);
	    return templateToUse;
	} else {
	    if (session.getAttribute("accountType") == AccountType.USER) {
		templateToUse = "subTemplate/subTemplateWhenConnected.xhtml";
		System.out.println("authentification == User :" + templateToUse);
		return templateToUse;
	    } else {
		templateToUse = "subTemplate/subTemplate.xhtml";
		System.out.println("authentification == True but not User : " + templateToUse);
		return templateToUse;
	    }
	}
    }

    public String getTemplateToUse() {
	return templateToUse;
    }

}
