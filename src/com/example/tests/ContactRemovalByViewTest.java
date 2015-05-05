package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalByViewTest extends TestBase {
	@Test
	public void deleteSomeContact () {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().viewContact(1);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}
}
