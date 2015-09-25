package com.vince.entity;

public class Wholesale {
	private int id;
	private int bid;
	private String bname;
	private float price;
	private int num;
	private String sname;
	private String author;
	private String press;
	public Wholesale() {
		super();
	}
	public Wholesale(int bid, int num, String sname) {
		super();
		this.bid = bid;
		this.num = num;
		this.sname = sname;
	}
	
	
	public Wholesale(int id, int bid, int num, String sname) {
		super();
		this.id = id;
		this.bid = bid;
		this.num = num;
		this.sname = sname;
	}
	
	public Wholesale( int bid, String bname, float price, int num,
			String sname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
		this.num = num;
		this.sname = sname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	@Override
	public String toString() {
		return "Wholesale [id=" + id + ", bid=" + bid + ", bname=" + bname
				+ ", price=" + price + ", num=" + num + ", sname=" + sname
				+ "]";
	}
	
}
