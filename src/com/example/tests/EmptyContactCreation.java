package com.example.tests;


import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {

  @Test
  public void testEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.birthDay = "-";
    contact.birthMonth = "-";
    contact.group = "[none]";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
