package com.LMS.controller.action;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.LMS.model.beans.Book;
import com.LMS.model.beans.Record;
import com.LMS.model.forms.BookForm;
import com.LMS.model.forms.RecordForm;
import com.LMS.model.service.BookManager;
import com.LMS.model.service.RecordManager;
import com.LMS.model.service.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class findBorrowRecordAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
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
		List<Object> resultRecord = this.RecordManager.findAllBorrowRecord();
		if(resultRecord != null && resultRecord.size() != 0) {
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
			ActionContext.getContext().getSession().put("Recordlist",resultRecord);
			ActionContext.getContext().getSession().put("bookmap",bookmap);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
