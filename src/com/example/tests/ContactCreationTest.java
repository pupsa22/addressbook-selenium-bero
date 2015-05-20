package com.example.tests;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTest extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
    
    //save old state
    ContactHelper contactHelper = app.getContactHelper();
    SortedListOf<ContactData> oldList = contactHelper.getContacts();
    
    //actions
    contactHelper.createContact(contact, CREATION);
  
    //save new state
    SortedListOf<ContactData> newList = contactHelper.getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
}
