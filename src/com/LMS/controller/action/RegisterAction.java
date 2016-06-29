package com.LMS.controller.action;

import com.LMS.model.forms.RecordForm;
import com.LMS.model.forms.UserForm;
import com.LMS.model.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserForm user;

	private UserManager userManager;
	
	private String status;

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
		this.user.setFlag(1);
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}

	public String execute() {
		try {
			userManager.regUser(user);
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("status","UserId has been registered!");
			return ERROR;
		}
	}

}
