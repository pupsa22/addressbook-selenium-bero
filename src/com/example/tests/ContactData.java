package com.example.tests;

public class ContactData {
	public String first_name;
	public String last_name;
	public String address_1;
	public String home_num_1;
	public String mobile_num;
	public String work_num;
	public String mail_1;
	public String mail_2;
	public String b_day;
	public String b_month;
	public String b_year;
	public String group;
	public String address_2;
	public String home_num_2;

	public ContactData() {
	}
	public ContactData(String first_name, String last_name,
			String address_1, String home_num_1, String mobile_num,
			String work_num, String mail_1, String mail_2, String b_day,
			String b_month, String b_year, String group, String address_2,
			String home_num_2) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address_1 = address_1;
		this.home_num_1 = home_num_1;
		this.mobile_num = mobile_num;
		this.work_num = work_num;
		this.mail_1 = mail_1;
		this.mail_2 = mail_2;
		this.b_day = b_day;
		this.b_month = b_month;
		this.b_year = b_year;
		this.group = group;
		this.address_2 = address_2;
		this.home_num_2 = home_num_2;
	}
}