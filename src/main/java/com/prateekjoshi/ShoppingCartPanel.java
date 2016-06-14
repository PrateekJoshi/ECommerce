package com.prateekjoshi;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class ShoppingCartPanel extends Panel{

	private Cart cart;
	
	@SuppressWarnings("unchecked")
	public ShoppingCartPanel(String id,Cart c) {
		super(id);
		cart=c;
		
		add(new ListView("cart",new PropertyModel(this,"cart.CheeseList")){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item) {
				Cheese cheese=(Cheese) item.getModelObject();
				item.add(new Label("name", cheese.getName()));
	            item.add(new Label("price", "$" + cheese.getPrice()));
	            item.add(removeLink("remove", item));
			}		
		});
		
	}
	
	public Cart getCart(){
		return cart;
	}
}
