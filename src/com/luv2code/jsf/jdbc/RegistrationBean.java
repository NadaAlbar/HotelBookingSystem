package com.luv2code.jsf.jdbc;


import javax.faces.bean.ManagedBean;


import java.time.LocalDate;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.FacesValidator;
import javax.faces.application.FacesMessage;

import java.time.temporal.ChronoUnit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import javax.faces.bean.SessionScoped;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean @SessionScoped // @FacesValidator 
public class RegistrationBean implements Serializable  {

	private String city;
	private String guests="1";
	/*
	private int id;
	
	*/
	private String checkInDate;
	private String checkOutDate;
	private double total; 
	
	 private static final long serialVersionUID = 1L;
	   
	
	public RegistrationBean() {
		
	}
	
	
	public String getCity() {
		
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getGuests() {
		return guests;
	}

	public void setGuests(String guests) {
		this.guests = guests;
	}
	
	/*
	public RegistrationBean( String firstName, String lastName,String email, String address, String city, String checkInDate, String checkOutDate, String guests) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.guests= guests;
		
		
		this.city= city;
		this.address = address;
		this.checkInDate=checkInDate;
		this.checkOutDate= checkOutDate;
		
				
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	*/
public String getcheckInDate() {
		return checkInDate;
	}

	public void setcheckInDate(String checkInDate) throws Exception {
		
		checkInDate=changeDateFormat(checkInDate);
		System.out.println("checkInDate "+ checkInDate);
		
		this.checkInDate = checkInDate;
	}
	
	public String getcheckOutDate() {
		return checkOutDate;
	}

	public void setcheckOutDate(String checkOutDate) throws Exception {
		
		
		checkOutDate= changeDateFormat(checkOutDate);
		
		System.out.println("checkOutDate "+ checkOutDate);
		
		
		
		this.checkOutDate = checkOutDate;
	}
	
	
	/*
	public String parseDate(Date temp) {
		DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");  
		String strDate = dateFormat.format(temp);  
		return strDate;
	}*/
	
	/*
	public void localeChanged(ValueChangeEvent e) { 
		  
		   //assign new value to country 
		 String  selectedCountry = e.getNewValue().toString(); 
		 System.out.println("passed Var: "+selectedCountry);
		} 
	*/
	
	
	public String changeDateFormat(String oldDateString ) throws Exception {
		 final String OLD_FORMAT = "yyyy-MM-dd";
	     final String NEW_FORMAT = "dd-MM-yyyy";

		// August 12, 2010
	     
		//String oldDateString = temp.replace("-", "/").replace(" ", "");
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = sdf.parse(oldDateString);
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		return newDateString;
		
	}
	
	
	public String changeDateFormatBack(String oldDateString ) throws Exception {
		 final String OLD_FORMAT = "dd-MM-yyyy";
	     final String NEW_FORMAT = "yyyy-MM-dd";

		// August 12, 2010
	     
		//String oldDateString = temp.replace("-", "/").replace(" ", "");
		String newDateString;

		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = sdf.parse(oldDateString);
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		return newDateString;
		
	}
	
	public long totalNights()throws Exception {
		
		
		//Parsing the date
        LocalDate dateBefore = LocalDate.parse(changeDateFormatBack(this.checkInDate));
        LocalDate dateAfter = LocalDate.parse( changeDateFormatBack(this.checkOutDate));

        //calculating number of days in between
        long nights = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        //displaying the number of days
        System.out.println(nights);
		
		 
		
		return nights;
	}
	
	
	public int TotalPrice(int price) throws Exception {
		long n = totalNights();
		int nights = (int) n;
		int total = nights* price;
		return total; 
	}
	
	
	public void setTotal(double total) {
		this.total= total; 
	}
	
	public double getTotal() {
		return total; 
	}
	
	
	public double 	TotalPriceAfterTax (int price ) throws Exception{
		
		
		int mNightsPrice = TotalPrice(price); 
		double totalAfterTax=0.0;
		double nprice = new Double (mNightsPrice);
		totalAfterTax = nprice * 1.06;
		
		
		
		
		NumberFormat formatter = new DecimalFormat("#0.00");    
		String totalStr= formatter.format(totalAfterTax);
		//System.out.println(formatter.format(4.0));
		totalAfterTax=Double.parseDouble(totalStr);
		
		setTotal(totalAfterTax);
		
		return totalAfterTax;
		
	}
	/*
	public void validateDates(FacesContext context, UIComponent comp,
			Object value) throws Exception{

		System.out.println("inside validate method");

		String mno = (String) value;

		
		String endDate=getcheckOutDate();//"1998-12-30";//end date
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
        System.out.println(endDate+"\t"+date1);

        String startDtate= getcheckInDate();//"1998-12-31";//start date
        Date date2= new SimpleDateFormat("dd-MM-yyyy").parse(startDtate);
        System.out.println(startDtate+"\t"+date2);

       
		
		if (date1.before(date2)) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"Invalid date");
			context.addMessage(comp.getClientId(context), message);

		}

	}*/
	
/*
	public String createRegistrationForm() {
		String output= "Registration Form Details [ Name: " + firstName + " " + lastName + " checkInDate "+checkInDate+", checkOutDate " + checkOutDate + ",email=" + email +" City "+city+", Number of Guests "+guests+"]";
		System.out.println(output);
		return output;
	}*/
}