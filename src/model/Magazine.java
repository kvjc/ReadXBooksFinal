package model;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Magazine extends Product{

    private Category category;
    private String frecuency;
    private int activeSus;
    private DateFormat formatter;
    
	
	

    public Magazine(String id, String name, double price, int pagesNum, String url, int pagRead, Category category, String frecuency, int activeSus, Calendar publishDate) {
        super(id, name, price, pagesNum, url, pagRead);

        this.formatter = new SimpleDateFormat("dd/MM/yy");
        this.frecuency = frecuency;
        this.activeSus = activeSus;
        this.category = category;

        //TODO Auto-generated constructor stub
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public int getActiveSus() {
        return activeSus;
    }

    public void setActiveSus(int activeSus) {
        this.activeSus = activeSus;
    }


    

    public String getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(String frecuency) {
        this.frecuency = frecuency;
    }


    @Override
    public String toString() {
        return "\nId: " + this.getId() + "\nName: " + this.getName() + "\nPrice: " + this.getPrice() + "\nNumber of pages: " + this.getPagesNum() + "\nURL: " + this.getUrl()
		+ "\nNumber of read pages:" + this.getPagRead() + "\nCategory:" + category + "\nFrecuency=" + frecuency + "\nActive subscription: " + activeSus + "\n";
    }

    

    
  

    

    


    
}
