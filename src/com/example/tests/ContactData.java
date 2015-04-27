package com.example.tests;

public class ContactData {
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

	public ContactData() {
	}
	public ContactData(String first_name, String last_name,
			String address_1, String home_num_1, String mobile_num,
			String work_num, String mail_1, String mail_2, String b_day,
			String b_month, String b_year, String group, String address_2,
			String home_num_2) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.address_1 = address_1;
		this.homeNum_1 = home_num_1;
		this.mobileNum = mobile_num;
		this.workNum = work_num;
		this.mail_1 = mail_1;
		this.mail_2 = mail_2;
		this.birthDay = b_day;
		this.birthMonth = b_month;
		this.birthYear = b_year;
		this.group = group;
		this.address_2 = address_2;
		this.homeNum_2 = home_num_2;
	}
}