package com.pragati;

public class Student {
	private String name;
	private String phone;
	private String address;
	private String section;

	public Student(String name, String phone, String section, String address) {
		this.name = name;
		this.phone = phone;
		this.section = section;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
