package model;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;


public class Premium extends User{

    private ArrayList<Product>pCart;
    private ArrayList<String[][]> stringMatrixes;


    public Premium(String name, String id, Calendar dateLink) {
        super(name, id, dateLink);
        this.pCart = new ArrayList<Product>();
        stringMatrixes = new ArrayList<String[][]>();
        
        
    }

    public void testCases() {
		Calendar publishDate = new GregorianCalendar(2022, 11, 12);

		pCart.add(new Magazine("A5F", "Vogue", 100, 100, "abcd.com", 0, Category.CIENTIFICA, "Mensual", 0, publishDate));
		
	}

    public ArrayList<Product> getpCart() {
        return pCart;
    }

    public void setpCart(ArrayList<Product> pCart) {
        this.pCart = pCart;
    }

    public String showpCart(){

        String msg = "";

        for(int i = 0; i<pCart.size(); i++){

            msg += "\n" + pCart.get(i).toString();

        }

        return msg;
    }
    
    public void organizePCart(){

        for (int i = 0; i < pCart.size(); i++) {
            for (int j = i + 1; j < pCart.size(); j++) {
                Product product1 = pCart.get(i);
                Product product2 = pCart.get(j);
                
                Calendar publishDate1 = product1.getPublishDate();
                Calendar publishDate2 = product2.getPublishDate();
        
                if (publishDate1 != null && publishDate2 != null && publishDate2.before(publishDate1)) {
                    pCart.set(i, product2);
                    pCart.set(j, product1);
                }
            }
        }
    }

    public String[][] fillMatrix() {

        organizePCart();

        String[][] newMatrix = new String[5][5];

        for(int i = 0; i<newMatrix.length; i++){

            for(int j = 0; j<newMatrix.length; j++){

                if((i*newMatrix.length) + j < pCart.size()){

                    Product temp = pCart.get(i*newMatrix.length+j);

                    newMatrix[i][j] = temp.getId();
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



    
    
    

    
}
