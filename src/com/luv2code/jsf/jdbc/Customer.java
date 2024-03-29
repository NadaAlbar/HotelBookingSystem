package com.luv2code.jsf.jdbc;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone; 
	private String address1;
	private String address2;
	private String city; 
	private String state; 
	private String zip; 

	public Customer() {
	}
	
	public Customer(int id, String firstName, String lastName, String email, String phone, String address1, String address2, String city, String state, String zip) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone= phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city=city;
		this.state= state; 
		this.zip= zip; 
	}
	
	/*
	public Customer( String firstName, String lastName, String email, String phone, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone= phone;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ",firstName=" + firstName + ",lastName=" + lastName + ",email=" + email + " , address="+ address1 + " "+ address2+ " "+ city+ " "+ state+ " "+ zip +" ]";
	}
	
	

}