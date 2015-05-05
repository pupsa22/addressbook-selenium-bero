package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.address_1);
	    type(By.name("home"), contact.homeNum_1);
	    type(By.name("mobile"), contact.mobileNum);
	    type(By.name("work"), contact.workNum);
	    type(By.name("email"), contact.mail_1);
	    type(By.name("email2"), contact.mail_2);
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    selectByText(By.name("new_group"), contact.group);	    
	    type(By.name("address2"), contact.address_2);
	    type(By.name("phone2"), contact.homeNum_2);
	}


	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void updateContact() {
		click(By.xpath("//form[@action='edit.php']/input[@name='update']"));
	}
	
	public void deleteContact() {
		click(By.xpath("//form[@action='delete.php']/input[@name='update']"));
	}

	public void editContact(int index) {
		click(By.xpath("//tbody/tr[" + (1 + index) + "]/td[7]/a/img"));
	}

	public void viewContact(int index) {
		click(By.xpath("//tbody/tr[" + (1 + index) + "]/td[6]/a/img"));
		click(By.name("modifiy"));
	}



}
