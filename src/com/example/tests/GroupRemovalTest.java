package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;



public class GroupRemovalTest extends TestBase {
	@Test
	public void deleteSomeGroup() {

		//save old state
	    GroupHelper groupHelper = app.getGroupHelper();
	    SortedListOf<GroupData> oldList = groupHelper.getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		groupHelper.deleteGroup(index);
		
				
	    //save new state
		SortedListOf<GroupData> newList = groupHelper.getGroups();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}
}
