package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length <3) {
			System.out.println("Please spesify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);		
		writer.write(xml);
		writer.close();	
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);		
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress_1() + "," + contact.getHomeNum_1() + "," + contact.getMobileNum() + "," + contact.getWorkNum() + "," + contact.getMail_1() + "," + contact.getMail_2() + "," + contact.getBirthDay() + "," + contact.getBirthMonth() + "," + contact.getBirthYear() + "," + contact.getAddress_2() + "," + contact.getHomeNum_2() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){		
		String[] part = line.split(",");
		ContactData contact = new ContactData()
			.withFirstName(part[0])
		    .withLastName(part[1])
		    .withAddress_1(part[2])
		    .withHomeNum_1(part[3])
		    .withMobileNum(part[4])
		    .withWorkNum(part[5])
		    .withMail_1(part[6])
		    .withMail_2(part[7])
		    .withBirthDay(part[8])
		    .withBirthMonth(part[9])
		    .withBirthYear(part[10])
		    .withAddress_2(part[11])
		    .withHomeNum_2(part[12]);
		list.add(contact);
		line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();		
		for (int i = 0; i < amount; i++) {
		    ContactData contact = new ContactData()
			    .withFirstName(generateRandomString())
			    .withLastName(generateRandomString())
			    .withAddress_1(generateRandomString())
			    .withHomeNum_1(generateRandomString())
			    .withMobileNum(generateRandomString())
			    .withWorkNum(generateRandomString())
			    .withMail_1(generateRandomString())
			    .withMail_2(generateRandomString())
			    .withBirthDay(generateRandomBirthDay())
			    .withBirthMonth("April")
			    .withBirthYear(generateRandomBirthYear())
			    .withAddress_2(generateRandomString())
			    .withHomeNum_2(generateRandomString());		    		   
			list.add(contact);
		}		
		return list;
	}
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3)== 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	public static String generateRandomBirthDay() {
		Random rnd = new Random();
		if (rnd.nextInt(5)== 0) {
			return "-";
		} else {
			return String.valueOf(rnd.nextInt(31)+1);
		}			
	}

	public static String generateRandomBirthYear() {
		Random rnd = new Random();
		if (rnd.nextInt(20)== 0) {
			return "-";
		} else {
			return String.valueOf(rnd.nextInt(2016-1915)+1915);
		}			
	}
		

}
