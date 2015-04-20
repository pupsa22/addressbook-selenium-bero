package com.example.tests;


import org.testng.annotations.Test;

public class NonEmptyContactCreation extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.first_name = "first name";
    contact.last_name = "last name";
    contact.address_1 = "address 1";
    contact.home_num_1 = "home num 1";
    contact.mobile_num = "mobile num";
    contact.work_num = "work num";
    contact.mail_1 = "mail 1";
    contact.mail_2 = "mail 2";
    contact.b_day = "22";
    contact.b_month = "July";
    contact.b_year = "1990";
    contact.group = "123";
    contact.address_2 = "address 2";
    contact.home_num_2 = "home num 2";
    fillContactForm(contact);
    submitContactCreation();
    returnToMainPage();
  }
}
