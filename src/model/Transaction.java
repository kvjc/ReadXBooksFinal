package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;

public class Transaction {

	private Calendar date;
	private double purchaseValue;
	private String bName;
	private DateFormat formatter;
	
	

	public Transaction(double purchaseValue, String bName){

		this.date = Calendar.getInstance();
		this.purchaseValue = purchaseValue;
		this.bName = bName;

			
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getDateFormatter() throws ParseException{
		return formatter.format(this.date.getTime());
	}

	public void setDateFormatter(DateFormat formatter) {
		this.formatter = formatter;
	}

	


}
