package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address_1;
	public String homeNum_1;
	public String mobileNum;
	public String workNum;
	public String mail_1;
	public String mail_2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String group;
	public String address_2;
	public String homeNum_2;
	public String name;

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
				+ ", homeNum_2=" + homeNum_2 + ", name=" + name + "]";
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}
	
	
}