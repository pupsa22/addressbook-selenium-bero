package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address_1;
	private String homeNum_1;
	private String mobileNum;
	private String workNum;
	private String mail_1;
	private String mail_2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private String group;
	private String address_2;
	private String homeNum_2;

	public ContactData() {
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", address_1=" + address_1 + ", homeNum_1=" + homeNum_1
				+ ", mobileNum=" + mobileNum + ", workNum=" + workNum
				+ ", mail_1=" + mail_1 + ", mail_2=" + mail_2 + ", birthDay="
				+ birthDay + ", birthMonth=" + birthMonth + ", birthYear="
				+ birthYear + ", group=" + group + ", address_2=" + address_2
				+ ", homeNum_2=" + homeNum_2 + "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int result = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (result == 0) {
			result = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}
		return result;
	}
	
	//Setters
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress_1(String address_1) {
		this.address_1 = address_1;
		return this;
	}

	public ContactData withHomeNum_1(String homeNum_1) {
		this.homeNum_1 = homeNum_1;
		return this;
	}

	public ContactData withMobileNum(String mobileNum) {		
		this.mobileNum = mobileNum;
		return this;
	}

	public ContactData withWorkNum(String workNum) {
		this.workNum = workNum;
		return this;
	}

	public ContactData withMail_1(String mail_1) {
		this.mail_1 = mail_1;
		return this;
	}

	public ContactData withMail_2(String mail_2) {
		this.mail_2 = mail_2;
		return this;
	}

	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}

	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}

	public ContactData withAddress_2(String address_2) {
		this.address_2 = address_2;
		return this;
	}

	public ContactData withHomeNum_2(String homeNum_2) {
		this.homeNum_2 = homeNum_2;
		return this;
	}


	//Getters
	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getAddress_1() {
		return address_1;
	}



	public String getHomeNum_1() {
		return homeNum_1;
	}



	public String getMobileNum() {
		return mobileNum;
	}



	public String getWorkNum() {
		return workNum;
	}



	public String getMail_1() {
		return mail_1;
	}



	public String getMail_2() {
		return mail_2;
	}



	public String getBirthDay() {
		return birthDay;
	}



	public String getBirthMonth() {
		return birthMonth;
	}



	public String getBirthYear() {
		return birthYear;
	}



	public String getGroup() {
		return group;
	}



	public String getAddress_2() {
		return address_2;
	}



	public String getHomeNum_2() {
		return homeNum_2;
	}

}