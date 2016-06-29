package com.LMS.controller.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.HibernateException;

import com.LMS.model.beans.Book;
import com.LMS.model.beans.Record;
import com.LMS.model.beans.User;
import com.LMS.model.forms.BookForm;
import com.LMS.model.forms.RecordForm;
import com.LMS.model.forms.UserForm;
import com.LMS.model.service.BookManager;
import com.LMS.model.service.RecordManager;
import com.LMS.model.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class userInfoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private RecordForm record;
	private RecordManager RecordManager;
	private BookManager BookManager;
	private UserManager UserManager;
	private String status;
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}	
	public RecordForm getRecord() {
		return this.record;
	}	
	public void setRecord(RecordForm record) {
		this.record = record;
	}
	public void setRecordManager(RecordManager RecordManager) {
		this.RecordManager = RecordManager;
	}
	public void setUserManager(UserManager UserManager) {
		this.UserManager = UserManager;
	}
	public void setBookManager(BookManager BookManager) {
		this.BookManager = BookManager;
	}
	
	public String execute() throws HibernateException, InterruptedException, ParseException {
		System.out.println(record.getUserId());
		UserForm userform = new UserForm();
		userform.setUserId(record.getUserId());
		User user = (User)UserManager.findUser(userform);
		System.out.println(user.getUsername());
		List<Object> resultRecord = this.RecordManager.findRecordbyUserId(record);		
		if(user != null) {
			Map<String, Book> bookmap = new HashMap();
			for(Object o : resultRecord) {
				Record searchRecord = (Record)o;	
				BookForm bookform = new BookForm();
				bookform.setBookId(searchRecord.getBookId());
				Book bookInfo = (Book)this.BookManager.findBook(bookform);
				bookmap.put(searchRecord.getBookId(),bookInfo);
				System.out.println(searchRecord.getBookId());
				System.out.println(bookInfo.getBookName());
			}
			ActionContext.getContext().getSession().put("userinfo", user);
			ActionContext.getContext().getSession().put("Recordlist",resultRecord);
			ActionContext.getContext().getSession().put("bookmap",bookmap);
			record = null;
			return SUCCESS;
		} else {
			record = null;
			return ERROR;
		}
	}
}
