package com.luv2code.jsf.jdbc;

public class Hotel {
	
	
	private static int hotel_id;
	private static String hotel_name, address, city, phone, state;
	
	public Hotel (  int id, String hotelName,String hAddr, String hCity,String  hPhone,String hState){
		this.hotel_id = id;
		this.hotel_name=hotelName;
		this.address=address;
		this.city=city;
		this.phone=phone;
		this.state= state;
	}
	

	public static int getHotel_id() {
		return hotel_id;
	}

	public static void setHotel_id(int hotel_id) {
		Hotel.hotel_id = hotel_id;
	}

	public static String getHotel_name() {
		return hotel_name;
	}

	public static void setHotel_name(String hotel_name) {
		Hotel.hotel_name = hotel_name;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		Hotel.address = address;
	}

	public static String getCity() {
		return city;
	}

	public static void setCity(String city) {
		Hotel.city = city;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		Hotel.phone = phone;
	}
	
	public static String getState() {
		return state;
	}

	public static void setState(String state) {
		Hotel.state = state;
	}

}
