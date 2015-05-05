package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationByViewTest extends TestBase {
	@Test
	public void modifySomeContact () {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().viewContact(1);
		ContactData contact = new ContactData();
	    contact.firstName = "222 name";
	    app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();
	}
}
