package com.gdu.app01.xml07;

public class Contact {

	// field
	private String address;
	private String email;
	private String tel;
	
	// constructor
	public Contact(String address, String email, String tel) {
		super();
		this.address = address;
		this.email = email;
		this.tel = tel;
	}
	
	// method
	public void info() {
		System.out.println("�ּ�: " + address);
		System.out.println("�̸���: " + email);
		System.out.println("����ó: " + tel);
	}
	
	
}
