package com.example.administrator.oldbook;

public class OrderItem {

	//һ������
	private String orderNo;//�µ�ʱ��
	private String orderState;//����״̬
	private long totalPrice;//�ܸ���
	private Book book;
	
	public OrderItem(String orderNo,String orderState,long totalPrice,Book book)
	{
		this.orderNo = orderNo;
		this.orderState = orderState;
		this.totalPrice = totalPrice;
		this.book = book;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
