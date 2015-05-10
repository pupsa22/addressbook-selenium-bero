package com.example.tests;


import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationNonEmptyTest extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
  //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "01firstName";
    contact.lastName = "001lastName";
    contact.address_1 = "address 1";
    contact.homeNum_1 = "home num 1";
    contact.mobileNum = "mobile num";
    contact.workNum = "work num";
    contact.mail_1 = "mail 1";
    contact.mail_2 = "mail 2";
    contact.birthDay = "22";
    contact.birthMonth = "July";
    contact.birthYear = "1990";
    contact.group = "Rob";
    contact.address_2 = "address 2";
    contact.homeNum_2 = "home num 2";
    app.getContactHelper().contactName(contact); //name of checkbox in the list of Contacts
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
}
