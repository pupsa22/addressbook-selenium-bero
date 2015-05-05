package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationNonEmptyTest extends TestBase {  
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		app.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData();
		group.name = "group name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
  }
}
