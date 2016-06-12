package com.prateekjoshi;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class CheeseSession extends WebSession{
	
	private Cart cart=new Cart();
	
	public CheeseSession(Request  req) {
		super(req);
	}
	
	public Cart getCart(){
		return cart;
	}

}
