package com.prateekjoshi;


import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;


public class CheckOut extends CheesePage{
	@SuppressWarnings("unchecked")
	public CheckOut() {
		
		add(new FeedbackPanel("feedback"));
		
		Form form =new Form("form");
		add(form);
		
		
		Address address=getCart().getBillingAddress();
		form.add(new TextField("name",new PropertyModel(address,"name")).setRequired(true).add(StringValidator.lengthBetween(3,18)));
		form.add(new TextField("street",new PropertyModel(address,"street")).setRequired(true));
		form.add(new TextField("zipcode",new PropertyModel(address,"zipcode")).setRequired(true));
		form.add(new TextField("city",new PropertyModel(address,"city")).setRequired(true));
		
		form.add(new Link("cancel"){
			@Override
			public void onClick() {
				setResponsePage(Index.class);
			}
		});
		
		form.add(new Button("order"){
			@Override
	        public void onSubmit() {
	            Cart cart = getCart();
	            // charge customers’ credit card
	            // ship cheeses to our customer
	            // clean out shopping cart
	            cart.getCheeseList().clear();
	            // return to front page
	            setResponsePage(Index.class);
	        }

		});
	}

}
