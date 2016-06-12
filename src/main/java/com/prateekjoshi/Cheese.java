package com.prateekjoshi;

import java.io.Serializable;

public class Cheese implements Serializable{

	private String name;
	private String desciption;
	private double price;
	
	public Cheese(String n,String desc,double p) {
		name=n;
		desciption=desc;
		price=p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
