package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationByEditTest extends TestBase {
	@Test
	public void modifySomeContact () {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContact(1);
		ContactData contact = new ContactData();
	    contact.firstName = "111 name";
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();
	}
}
