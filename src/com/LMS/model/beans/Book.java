package com.LMS.model.beans;

public class Book {
	private String bookId;
	private String Picture;
	private String ISBN;
	private String bookName;
	private String Author;
	private String Price;
	private String Publisher;
	private String location;
	private String bookAbstract;
	private int flag; // 1�鼮�ڹ� 2�鼮�����δ��ԤԼ 3�鼮����ұ�ԤԼ  4ͼ��黹���Ǳ�ԤԼ
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return this.bookId;
	}
	public void setPicture(String Picture) {
		this.Picture = Picture;
	}
	public String getPicture() {
		return this.Picture;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getISBN() {
		return this.ISBN;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return this.bookName;
	}
	public void setAuthor(String Author) {
		this.Author = Author;
	}
	public String getAuthor() {
		return this.Author;
	}
	public void setPrice(String Price) {
		this.Price = Price;
	}
	public String getPrice() {
		return this.Price;
	}
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}
	public String getPublisher() {
		return this.Publisher;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return this.location;
	}
	public void setBookAbstract(String bookAbstract) {
		this.bookAbstract = bookAbstract;
	}
	public String getBookAbstract() {
		return this.bookAbstract;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFlag(){
		return this.flag;
	}
}
