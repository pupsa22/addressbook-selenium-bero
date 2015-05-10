package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationByViewTest extends TestBase {
	@Test
	public void modifySomeContact () {
		app.getNavigationHelper().openMainPage();
	    
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
		app.getContactHelper().viewContact(0);
		ContactData contact = new ContactData();
	    contact.firstName = "222 name";
	    app.getContactHelper().contactName(contact); //name of checkbox in the list of Contacts
	    app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();
		  
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
}
