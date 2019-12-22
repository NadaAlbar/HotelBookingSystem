package com.luv2code.jsf.jdbc;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped



public class DBController {


	private List<Hotel> hotels;
	private List<Room> rooms;
	private DBUtil dbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public DBController() throws Exception {
		rooms = new ArrayList<>();
		
		dbUtil = DBUtil.getInstance();
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}
	public String loadHotels() {

		logger.info("Loading Rooms");
		
		rooms.clear();

		try {
			
			// get all students from database
			hotels = dbUtil.getHotels();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading Rooms", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
		return "hotels_list";
	}
	
	
	public void loadRooms() {

		logger.info("Loading Rooms");
		
		rooms.clear();

		try {
			
			// get all students from database
			rooms = dbUtil.getRooms();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading Rooms", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
	
	
	
	public void resultRooms(String city, String guests , String checkInDate, String checkOutDate) {
		

		logger.info("Loading Rooms");
		
		rooms.clear();

		try {
			
			// get all students from database
			rooms = dbUtil.FindRooms(city, guests,checkInDate,checkOutDate );
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading Rooms", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
		
	public String addCustomer(Customer customer) {

		logger.info("Adding customer: " + customer);

		try {
			
			// add student to the database
			dbUtil.addCustomer(customer);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding customer", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "payment";//"list-students?faces-redirect=true";
	}
	
	
	
	public String addPaymentInfo(PaymentInfo pInfo) {

		logger.info("Adding PaymentInfo: " + pInfo);
		
		try {
			
			// add student to the database
			dbUtil.addPaymentInfo(pInfo);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding payment info", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "place_order";//"list-students?faces-redirect=true";
	}
	
public String loadRoom(int roomtId) {
		
		logger.info("loading Room: " + roomtId);
		
		try {
			// get student from database
			Room theRoom = dbUtil.getRoom(roomtId);
			
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("room", theRoom);	
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading room id:" + roomtId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "reservation-details.xhtml";//reserve the room form.
	}



public String addReservation(Room room, RegistrationBean rbean) {

	logger.info("Adding reservation information  room_id "+ room.getId() );
	
	try {
		
		// add student to the database
		dbUtil.addReservation( room.getId(),  rbean);
		
	} catch (Exception exc) {
		// send this to server logs
		logger.log(Level.SEVERE, "Error adding payment info", exc);
		
		// add error message for JSF page
		addErrorMessage(exc);

		return null;
	}
	
	return "confirmation.xhtml";//"list-students?faces-redirect=true";
}

	
	/*	
	
	public String updateStudent(Room theStudent) {

		logger.info("updating student: " + theStudent);
		
		try {
			
			// update student in the database
			dbUtil.updateStudent(theStudent);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating student: " + theStudent, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "list-students?faces-redirect=true";		
	}
	
	public String deleteStudent(int studentId) {

		logger.info("Deleting student id: " + studentId);
		
		try {

			// delete the student from the database
			dbUtil.deleteStudent(studentId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting student id: " + studentId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "list-students";	
	}	
	*/



	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	


}
