package model;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Book extends Product {

	private int unitsSold;
	private Genre tGenre;
	private String bookReview;
	private Calendar publishDate;
	private DateFormat formatter;
	

	

	public Book(String id, String name, int pagesNum, int pagRead, String bookReview, Genre tGenre, String url, double price,  int unitSold, Calendar publishDate ) {
		super(id, name, price, pagesNum, url, pagRead);
		//TODO Auto-generated constructor stub

		this.formatter = new SimpleDateFormat("dd/MM/yy");
		this.unitsSold = unitSold;
		this.tGenre = tGenre;
		this.bookReview = bookReview;
		this.publishDate = publishDate;



	}


	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public Genre gettGenre() {
		return tGenre;
	}

	public void settGenre(Genre tGenre) {
		this.tGenre = tGenre;
	}

	public String getBookReview() {
		return bookReview;
	}

	public void setBookReview(String bookReview) {
		this.bookReview = bookReview;
	}


	public Calendar getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}

	public String getFormatter() {
		return formatter.format(this.publishDate.getTime());
	}

	public void setFormatter(DateFormat formatter) {
		this.formatter = formatter;
	}


	@Override
	public String toString() {
		return "\nId: " + this.getId() + "\nName: " + this.getName() + "\nPrice: " + this.getPrice() + "\nNumber of pages: " + this.getPagesNum() + "\nURL: " + this.getUrl()
		+ "\nNumber of read pages:" + this.getPagRead() + "\nPublish Date: " + getFormatter() +"\nUnitsSold: " + unitsSold + "\nGenre: " + tGenre + "\nBook Review: " + bookReview +  "\n";
	}

	



	

	



	

	
	

}
