package com.prateekjoshi;

import org.apache.wicket.ajax.form.AjaxFormValidatingBehavior;
import org.apache.wicket.feedback.ExactLevelFeedbackMessageFilter;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.validation.validator.RangeValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class CheckOut extends CheesePage {

	public CheckOut() {
		FeedbackPanel errorPanel = new FeedbackPanel("feedback_error",
				new ExactLevelFeedbackMessageFilter(FeedbackMessage.ERROR));
		
		errorPanel.setOutputMarkupId(true);

		add(errorPanel);


		addForm();
		

	}

	public void addForm() {
		Cart cart = new Cart();
		@SuppressWarnings("unchecked")
		Form form = new Form("form", new CompoundPropertyModel<>(cart));
		add(form);
		addFormValidator(form);
		
		form.setOutputMarkupId(true);
		form.add(new AjaxFormValidatingBehavior("keydown", Duration.ONE_SECOND));
	}

	public void addFormValidator(Form<Cart> form) {
		Address address = getCart().getBillingAddress();
		FormComponent<String> fc = new RequiredTextField<>("name");
		fc.add(new StringValidator(4, null));
		fc.setDefaultModel(new PropertyModel<>(address, "name"));
		form.add(fc);

		fc = new RequiredTextField<>("street");
		fc.add(new StringValidator(4, null));
		fc.setDefaultModel(new PropertyModel<>(address, "street"));
		form.add(fc);

		fc = new RequiredTextField<>("city");
		fc.add(new StringValidator(4, null));
		fc.setDefaultModel(new PropertyModel<>(address, "city"));
		form.add(fc);

		fc = new RequiredTextField<>("zipcode");
		fc.add(RangeValidator.range(110011,110039));
		fc.setDefaultModel(new PropertyModel<>(address, "zipcode"));
		form.add(fc);

		form.add(new Link("cancel") {
			@Override
			public void onClick() {
				setResponsePage(Index.class);
			}
		});

		form.add(new Button("order") {
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
