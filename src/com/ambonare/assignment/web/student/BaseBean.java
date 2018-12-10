package com.ambonare.assignment.web.student;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public abstract class BaseBean implements Serializable {

	@SuppressWarnings("deprecation")
	protected void excuteJavaScript(String script) {
		RequestContext.getCurrentInstance().execute(script);
	}

	/**
	 * Add success message
	 * 
	 * @param message
	 */
	protected void addSuccessMessage(String message) {
		addMessage(FacesMessage.SEVERITY_INFO, message);
	}

	private void addMessage(Severity severity, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, ""));
	}

}
