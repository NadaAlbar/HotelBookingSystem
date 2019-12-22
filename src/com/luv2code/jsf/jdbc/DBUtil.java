package com.luv2code.jsf.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	
	
	private static  int cust_id;
	private static  int bill_id;
	private static  int trans_id;
	private static  int reser_id; 
	private static int room_id; 
	private static double total ; 
	private static String checkInDate ;
	private static String checkOutDate;
	
	
	
	private static DBUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/hotelSystem";
	
	public static DBUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new DBUtil();
		}
		
		return instance;
	}
	
	private DBUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
	
	
	
	public List<Hotel> getHotels() throws Exception {

		List<Hotel> hotels = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from Hotel order by hotel_id";//order by last_name

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				 int id = myRs.getInt("hotel_id");
				 String hotelName = myRs.getString("hotel_name");
				 String hAddr= myRs.getString("address");
				 String hCity= myRs.getString("city");
				 String hPhone= myRs.getString("phone");
				 String hState= myRs.getString("state");
				// String status= myRs.getString("room_status");
				
				 room_id = id; 
				// create new student object
				 Hotel tempHotel = new Hotel(  id,  hotelName, hAddr,  hCity,  hPhone, hState);

				// add it to the list of students
				 hotels.add(tempHotel);
			}//
			
			return hotels;		
		}
		finally {
			close (myConn, myStmt, myRs);
		}
		
		
	}
	
	
		
	public List<Room> getRooms() throws Exception {

		List<Room> rooms = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from Room order by room_id";//order by last_name

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				 int id = myRs.getInt("room_id");
				 String hotelName = myRs.getString("hotel");
				 String roomNumber= myRs.getString("room_num");
				 int price= myRs.getInt("price");
				 String Type= myRs.getString("room_type");
				// String status= myRs.getString("room_status");
				 int nguests= myRs.getInt("Room.num_guests");
				 room_id = id; 
				// create new student object
				Room tempRoom = new Room(  room_id,  hotelName, roomNumber,  price,  Type,nguests);

				// add it to the list of students
				rooms.add(tempRoom);
			}//
			
			return rooms;		
		}
		finally {
			close (myConn, myStmt, myRs);
		}
		
		
	}
	
	
	
	
	public List<Room> FindRooms( String city, String  guests, String inDate, String outDate) throws Exception {
		
		
		 

		List<Room> rooms = new ArrayList<>();

		Connection myConn = null;
		//PreparedStatement pstmt = null;
		ResultSet myRs = null;
		PreparedStatement pstmt = null;
		
		try {
			myConn = getConnection();

			//String sql = "SELECT DISTINCT Hotel.hotel_name, Room.room_id, Room.room_type, Room.num_guests, Room.room_num, Room.room_status, Room.price FROM hotel.Hotel, hotel.Room where Hotel.city=? AND Room.num_guests>=? AND hotel_id=hotel";//order by last_name

			
			//String inDate="01-02-2019";//"04-04-2019";
			//String outDate = "02-02-2019";//"25-04-2019";
			//String sql = "SELECT DISTINCT Hotel.hotel_name, Room.room_id, Room.room_type, Room.num_guests, Room.room_num, Room.room_status, Room.price FROM hotel.Hotel, hotel.Room where Hotel.city=? AND Room.num_guests>=? AND hotel_id=hotel and room_id not in //(SELECT room_id FROM status where ('01-02-2019' > checkInDate and '01-02-2019' < checkOutDate) or ('02-02-2019' > checkInDate and '02-02-2019' < checkOutDate) or ('02-02-2019' = checkOutDate) or ('01-02-2019'= checkInDate) or ('01-02-2019'< checkInDate and '02-02-2019' > checkOutDate))";
			
			
			String sql = "SELECT DISTINCT Hotel.hotel_name, Room.room_id, Room.room_type, Room.num_guests, Room.room_num, Room.price FROM hotelSystem.Hotel, hotelSystem.Room where Hotel.city=? AND Room.num_guests>=? "
					+ "AND hotel_id=hotel and room_id not in"
					+ "(SELECT room_id FROM reservations  where ('"+ inDate + "' > checkInDate and '"+ inDate + "' < checkOutDate) or ('" +  outDate + "' > checkInDate and '"+ outDate + "' < checkOutDate) or ('"+ outDate + "' = checkOutDate) or ('" + inDate + "'= checkInDate) or ('"+ inDate + "'< checkInDate and '"+ outDate +"' > checkOutDate))";
			pstmt = myConn.prepareStatement(sql);
		        pstmt.setString(1, city);
		        pstmt.setString(2, guests);
		       
		        myRs = pstmt.executeQuery();

		        while (myRs.next()) {
					
		        	
		        
					// retrieve data from result set row
		        	 String hotelName = myRs.getString("Hotel.hotel_name");
					 int id = myRs.getInt("room_id");
					 String Type= myRs.getString("Room.room_type");
					 int price= myRs.getInt("Room.price");
					 String roomNumber= myRs.getString("Room.room_num");
					// String status= myRs.getString("Room.room_status");
					 int nguests= myRs.getInt("Room.num_guests");
					// create new student object
					Room tempRoom = new Room( id, hotelName, roomNumber,  price,  Type,  nguests);

					// add it to the list of students
					rooms.add(tempRoom);
				}//end while
		        return rooms;		
				
		}//end try
		finally {
			close (myConn, pstmt, myRs);
				checkInDate = inDate ;
			    checkOutDate = outDate;
			    System.out.println("DBUtil: List<Room> FindRooms: static checkInDate "+ checkInDate+ " static checkOutDate"+checkOutDate);
		}
		      
	}	
		
		       /* while (rs.next()) {
		            System.out.println("Error in FindRooms()");
		        }*/
		    
		    // Handle any errors that may have occurred.
		    
			
		//	myStmt = myConn.createStatement();

		//	myRs = myStmt.executeQuery(sql);

			// process result set
			
			
		


	public void addCustomer(Customer customer) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
	
		try {
			myConn = getConnection();
			
			//String sql = "insert into customer (Fname, Lname, phone, email, address ) values (?, ?, ?, ?, ?)";


			String sql = "insert into customer (Fname, Lname, phone, email, address_line1, address_line2, city , state, zip ) values (?, ?, ?, ?,?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, customer.getFirstName());
			myStmt.setString(2, customer.getLastName());
			myStmt.setString(3, customer.getPhone());
			myStmt.setString(4, customer.getEmail());
			myStmt.setString(5, customer.getAddress1());
			myStmt.setString(6, customer.getAddress2());
			myStmt.setString(7, customer.getCity());
			myStmt.setString(8, customer.getState());
			myStmt.setString(9, customer.getZip());
			//myStmt.setString(5, customer.getAddress());
			
			myStmt.execute();	
			
			
			//---to get recently added customer's id
			int autoIncKeyFromFunc = -1;
			
			 rs = myStmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			
			
			if (rs.next()) {
		        autoIncKeyFromFunc = rs.getInt(1);
		    } else {
		        // throw an exception from here
		    }

		    System.out.println("Key returned from " +
		                       "'SELECT LAST_INSERT_ID()': " +
		                       autoIncKeyFromFunc);
			
		    cust_id=autoIncKeyFromFunc;
			
			
			System.out.println("Customer "+customer.getFirstName()+" "+ customer.getLastName()+" "+ customer.getPhone()+" " +customer.getEmail()+ " "/*+customer.getAddress()*/ +"was added to DB.");
		}
		finally {
			close (myConn, myStmt);
			
		}
		
	}
	
	
	
	public void addPaymentInfo(PaymentInfo pInfo) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		try {
			myConn = getConnection();
			
			//String sql = "insert into customer (Fname, Lname, phone, email, address ) values (?, ?, ?, ?, ?)";


			String sql = "insert into BillingInfo (Fname, Lname, phone, add1, add2, city , state, zip ) values (?, ?, ?, ?,?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, pInfo.getFirstName());
			myStmt.setString(2, pInfo.getLastName());
			myStmt.setString(3, pInfo.getPhone());
		
			myStmt.setString(4, pInfo.getAddress1());
			myStmt.setString(5, pInfo.getAddress2());
			myStmt.setString(6, pInfo.getCity());
			myStmt.setString(7, pInfo.getState());
			myStmt.setString(8, pInfo.getZip());
			
			myStmt.execute();	
			
			//---to get recently added Bill's id
			int billID = -1;
			
			 rs = myStmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			if (rs.next()) {
				billID = rs.getInt(1);
		    } else {
		        // throw an exception from here
		    }

		    System.out.println("Key returned from " +
		                       "'SELECT LAST_INSERT_ID()': " +
		                       billID);
			
		    bill_id=billID;
			
			
			//add card info to transaction table 
			
		
		    String sqltrans = "insert into transaction ( card_holder, card_expire_date, card_number, cust_id ) values (?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sqltrans);

			//trans_id, total_price, card_holder, card_expire_date, card_number, cust_id
			
			String expirationDate= pInfo.getMonth()+"/"+pInfo.getYear();
			// set params
			
			//myStmt.setString(1, Double.toString(total));
			myStmt.setString(1, pInfo.getNameOnCard());
			myStmt.setString(2, expirationDate);
			myStmt.setString(3, pInfo.getCardNumber());
			myStmt.setInt(4, cust_id);
		
			
			
			myStmt.execute();	
			
			//---to get recently added trans's id
			int transID = -1;
			
			 rs = myStmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			if (rs.next()) {
				transID = rs.getInt(1);
		    } else {
		        // throw an exception from here
		    }

		    System.out.println("Key returned from " +
		                       "'SELECT LAST_INSERT_ID()': " +
		                       transID);
			
		    trans_id=transID;
			
		    
		//	System.out.println("Customer "+customer.getFirstName()+" "+ customer.getLastName()+" "+ customer.getPhone()+" " +customer.getEmail()+ " "/*+customer.getAddress()*/ +"was added to DB.");
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	
	
	public String addReservation(int room_id, RegistrationBean rbean) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		try {
			myConn = getConnection();
			
			//String sql = "insert into customer (Fname, Lname, phone, email, address ) values (?, ?, ?, ?, ?)";
//res_id, room_id, checkInDate, checkOutDate, total_price, cust_id, guests

			String sql = "insert into reservations (room_id, checkInDate, checkOutDate, total_price, cust_id, guests ) values (?, ?, ?, ?,?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, room_id);
			myStmt.setString(2, rbean.getcheckInDate());
			myStmt.setString(3, rbean.getcheckOutDate());
			//myStmt.setDouble(parameterIndex, x););
			myStmt.setDouble(4, rbean.getTotal());//(4, rbean.TotalPriceAfterTax(room.getPrice()));
			myStmt.setString(5, Integer.toString(cust_id));
			myStmt.setString(6, rbean.getGuests());
			
			
			myStmt.execute();	
			
			//---to get recently added Bill's id
			int resid = -1;
			
			 rs = myStmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			if (rs.next()) {
				resid = rs.getInt(1);
		    } else {
		        // throw an exception from here
		    }

		    System.out.println("Key returned from " +
		                       "'SELECT LAST_INSERT_ID()': " +
		                       resid);
			
		    reser_id=resid;
			
		    
		//	System.out.println("Customer "+customer.getFirstName()+" "+ customer.getLastName()+" "+ customer.getPhone()+" " +customer.getEmail()+ " "/*+customer.getAddress()*/ +"was added to DB.");
		}
		finally {
			close (myConn, myStmt);
		}
		return "confirmation";
	}
	
	
	
	///
	public Room getRoom(int roomId ) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			//String sql = "select * from Room where room_id=?";
//room_id, room_type, price, room_num, num_guests, hotel
			String sql = "select room_id, room_type, price, room_num, num_guests, hotel_name from hotelSystem.Room, hotelSystem.Hotel where room_id=?";
			myStmt = myConn.prepareStatement(sql);
			
			// set params
//roomId=1020;
			myStmt.setInt(1, roomId);
			
			myRs = myStmt.executeQuery();

			Room theRoom = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("room_id");
				 String hotelName = myRs.getString("hotel_name");
				 String roomNumber= myRs.getString("room_num");
				 int price= myRs.getInt("price");
				 String Type= myRs.getString("room_type");
				// String status= myRs.getString("room_status");
				 int nguests= myRs.getInt("Room.num_guests");

				 theRoom = new Room( id, hotelName, roomNumber,  price,  Type, nguests);
				 
				 System.out.println("DBUtil Room from getRoom: "+ id+ hotelName +  roomNumber + price +  Type + nguests);
			}
			else {
				throw new Exception("Could not find room id: " + roomId);
			}

			return theRoom;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	/*
	public void updateStudent(Room theStudent) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "update student "
						+ " set first_name=?, last_name=?, email=?"
						+ " where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public void deleteStudent(int studentId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from student where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, studentId);
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}		
	}	
	
	*/
	
	
	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	
	
	
	private void close(Connection theConn, Statement theStmt) {
		close(theConn, theStmt, null);
	}
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}	
	
	
	private void closeP(Connection theConn, PreparedStatement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}	
}
