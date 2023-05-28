package model;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Product {

    private String id;
	private String name;
	private double price;
    private int pagesNum;
    private String url;
    private int pagRead;
    private Calendar publishDate;
    private DateFormat formatter;
    

    public Product(String id, String name, double price, int pagesNum, String url, int pagRead) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.pagesNum = pagesNum;
        this.url = url;
        this.pagRead = pagRead;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(int pagesNum) {
        this.pagesNum = pagesNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPagRead() {
        return pagRead;
    }

    public void setPagRead(int pagRead) {
        this.pagRead = pagRead;
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
        return "\nId: " + id + "\nName: " + name + "\nPrice: " + price + "\nNumber of pages: " + pagesNum + "\nURL: " + url
                + "Number of read pages:" + pagRead + "Publish Date: " + getFormatter() +"\n";
    }

    

    

    

}
