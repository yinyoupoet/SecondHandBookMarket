package com.example.administrator.oldbook;

public class Book {

	private int imageUrl;//图片路径
	private String bookName;//书名
	private String bookCategory;//书的分类
	private double bookPrice;//原价
	private double sellPrice;//现价
	private int bookCount;//数量
	
	public Book(int imageUrl,String bookName,String bookCategory,double bookPrice,double sellPrice,int bookCount){
		this.imageUrl = imageUrl;
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.bookPrice = bookPrice;
		this.sellPrice=sellPrice;
		this.bookCount = bookCount;
	}
	public int getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(int imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getSellPrice(){
		return sellPrice;
	}
	public void setSellPrice(double sellPrice){
		this.sellPrice=sellPrice;
	}
	public int getProductCount() {
		return bookCount;
	}
	public void setProductCount(int bookCount) {
		this.bookCount = bookCount;
	}
}
