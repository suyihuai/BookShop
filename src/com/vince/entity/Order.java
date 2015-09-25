package com.vince.entity;

public class Order {
	private int id;
	private int bid;
	private String bname;
	private float price;
	private int num;
	private String uname;
	private String sname;
	
	
	public Order() {
		super();
	}
	
	
	public Order(int bid, String bname, float price, int num, String uname,
			String sname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
		this.num = num;
		this.uname = uname;
		this.sname = sname;
	}


	public Order(int id, int bid, String bname, float price, int num,
			String uname, String sname) {
		super();
		this.id = id;
		this.bid = bid;
		this.bname = bname;
		this.price = price;
		this.num = num;
		this.uname = uname;
		this.sname = sname;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return  "图书名称：" + bname
				+ "<br>单价：" + price + "元<br>购买本数：" + num + "<br/>购买账号：" + uname
				+ "<br>卖家账号：" + sname;
	}
}
