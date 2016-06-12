package com.prateekjoshi;

import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;

public class CheesePage extends WebPage {

	public CheeseSession getCheeseSession() {
		return (CheeseSession) getSession();
	}

	public Cart getCart() {
		return getCheeseSession().getCart();
	}

	public static List<Cheese> getCheeseList() {
		return WicketApplication.getCheeses();
	}

}
