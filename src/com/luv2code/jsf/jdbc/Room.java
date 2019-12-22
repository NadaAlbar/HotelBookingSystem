package com.luv2code.jsf.jdbc;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class Room  implements Serializable{

	private int id;
	private static String hotelName;
	private static int price;
	private static String roomNumber;
	private static String type;
	
	private static int guests;
	
	 private static final long serialVersionUID = 1L;

	public Room() {
	}
	
	public Room(int id, String hotelName,String roomNumber, int price, String Type, int guests ) {
		this.id = id;
		this.hotelName = hotelName;
		this.price = price;
		this.type = Type;
		
		this.roomNumber=roomNumber;
		this.guests=guests;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

	
	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	//room status, roomNumber, price , type, hotel name. 
	@Override
	public String toString() {
		
		String s =  "user's id=" + id +"hotel Name = " + hotelName +", RoomNumber" + roomNumber+" hotelPrice=" + price + ", roomType=" + type; 
		return s;
	}

}
