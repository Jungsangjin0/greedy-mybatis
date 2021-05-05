package com.kh.common;

public class MenuDTO implements java.io.Serializable {
	
	private int code;
	private String name;
	private int price;
	private int categoryCode;
	private String orderableStatus;
	
	public MenuDTO () {}
	 
	
	public MenuDTO(int code, String name, int price, int categortCode, String orderableStatus) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.categoryCode = categortCode;
		this.orderableStatus = orderableStatus;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategortCode() {
		return categoryCode;
	}
	public void setCategortCode(int categortCode) {
		this.categoryCode = categortCode;
	}
	public String getOrderableStatus() {
		return orderableStatus;
	}
	public void setOrderableStatus(String orderableStatus) {
		this.orderableStatus = orderableStatus;
	}


	@Override
	public String toString() {
		return "MenuDTO [code=" + code + ", name=" + name + ", price=" + price + ", categortCode=" + categoryCode
				+ ", orderableStatus=" + orderableStatus + "]";
	}
	

}
