package com.prateekjoshi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

	private List<Cheese> cheeseList = new ArrayList<Cheese>();
	private Address billingAddress = new Address();

	public List<Cheese> getCheeseList() {
		return cheeseList;
	}

	public void setCheeseList(List<Cheese> cheeseList) {
		this.cheeseList = cheeseList;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public double getTotal() {
		double total = 0;
		for (Cheese s : cheeseList) {
			total = total + s.getPrice();
		}
		return total;
	}

}
