package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.text.Position;

import java.util.ArrayList;


public class Controller {

	private ArrayList<Product>products;
	private ArrayList<User>users;
	private ArrayList<Product> transaction;
	
	private Transaction[] transactions;

	public Controller() {

		this.products= new ArrayList<Product>();
		this.users = new ArrayList<User>();
		this.transaction = new ArrayList<Product>();

		transactions = new Transaction[1000];
		testCases();

	}

	public void testCases() {
		Calendar publishDate = new GregorianCalendar(2022, 11, 12);
		Calendar publishDate2 = new GregorianCalendar(2020, 06, 12);
		Calendar publishDate3 = new GregorianCalendar(2015, 06, 12);

		products.add(new Book("A1F", "A Game of Thrones", 20, 100, "Hola", Genre.CIENCIA, "abcd.com", 20, 0,publishDate));
		products.add(new Book("A1A", "Dune", 10, 50, "Hola", Genre.CIENCIA, "abcd.com", 20, 0,publishDate2));
		products.add(new Magazine("A5F", "Vogue", 100, 100, "abcd.com", 10, Category.CIENTIFICA, "Mensual", 0, publishDate3));

		users.add(new Regular("Samuel", "134", publishDate));
		users.add(new Premium("Isa", "456", publishDate2));

		
	}

	

	public boolean registerBook(String id, String name, int pagesNum, int pagRead, String bookReview, int genre, String url, double price, int unitsSold, int bday, int bMonth, int bYear) {

		Genre tGenre = Genre.CIENCIA;
		if(genre == 1){
			tGenre = Genre.CIENCIA;
		}else if (genre == 2){
			tGenre = Genre.FANTASIA;
		}else if (genre == 3){
			tGenre = Genre.FICCION;
		}else{
			tGenre = Genre.NOVELA_HISTORICA;
		}

		Calendar publishDate = new GregorianCalendar(bYear, bMonth-1, bday);

		Book newBook = new Book(id, name, pagesNum, pagRead, bookReview, tGenre, url, price, unitsSold, publishDate);

		return products.add(newBook);

	}
	
	public String getBookList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Book){

				msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();

			}

		}

		return msg;

	}

	public String getProductInfo(){
		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();

		}

		return msg;

	}

	public String getTransactions(){

		String msg = "";

		for (int i = 0; i < transaction.size(); i++) {

			msg += "\n" + (i + 1) + ". " + transaction.get(i).getName() + " - " + transaction.get(i).getPrice();

		}

		return msg;

	}

	public boolean sellBook(int i) {

		Book book = ((Book)products.get(i));

		book.setUnitsSold(book.getUnitsSold()+1);

		Transaction newTransaction = new Transaction(products.get(i).getPrice(), products.get(i).getName());
		
		for (int n = 0; n < transactions.length; n++){

			if(transactions[n] == null){
				transactions[n] = newTransaction;
				return true;
			}

		}

		return false;
	
	}

	public String getAllKBookInfo() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Book) {

				Book book = ((Book)products.get(i));

				msg += "\n" + (i + 1) + book.toString();
 
			}

		}
		return msg;
	}

	public String getAllMagazineInfo(){

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Magazine) {

				msg += "\n" + (i + 1)  + ((Magazine)(products.get(i))).toString();
 
			}

		}

		return msg;
	}

	public boolean registerMagazine(String id, String name, double price, String url, int category, int pagesNum, int activeSus, int mReadPag, int mYear, int mMonth, int mday, String frecuency){

		Category cCategory = Category.CIENTIFICA;

		if(category==1){
			cCategory = Category.VARIEDADES;
		}else if(category==2){
			cCategory = Category.DISEÑO;
		}else if(category==3){
			cCategory = Category.CIENTIFICA;
		}

		Calendar publishDate = new GregorianCalendar(mYear, mMonth-1, mday);

		Magazine newMagazine = new Magazine(id, name, price, pagesNum, url, mReadPag, cCategory, frecuency, activeSus, publishDate);

		return products.add(newMagazine); 
	}

	public String getMagazineInfo(){

		String msg = "";
		
		for(int i = 0; i<products.size(); i++){

			if(products.get(i) instanceof Magazine){

				msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();
			}
				
		}

		return msg;

	}

	public String deleteBook(String bId){

		for(int i = 0; i<products.size(); i++){

			if(products.get(i).getId().equalsIgnoreCase(bId)){

				if(products.get(i)instanceof Book){

					products.remove(i);

					return "El libro ha sido borrado correctamente";
				}
			}
		}

		
		return "Error, no se pudo borrar el libro";
	}

	public String deleteMAgazine(int position){

		products.remove(position);

		return "La revista ha sido borrada correctamente";
	}

	public String deleteProduct(int position){

		products.remove(position);

		return "La revista ha sido borrada correctamente";

	}

	public boolean modifyBook(String bId, int bOption, String bMod){

		for(int i=0; i < products.size(); i++){

			if(products.get(i).getId().equalsIgnoreCase(bId)){

				switch(bOption){
					case 1: 
						products.get(i).setId(bMod);
						
						return true;
		
					case 2: 
						double price = Double.parseDouble(bMod);
						products.get(i).setPrice(price);
						
						return true;
					
					case 3: 
						products.get(i).setUrl(bMod);
						
						return true;
					
					case 4: 
						((Book)(products.get(i))).setBookReview(bMod);
						
						return true;
				}
	

			}

			

		}

		

		return false;

	}

	public boolean modifyMagazine(String mID, int mOption, String mod){

		for(int i = 0; i<products.size(); i++){

			if(products.get(i).getId().equalsIgnoreCase(mID)){

				if(products.get(i) instanceof Magazine){

					switch(mOption){
						case 1: 
							products.get(i).setId(mod);
							return true;
			
						case 2: 
							double price = Double.parseDouble(mod);
							products.get(i).setPrice(price);
							return true;
						
						case 3: 
							products.get(i).setUrl(mod);
							return true;
						
						case 4: 
						
							((Magazine)(products.get(i))).setFrecuency(mod);
							return true;
					}

				}
			}


		}

		

		return false;
	}

	public boolean registerUser(String id, String name, int userType) {
		
		if(userType==1){

			Calendar dateLinkR = Calendar.getInstance();
			return users.add(new Regular(name, id, dateLinkR));

		}else{
			
			Calendar dateLinkP = Calendar.getInstance();
			return users.add(new Premium(name, id, dateLinkP));

		}
			
	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {
			
			msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
	
		}

		return msg;

	}
	

	public String getUserCart(int userPosition){

		String msg = "";

		if(users.get(userPosition) instanceof Regular){

			Regular regularUser = (Regular) users.get(userPosition);
			msg = regularUser.showMatrix();

		}else if(users.get(userPosition) instanceof Premium){

			msg = ((Premium)(users.get(userPosition))).showMatrix();
		}

		

		return msg;

	}

	public String addBookToRegularUser(int userPosition, String productCode) {
		String msg = "";
	
		if (users.get(userPosition) instanceof Regular) {

			Regular regularUser = (Regular) users.get(userPosition);
	
			boolean bookAdded = false; 
	
			for (int i = 0; i < regularUser.getCart().length && !bookAdded && regularUser.numberOfBooks()<5; i++) {

				if (regularUser.getCart()[i] == null) {

					for (int x = 0; x < products.size() && !bookAdded; x++) {

						if (products.get(x).getId().equalsIgnoreCase(productCode)) {

							if (products.get(x) instanceof Book) {

								Book newBook = (Book) products.get(x);

								regularUser.getCart()[i] = newBook;
								newBook.setUnitsSold(newBook.getUnitsSold() + 1);
								transaction.add(newBook);

								bookAdded = true; 

								msg = "Book added to cart";
							}
						}
					}
				}
			}
		}

	
		return msg;

	}

	public String addMagazineToRegularUser(int userPosition, String productCode) {
		String msg = "";
	
		if (users.get(userPosition) instanceof Regular) {

			Regular regularUser = (Regular) users.get(userPosition);
	
			boolean magazineAdded = false; 
	
			for (int i = 0; i < regularUser.getCart().length && !magazineAdded && regularUser.numberOfMagazines()<2; i++) {

				if (regularUser.getCart()[i] == null) {

					for (int x = 0; x < products.size() && !magazineAdded; x++) {

						if (products.get(x).getId().equalsIgnoreCase(productCode)) {

							if (products.get(x) instanceof Magazine) {

								Magazine newMagazine = (Magazine) products.get(x);

								regularUser.getCart()[i] = newMagazine;
								newMagazine.setActiveSus(newMagazine.getActiveSus()+1);
								transaction.add(newMagazine);

								magazineAdded = true; 

								msg = "Book added to cart";
							}
						}
					}
				}
			}
		}
	
		return msg;

	}

	public String addBookToPremiumUser(int userPosition, String productCode) {
		String msg = "";
	
		if (users.get(userPosition) instanceof Premium) {

			Premium premiumUser = (Premium) users.get(userPosition);
	
			boolean bookAdded = false; 

				for (int x = 0; x < products.size() && !bookAdded; x++) {

					if (products.get(x).getId().equalsIgnoreCase(productCode)) {

						if (products.get(x) instanceof Book) {

							Book newBook = (Book) products.get(x);

							premiumUser.getpCart().add(newBook);
							newBook.setUnitsSold(newBook.getUnitsSold() + 1);
							transaction.add(newBook);

							bookAdded = true; 

							msg = "Book added to cart";
						}
					}
				}
				
			}
		
	
		return msg;

	}

	public String addMagazineToPremiumUser(int userPosition, String productCode) {
		String msg = "";
	
		if (users.get(userPosition) instanceof Premium) {

			Premium premiumUser = (Premium) users.get(userPosition);
	
			boolean bookAdded = false; 
	
					for (int x = 0; x < products.size() && !bookAdded; x++) {

						if (products.get(x).getId().equalsIgnoreCase(productCode)) {

							if (products.get(x) instanceof Magazine) {

								Magazine newMagazine = (Magazine)products.get(x);

								premiumUser.getpCart().add(newMagazine);
								newMagazine.setActiveSus(newMagazine.getActiveSus() +1);
								transaction.add(newMagazine);

								bookAdded = true; 

								msg = "Book added to cart";
							}
						}
					}
				
			}
		
	
		return msg;

	}

	public String addProductToUser(int userPosition, int productType, String id ){

		String msg = "";

		if(users.get(userPosition) instanceof Regular){

			switch(productType){
				case 1: 
					addBookToRegularUser(userPosition, id);
					msg = "El libro ha sido comprado correctamente";
					break;
				case 2:
					addMagazineToRegularUser(userPosition, id);
					msg = "La revista ha sido comprada correctamente";
					break;
			}
		
		}else if(users.get(userPosition) instanceof Premium){

			switch(productType){
				case 1: 
					addBookToPremiumUser(userPosition, id);
					msg = "El libro ha sido comprado correctamente";
					break;
				case 2:
					addMagazineToPremiumUser(userPosition, id);
					msg = "La revista ha sido comprada correctamente";
					break;
			}

		}else{
			msg = "Error, no se pudo ejecutar la transaccion";

		}

		return msg;

	}


	public String readingSessionRegular(int userPosition, String productId, String option) {
		String msg = "";
	
		if (users.get(userPosition) instanceof Regular) {
			Regular regularUser = (Regular) users.get(userPosition);
	
			for (int i = 0; i < regularUser.getCart().length; i++) {
				if (regularUser.getCart()[i] != null && regularUser.getCart()[i].getId().equalsIgnoreCase(productId)) {

					if (option.equalsIgnoreCase("a")) {
						regularUser.getCart()[i].setPagRead(regularUser.getCart()[i].getPagRead() - 1);
						products.get(i).setPagRead(+1);
	
					} else if (option.equalsIgnoreCase("s")) {
						regularUser.getCart()[i].setPagRead(regularUser.getCart()[i].getPagRead() + 1);
						products.get(i).setPagRead(+1);
					}
					
					msg += "\nSesion de lectura en proceso";
					msg += "\n" + "Leyendo:" + regularUser.getCart()[i].getName();
					msg += "\n" + "Leyendo pagina " + regularUser.getCart()[i].getPagRead() + " de " + regularUser.getCart()[i].getPagesNum();
	
					
				}
			}
		} else {
			msg = "Error: The user is not a regular user";
		}
		return msg;
	}

	public String readingSessionPremium(int userPosition, String productId, String option) {
		String msg = "";

    if (users.get(userPosition) instanceof Premium) {
        Premium premiumUser = (Premium) users.get(userPosition);

        for (int i = 0; i < premiumUser.getpCart().size(); i++) {
            if (premiumUser.getpCart().get(i) != null && premiumUser.getpCart().get(i).getId().equalsIgnoreCase(productId)) {
                if (option.equalsIgnoreCase("a")) {
                    premiumUser.getpCart().get(i).setPagRead(premiumUser.getpCart().get(i).getPagRead() - 1);
                    products.get(i).setPagRead(products.get(i).getPagRead() + 1);
                } else if (option.equalsIgnoreCase("s")) {
                    premiumUser.getpCart().get(i).setPagRead(premiumUser.getpCart().get(i).getPagRead() + 1);
                    products.get(i).setPagRead(products.get(i).getPagRead() + 1);
                }

                msg += "\nSesión de lectura en proceso";
                msg += "\nLeyendo: " + premiumUser.getpCart().get(i).getName();
                msg += "\nLeyendo página " + premiumUser.getpCart().get(i).getPagRead() + " de " + premiumUser.getpCart().get(i).getPagesNum();
                break;
            }
        }
    } else {
        msg = "Error: The user is not a premium user";
    }

    return msg;
}


	

	public int getlength(int userPosition){

		Regular regularUser = (Regular) users.get(userPosition);


		return regularUser.getCart().length;
		
	}


	public String readingSession(int userPosition, String productId, String option){

		String msg = "";

		if(users.get(userPosition) instanceof Regular){

			msg = readingSessionRegular(userPosition, productId, option);
		
		}else if(users.get(userPosition) instanceof Premium){

			msg = readingSessionPremium(userPosition, productId, option);

		}else{
			msg = "Error, no se pudo ejecutar la transaccion";

		}
		
		return msg; 
	}

	public String totalPagesRead(){

		String msg = "\nAcumulado total de paginas leidas";
		int totalPagesReadB = 0;
		int totalPagesReadM = 0;

		for(int i = 0; i<products.size(); i++){

			if(products.get(i) instanceof Book){

				totalPagesReadB += products.get(i).getPagRead();

			}else if(products.get(i) instanceof Magazine){

				totalPagesReadM += products.get(i).getPagRead();

			}

		}

		msg = "\nAcumulado total de paginas \nLibros: "+ totalPagesReadB + "\nRevistas: " + totalPagesReadM;

		return msg;
	}

	public String totalPagesReadPerType(){

		String msg = "\nCategoria y genero mas leidos";
		
		int[] bookPages = new int[4];
		int[] magazinePages = new int[3];
		
		for(int i = 0; i<products.size(); i++){

			if(products.get(i) instanceof Book){

				Book book = (Book) products.get(i);

				if(book.gettGenre() == Genre.CIENCIA){
					bookPages[0] += products.get(i).getPagRead();
				}else if(book.gettGenre() == Genre.FICCION){
					bookPages[1] += products.get(i).getPagRead();
				}else if(book.gettGenre() == Genre.FANTASIA){
					bookPages[2]  += products.get(i).getPagRead();
				}else if(book.gettGenre() == Genre.NOVELA_HISTORICA){
					bookPages[3] += products.get(i).getPagRead();
				}

			}else if(products.get(i) instanceof Magazine){

				Magazine magazine = (Magazine) products.get(i);

				if(magazine.getCategory() == Category.VARIEDADES){
					magazinePages[0] += products.get(i).getPagRead();
				}else if(magazine.getCategory() == Category.DISEÑO){
					magazinePages[1] += products.get(i).getPagRead();
				}else if(magazine.getCategory() == Category.CIENTIFICA){
					magazinePages[2] += products.get(i).getPagRead();
				}
				
			}
		}

		int bMax = bookPages[0];
		int mMax = magazinePages[0];
		int maxIndexB = 0;
		int maxIndexM = 0;

		for (int i = 1; i < bookPages.length; i++) {
			if (bookPages[i] > bMax) {
				bMax = bookPages[i];
				maxIndexB = i;
			}
		}

		for (int i = 1; i < magazinePages.length; i++) {
			if (magazinePages[i] > mMax) {
				mMax = magazinePages[i];
				maxIndexM = i;
			}
		}

		switch(maxIndexB){
			case 0: 
				msg = "El genero con la mayor cantidad de paginas leidas es: Ciencia con "+bookPages[0] +" paginas"; 
				break;
			case 1: 
				msg = "El genero con la mayor cantidad de paginas leidas es: Ficcion con "+bookPages[1] +" paginas"; 
				break;
			case 2:
				msg = "El genero con la mayor cantidad de paginas leidas es: Fantasia con "+bookPages[2] +" paginas"; 
				break;
			case 3:
				msg = "El genero con la mayor cantidad de paginas leidas es: Novela historica con "+bookPages[3] +" paginas"; 
				break;
		}

		switch(maxIndexM){
			case 0: 
				msg += "\nLa categoria con la mayor cantidad de paginas leidas es: Variedades con "+magazinePages[0] +" paginas"; 
				break;
			case 1: 
				msg += "\nLa categoria con la mayor cantidad de paginas leidas es: Diseño con "+magazinePages[1] +" paginas"; 
				break;
			case 2:
				msg += "\nLa categoria con la mayor cantidad de paginas leidas es: Cientifica con "+magazinePages[2] +" paginas"; 
				break;
			
		}

		return msg;
	}

	public String reportGenre(){

		String msg = "\nReporte libros vendidos";

		int[] genreCant = new int[4];
		int[] sales = new int[4];
		
		for(int i = 0; i<transaction.size(); i++){

			if(transaction.get(i) instanceof Book){

				Book book = (Book) products.get(i);

				if(book.gettGenre() == Genre.CIENCIA){
					genreCant[0] += book.getUnitsSold();
					sales[0] += book.getPrice();
					msg += "\nCiencia \nNumero de libros vendidos: " + genreCant[0] + "\nValor total de ventas: " + sales[0] + "\n";

				}else if(book.gettGenre() == Genre.FICCION){
					genreCant[1] += book.getUnitsSold();
					sales[1] += book.getPrice();
					msg += "\nFiccion \nNumero de libros vendidos: " + genreCant[1] + "\nValor total de ventas: " + sales[1] + "\n";

				}else if(book.gettGenre() == Genre.FANTASIA){
					genreCant[2]  += book.getUnitsSold();
					sales[2] += book.getPrice();
					msg += "\nFantasia \nNumero de libros vendidos: " + genreCant[2] + "\nValor total de ventas: " + sales[2] + "\n";

				}else if(book.gettGenre() == Genre.NOVELA_HISTORICA){
					genreCant[3] += book.getUnitsSold();
					sales[3] += book.getPrice();
					msg += "\nNovela historica \nNumero de libros vendidos: " + genreCant[3] + "\nValor total de ventas: " + sales[3] + "\n";
				}

			}
		}
		
		return msg;
	}

	public String reportCategory(){
		
		String msg = "\nReporte suscripciones revistas";

		int[] catCant = new int[4];
		int[] sales = new int[4];

		for(int i=0; i<transaction.size(); i++){

			if(products.get(i) instanceof Magazine){

				Magazine magazine = (Magazine) products.get(i);

				if(magazine.getCategory() == Category.VARIEDADES){
					catCant[0] += magazine.getActiveSus();
					sales[0] += magazine.getPrice();
					msg += "\nVariedades \nSuscripciones activas: " +catCant[0] + "\nValor total: " + sales[0] + "\n";

				}else if(magazine.getCategory() == Category.DISEÑO){
					catCant[1] += magazine.getActiveSus();
					sales[1] += magazine.getPrice();
					msg += "\nDiseño \nSuscripciones activas: " +catCant[1] + "\nValor total: " + sales[1] + "\n";

				}else if(magazine.getCategory() == Category.CIENTIFICA){
					catCant[2] += magazine.getActiveSus();
					sales[2] += magazine.getPrice();
					msg += "\nCientifica \nSuscripciones activas: " +catCant[2] + "\nValor total: " + sales[2] + "\n";
					
				}
				
			}
		}

		return msg;

	}
}







	

	
 
	









