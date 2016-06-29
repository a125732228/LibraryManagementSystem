package com.LMS.controller.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.LMS.model.beans.User;
import com.LMS.model.forms.UserForm;
import com.LMS.model.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserForm user;

	private UserManager userManager;
	

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

	public String execute() throws HibernateException, InterruptedException {
		if(userManager.loginUser(user) == true) {
			User userinfo = (User)this.userManager.findUser(user);
			ActionContext.getContext().getSession().put("userId", user.getUserId());
			ActionContext.getContext().getSession().put("userName",userinfo.getUsername());
			ActionContext.getContext().getSession().put("email", userinfo.getEmail());
			ActionContext.getContext().getSession().put("userType", "user");
			ActionContext.getContext().put("name",user.getUserId());
			return SUCCESS;
		} else {
			ActionContext.getContext().put("error","UserId or Password is incorrect!");
			return ERROR;
		}

	}
}
