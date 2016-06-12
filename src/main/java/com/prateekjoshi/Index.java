package com.prateekjoshi;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class Index extends CheesePage {

	Label totalLabel = new Label("total", new Model("$" + getCart().getTotal()));

	@SuppressWarnings("unchecked")
	public Index() {

		PageableListView cheesePages = new PageableListView("cheeses", getCheeseList(), 3) {

			@Override
			protected void populateItem(ListItem item) {
				Cheese cheese = (Cheese) item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("desc", cheese.getDesciption()));
				item.add(new Label("price", "$" + cheese.getPrice()));
				item.add(new Link("add", item.getModel()) {
					@Override
					public void onClick() {
						Cheese selected = (Cheese) getModelObject();
						getCart().getCheeseList().add(selected);
						totalLabel.setDefaultModelObject("$" + getCart().getTotal());
					}
				});

			}

		};

		add(cheesePages);
		add(new PagingNavigator("navigator", cheesePages));

		add(new ListView("cart", new PropertyModel(this, "cart.cheeseList")) {
			@Override
			protected void populateItem(ListItem item) {
				Cheese cheese = (Cheese) item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("price", "$" + cheese.getPrice()));
				item.add(new Link("remove", item.getModel()) {

					@Override
					public void onClick() {
						Cheese selected = (Cheese) getModelObject();
						getCart().getCheeseList().remove(selected);
						totalLabel.setDefaultModelObject("$" + getCart().getTotal());
					}

				});
			}
		});

		totalLabel.setOutputMarkupId(true);
		add(totalLabel);

		add(new Link("checkout") {
			@Override
			public void onClick() {
				setResponsePage(new CheckOut());
			}

			@Override
			public boolean isVisible() {
				return !getCart().getCheeseList().isEmpty();
			}

		});
	}

}
