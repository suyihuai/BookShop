package com.vince.entity;

public class Stock {
	private int bid;
	private String sname;
	private int num;
	private String bname;
	private float price;
	
	public Stock() {
		super();
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Stock(int bid, String sname, int num, String bname, float price) {
		super();
		this.bid = bid;
		this.sname = sname;
		this.num = num;
		this.bname = bname;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Stock [bid=" + bid + ", sname=" + sname + ", num=" + num
				+ ", bname=" + bname + ", price=" + price + "]";
	}
	
	
}
