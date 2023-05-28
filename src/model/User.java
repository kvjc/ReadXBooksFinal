package model;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;


public abstract class User {

    private String name;
    private String id;
    private Calendar dateLink;
    private DateFormat formatter;
    

    public User(String name, String id, Calendar dateLink) {

        this.formatter = new SimpleDateFormat("dd/MM/yy");
        this.name = name;
        this.id = id;
        this.dateLink = dateLink;
        
        
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Calendar getDateLink() {
        return dateLink;
    }


    public void setDateLink(Calendar dateLink) {
        this.dateLink = dateLink;
    }


   	public String getFormatter() {
		return formatter.format(this.dateLink.getTime());
	}


    public void setFormatter(DateFormat formatter) {
        this.formatter = formatter;
    }


    private String printStringMatrix(int[][] numMatrix) {
		String print = "";
		for (int i = 0; i < numMatrix.length; i++) { // filas numbers.length
			for (int j = 0; j < numMatrix[0].length; j++) { // columnas numbers[0].length
				print += numMatrix[i][j] + " ";
			}
			print += "\n";
		}

		return print;
	}

    public String showMatrix(ArrayList<Product> userCart){

        String msg = "";

        String[][] newMatrix = new String[5][5];

        for(int i=0; i<5; i++){
            for(int j=0; i<5; i++){

            }
        }


        return msg;

    }



    
    


    
}
