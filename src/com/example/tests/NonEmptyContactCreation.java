package com.example.tests;


import org.testng.annotations.Test;

public class NonEmptyContactCreation extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "first name";
    contact.lastName = "last name";
    contact.address_1 = "address 1";
    contact.homeNum_1 = "home num 1";
    contact.mobileNum = "mobile num";
    contact.workNum = "work num";
    contact.mail_1 = "mail 1";
    contact.mail_2 = "mail 2";
    contact.birthDay = "22";
    contact.birthMonth = "July";
    contact.birthYear = "1990";
    contact.group = "123";
    contact.address_2 = "address 2";
    contact.homeNum_2 = "home num 2";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
