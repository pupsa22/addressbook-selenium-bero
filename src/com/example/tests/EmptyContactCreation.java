package com.example.tests;


import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {

  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.b_day = "-";
    contact.b_month = "-";
    contact.group = "[none]";
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPage();
  }
}
