package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalByEditTest extends TestBase {
	@Test
	public void deleteSomeContact () {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContact(1);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}
}
