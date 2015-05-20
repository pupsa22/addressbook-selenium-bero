package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactRemovalByEditTest extends TestBase {
	@Test
	public void deleteSomeContact () {
		
	    //save old state
		ContactHelper contactHelper = app.getContactHelper();
		SortedListOf<ContactData> oldList = contactHelper.getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    contactHelper.removeContactByViewDetails(index);
		  
	    //save new state
	    SortedListOf<ContactData> newList = contactHelper.getContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}
}
