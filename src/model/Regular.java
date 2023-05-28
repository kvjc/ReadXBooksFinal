package model;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;


public class Regular extends User {

    private Product[]cart;


    public void testCases() {
		Calendar publishDate = new GregorianCalendar(2022, 11, 12);

		
		cart[0] = new Book("A1F", "A Game of Thrones", 20, 2, "Hola", Genre.CIENCIA, "abcd.com", 20, 1000,publishDate);
		

		
	}

    public Regular(String name, String id, Calendar dateLink) {
        super(name, id, dateLink);

        this.cart = new Product[7];
        testCases();
    }

    public String showCart(){

        String msg = "";

        for(int i = 0; i <cart.length; i++){

            if(cart[i]!=null){
                
                msg = cart[i].toString();
            }
        }

        return msg;
    }


    public void organizeRCart(){

        for (int i = 0; i < cart.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cart.length; j++) {
                if (cart[j] != null && cart[j].getPublishDate() != null && cart[j].getPublishDate().before(cart[minIndex].getPublishDate())) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Product temp = cart[i];
                cart[i] = cart[minIndex];
                cart[minIndex] = temp;
            }
        }
    }
   

    public String[][] fillMatrix() {

        organizeRCart();

    String[][] newMatrix = new String[5][5];
    int index = 0;

    for (int i = 0; i < newMatrix.length; i++) {
        for (int j = 0; j < newMatrix[i].length; j++) {
            if (index < cart.length) {
                Product temp = cart[index];
                if (temp != null) {
                    newMatrix[i][j] = temp.getId();
                }
                index++;
            }
        }
    }       
            
        return newMatrix;
    }

    public String showMatrix() {

		String[][] matrix = fillMatrix();

		String print = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == null) {

					print += "_______" + " ";
				} else {
					print += "  " + matrix[i][j] + "   ";
				}

			}
			print += "\n";
		}

		return print;
	}

    public Product[] getCart() {
        return cart;
    }

    public void setCart(Product[] cart) {
        this.cart = cart;
    }
    

    public int numberOfBooks(){

        int cantBooks = 0;

        for(int i = 0; i<cart.length; i++){

            if(cart[i] != null){
                cantBooks ++;
            }
        }
    
        return cantBooks;
    }

    public int numberOfMagazines(){

        int cantMagazine = 0;

        for(int i = 0; i<cart.length; i++){

            if(cart[i] != null){

                cantMagazine ++;
            }  
        
        }
        return cantMagazine;
    
    }

}
