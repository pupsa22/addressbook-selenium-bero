package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

public class GroupCreationTest extends TestBase {  
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	
	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    
	    //save old state
	    GroupHelper groupHelper = app.getGroupHelper();
	    SortedListOf<GroupData> oldList = groupHelper.getGroups();
	    
	    //actions
		groupHelper.createGroup(group);
				
	    //save new state
		SortedListOf<GroupData> newList = groupHelper.getGroups();
	    
	    //compare states
		assertThat(newList, equalTo(oldList.withAdded(group)));
  }
}
