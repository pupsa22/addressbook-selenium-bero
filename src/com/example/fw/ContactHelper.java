package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
private SortedListOf<ContactData> cashedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cashedContacts == null) {
			rebuildCash();
		}
		return cashedContacts;
	}
	
	private void rebuildCash() {
		cashedContacts = new SortedListOf<ContactData>();		
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactData contact = new ContactData()
				.withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
				.withLastName(row.findElement(By.xpath(".//td[2]")).getText());
			cashedContacts.add(contact);
		}
	}

	public ContactHelper createContact(ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
	    initContactCreation();
	    fillContactForm(contact, CREATION);
	    submitContactCreation();
	    returnToHomePage();
	    rebuildCash();
		return this;
	}

	public ContactHelper modifyContactByEdit(int index, ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
		editContact(index);
	    fillContactForm(contact, MODIFICATION);
	    updateContact();
		returnToHomePage();
		rebuildCash();
		return this;
	}
	
	public ContactHelper modifyContactByViewDetails(int index, ContactData contact, boolean formType) {
		manager.navigateTo().mainPage();
		viewContact(index);
	    fillContactForm(contact, MODIFICATION);
	    updateContact();
		returnToHomePage();
		rebuildCash();
		return this;
	}

	public ContactHelper removeContactByEdit(int index) {
		manager.navigateTo().mainPage();
		viewContact(index);
		deleteContact();
		returnToHomePage();
		rebuildCash();
		return this;
	}

	public ContactHelper removeContactByViewDetails(int index) {
		manager.navigateTo().mainPage();
		viewContact(index);
		deleteContact();
		returnToHomePage();
		rebuildCash();
		return this;
	}
	
	//________________________________________________________________________________________________
	

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress_1());
	    type(By.name("home"), contact.getHomeNum_1());
	    type(By.name("mobile"), contact.getMobileNum());
	    type(By.name("work"), contact.getWorkNum());
	    type(By.name("email"), contact.getMail_1());
	    type(By.name("email2"), contact.getMail_2());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    if (formType == CREATION) {
	    	// selectByText(By.name("new_group"), contact.getGroup());
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() != 0) {
	    		throw new Error ("Group selector exists in contact modification form");
	    	}
	    }	    	    
	    type(By.name("address2"), contact.getAddress_2());
	    type(By.name("phone2"), contact.getHomeNum_2());
		return this;
	}


	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cashedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper updateContact() {
		click(By.xpath("//input[@value='Update']"));
		cashedContacts = null;
		return this;
	}
	
	public ContactHelper deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		cashedContacts = null;
		return this;
	}

	public ContactHelper editContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		return this;
	}

	public ContactHelper viewContact(int index) {
		click(By.xpath("(//img[@alt='Details'])[" + (index+1) + "]"));
		click(By.name("modifiy"));
		return this;
	}
	

	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}
}
