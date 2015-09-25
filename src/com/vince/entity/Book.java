package com.vince.entity;

public class Book {
	private int bid;
	private String name;
	private float ws_price;
	private String author;
	private String press;
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	
	
	public Book(String name, float ws_price, String author, String press,
			String url) {
		super();
		this.name = name;
		this.ws_price = ws_price;
		this.author = author;
		this.press = press;
		this.url = url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	public Book(int bid, String name, float ws_price, String author,
			String press,String url) {
		super();
		this.bid = bid;
		this.name = name;
		this.ws_price = ws_price;
		this.author = author;
		this.press = press;
		this.url = url;
	}
	public Book() {
		super();
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWs_price() {
		return ws_price;
	}
	public void setWs_price(float ws_price) {
		this.ws_price = ws_price;
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
		return "Book [bid=" + bid + ", name=" + name + ", ws_price=" + ws_price
				+ ", author=" + author + ", press=" + press + ", url=" + url
				+ "]";
	}
	
}
