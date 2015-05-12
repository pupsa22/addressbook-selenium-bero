package com.example.tests;


import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
  //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initContactCreation();
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
