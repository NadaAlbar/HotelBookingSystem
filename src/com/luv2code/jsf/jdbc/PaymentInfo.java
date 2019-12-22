package com.luv2code.jsf.jdbc;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped 
public class PaymentInfo implements Serializable {
	
	
	 private static final long serialVersionUID = 1L;
	 
	 
	 private String month="1";
	 private String year;
	 
	 private String cardNumber;
	 private String nameOnCard;
	 
	 
	 
	 
	 	private String firstName;
		private String lastName;
		
		private String phone; 
		private String address1;
		private String address2;
		private String city; 
		private String state; 
		private String zip; 
		
		
		
		
	 public String getMonth() {
			
			return month;
		}
		
		public void setMonth(String month) {
			this.month = month;
		}
		
		
		public String getYear() {
			
			return year;
		}
		
		public void setYear(String year) {
			this.year = year;
		}
		
		
		
		
		 public String getCardNumber() {
				
				return cardNumber;
			}
			
			public void setCardNumber(String cardNumber) {
				this.cardNumber = cardNumber;
			}
			
			
			public String getNameOnCard() {
				
				return nameOnCard;
			}
			
			public void setNameOnCard(String nameOnCard) {
				this.nameOnCard = nameOnCard;
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
	 

}
