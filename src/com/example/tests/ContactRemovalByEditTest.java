package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalByEditTest extends TestBase {
	@Test
	public void deleteSomeContact () {
		app.getNavigationHelper().openMainPage();
	    //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
		app.getContactHelper().editContact(0);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
		  
	    //save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	  
	}
}
