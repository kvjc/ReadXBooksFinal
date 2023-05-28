package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller shop;

	public Executable() {

		reader = new Scanner(System.in);
		shop = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	public void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar productos bibliograficos");
			System.out.println("2. Consultar productos bibliograficos de la tienda");
			System.out.println("3. Borrar productos bibliograficos de la tienda");
			System.out.println("4. Modificar productos bibliograficos de la tienda");
			System.out.println("5. Registrar usuario");
			System.out.println("6. Consultar usuarios registrados");
			System.out.println("7. Comprar o suscribirse");
			System.out.println("8. Consultar compras usuario");
			System.out.println("9. Realizar una sesion de lectura");
			System.out.println("10. Reportes");
			System.out.println("11. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerStoreProducts();
				break;

			case 2:
				consultStoreProducts();
				break;

			case 3:
				deleteStoreProduct();
				break;

			case 4:
				modifyProduct();
				break;

			case 5:
				registerUser();
				break;

			case 6:
				showUser();
				break;

			case 7:
				addProductToUser();
				break;
			
			case 8: 
				showUserCart();
				break; 

			case 9:
				readSession();
				break;

			case 10:
				reports();
				break;
				
			
			case 11:
				flag = true;

			}

		}

	}

	private void registerStoreProducts(){

		System.out.println("Seleccione el tipo de producto que desea registrar \n1.Libro \n2.Revista");
		int choice = reader.nextInt();

		switch(choice){
			case 1:
				registerBook();
				break;

			case 2: 
				registerMagazine();
				break;
			default:
				System.out.println("Ingrese una posicion valida");
		}
	}

	private void consultStoreProducts(){

		reader.nextLine();

		System.out.println("Seleccione el tipo de producto que desea consultar \n1.Libro \n2.Revista");
		int choice = reader.nextInt();

		switch(choice){
			case 1: 
				showAllBookInfo();
				break;

			case 2: 
				showAllMagazineInfo();
				break;

			default:
				System.out.println("Opcion no valida");
		}

	}

	private void modifyProduct(){

		System.out.println("Seleccione el tipo de producto que desea Modificar \n1.Libro \n2.Revista");
		int choice = reader.nextInt();

		switch(choice){
			case 1:
				modifyBook();
				break;

			case 2: 
				modifyMagazine();
				break;
			default:
				System.out.println("Opcion no valida");	
		}
	}

	private void deleteStoreProduct(){

		System.out.println("Seleccione el tipo de producto que desea borrar \n1.Libro \n2.Revista");
		int choice = reader.nextInt();

		switch(choice){

			case 1: 
				deleteBook();
				break;

			case 2:

				deleteMAgazine();
				break;

			default:
				System.out.println("Opcion no valida");
		}

	}

	private void registerBook() {

		

		System.out.println("Digite a continuacion la informacion de un nuevo libro");
		reader.nextLine();

		System.out.println("Digite el identificador. Ej.: A1F");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el numero de paginas");
		int pagesNum = reader.nextInt();
		reader.nextLine();

		System.out.println("Digite la reseña del libro");
		String bookReview = reader.nextLine();

		System.out.println("A contunuacion ingrese la fecha de publicacion del libro");
		System.out.println("Digite el dia");
		int bDay = reader.nextInt();
		System.out.println("Digite el mes");
		int bMonth = reader.nextInt();
		System.out.println("Digite el año");
		int bYear = reader.nextInt();

		System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
		int genre = reader.nextInt();

		System.out.println("Ingrese el URL de la portada del libro");
		String url = reader.nextLine();

		System.out.println("Digite el valor de venta");
		double price = reader.nextDouble();

		int unitsSold = 0;
		int pagRead = 0;
		
		if (shop.registerBook(id, name, pagesNum, pagRead,  bookReview, genre, url, price, unitsSold, bDay, bMonth, bYear)) {

			System.out.println("Libro registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el libro");
		}
		
	}

	private void showAllBookInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = shop.getAllKBookInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

	private void showAllMagazineInfo(){

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = shop.getAllMagazineInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

	private void sellBook() {

		String query = shop.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {

			System.out.println("\nEste es el lisatdo de libros registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el libro a vender");

			int option = reader.nextInt();

			if (shop.sellBook(option - 1)) {

				System.out.println("\nTransaccion realizada exitosamente");

			} else {

				System.out.println("\nError en la transaccion");
			}
		}
	}

	private void registerMagazine(){

		System.out.println("Digite a continuacion la informacion de un nuevo libro");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite el identificador. Ej.: A1F");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el numero de paginas");
		int pagesNum = reader.nextInt();
		reader.nextLine();

		System.out.println("A contunuacion ingrese la fecha de publicacion de la revista");
		System.out.println("Digite el dia");
		int mDay = reader.nextInt();
		System.out.println("Digite el mes");
		int mMonth = reader.nextInt();
		System.out.println("Digite el año");
		int mYear = reader.nextInt();

		System.out.println("Ingrese la categoria de la revista \n1.Variedades \n2.Diseño \n3.Cientifica");
		int category = reader.nextInt();

		System.out.println("Ingrese el URL de la portada de la revista");
		String url = reader.nextLine();

		System.out.println("Ingrese el valor de la suscripcion");
		double mvalue = reader.nextDouble();

		System.out.println("Ingrese la periodicidad de emision");
		String frecuency = reader.nextLine();

		int activeSus = 0;
		int mReadPag = 0;

		if (shop.registerMagazine(id, name, mvalue, url, category, pagesNum, activeSus, mReadPag, mYear, mMonth, mDay, frecuency)) {

			System.out.println("Revista registrada exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar la revista");
		}

	}

	private void showMagazineinfo(){

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = shop.getMagazineInfo();

		if (query.equals("")) {

			System.out.println("No hay revistas registrados");
		} else {
			System.out.println(query);
		}

	}

	private void deleteBook(){

		System.out.println("Esta es la informacion registrada en el sistema");

		String queryBook = shop.getAllKBookInfo();

		if (queryBook.equals("")) {

			System.out.println("No hay libros registrados");

		} else {

			System.out.println(queryBook);
			reader.nextLine();
			System.out.println("Escriba el Id del libro que desea borrar");
			String bId = reader.nextLine();

			System.out.println(shop.deleteBook(bId));
			

		}		
	}

	private void deleteMAgazine(){
		System.out.println("Esta es la informacion registrada en el sistema");

		String queryMagazine = shop.getMagazineInfo();

		if (queryMagazine.equals("")) {

			System.out.println("No hay revistas registradas");

		} else {

			System.out.println(queryMagazine);
			System.out.println("Seleccione la revista que desea borrar");
			int position = reader.nextInt();

			System.out.println(shop.deleteMAgazine(position-1));

		}		
	}

	private void modifyMagazine(){

		System.out.println("Esta es la informacion registrada en el sistema");

		String queryMagazine = shop.getAllMagazineInfo();

		if (queryMagazine.equals("")) {

			System.out.println("No hay revistas registradas");

		} else {

			System.out.println(queryMagazine);
			reader.nextLine();

			System.out.println("Escriba el ID de la revista que desea modificar");
			String mId = reader.nextLine();

			
			System.out.println("Seleccione el atributo que desea modificar \n1.Id \n2.Price \n3.URL \n4.Frecuency");
			int bOption = reader.nextInt();

			reader.nextLine();
			System.out.println("Escriba la modificacion");
			String mod = reader.nextLine();

			if(shop.modifyMagazine(mId, bOption, mod)){
				System.out.println("Modificacion exitosa");
			}else {
				System.out.println("Error, la revista no se pudo modificar");
			}

		}
		
	}

	private void modifyBook(){

		System.out.println("Esta es la informacion registrada en el sistema");

		reader.nextLine();

		String queryBook = shop.getAllKBookInfo();

		if (queryBook.equals("")) {

			System.out.println("No hay libros registrados");

		} else {

			System.out.println(queryBook);

			
			System.out.println("Escriba el ID del libro que desea modificar");
			String bId = reader.nextLine();

			reader.nextLine();

			System.out.println("Seleccione el atributo que desea modificar \n1.Id \n2.Price \n3.URL \n4.Book Review");
			int bOption = reader.nextInt();

			System.out.println("Escriba la modificacion");
			String bMod = reader.nextLine();

			if(shop.modifyBook(bId, bOption, bMod)){
				System.out.println("Modificacion exitosa");
			}else {
				System.out.println("Error, el libro no se pudo modificar");
			}

		}		
	}

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();


		System.out.println("Digite el tipo de usuario \n1.Regular \n2.Premium");
		int userType = reader.nextInt();

		if (shop.registerUser(id, name, userType)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}

	}
 
	private void showUser(){

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = shop.getUserList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

	private void addProductToUser(){

		String productCode = reader.nextLine();

		showUser();
		System.out.println("Seleccione el usuario");
		int userPosition = reader.nextInt();

		reader.nextLine();
		

		System.out.println("Seleccione el tipo de producto \n1.Lirbro \n2.Revista");
		int productType = reader.nextInt();

		if(productType == 1){

			showAllBookInfo();
			reader.nextLine();
			
			System.out.println("Escriba el Codigo del libro");
			productCode = reader.nextLine();

		}else if(productType == 2){

			showAllMagazineInfo();
			reader.nextLine();
			System.out.println("Escriba el Codigo de la revista");
			productCode = reader.nextLine();
			
		}

		System.out.println(shop.addProductToUser(userPosition-1, productType, productCode));

		
	}

	public void showUserCart(){

		showUser();

		System.out.println("Seleccione el usuario a consultar");
		int userPosition = reader.nextInt();

		System.out.println("La informacion registrada en el usuario es" + shop.getUserCart(userPosition-1));
	}

	public void readSession(){

		showUser();
		System.out.println("Seleccione el usuario");
		int userPosition = reader.nextInt();

		
		boolean flagB = false;

		while(!flagB){

			System.out.println(shop.getUserCart(userPosition-1));
			
			reader.nextLine();

			System.out.println("Escriba el id del libro que desea leer o Escriba E para salir");
			String productId = reader.nextLine();

			String option = "s";

			boolean flag = false;

			if(productId.equalsIgnoreCase("E")){
				flagB = true;
			}

			while(!flag){

				System.out.println(shop.readingSession(userPosition-1, productId, option));

				System.out.println("\nDigite A para ir a la anterior pagina \nDigite S para ir a la siguiente pagina \nDigite B para volver a la biblioteca \nEscriba E para salir");
				option = reader.nextLine();

				if(option.equalsIgnoreCase("B")){
					flag = false;
				}

				if(productId.equalsIgnoreCase("E") || option.equalsIgnoreCase("E")){
					flagB = true;
					break;
				}
			}

		}

		
	}

	public void reports(){

		System.out.println("Digite la opcion del reporte que desea generar '\n1.Acumulado total de paginas leidas \n2.Genero y categoria mas leida \n3.Top 5 \n4.Genero mas vendido \n5.Categoria mas vendida \n6.Todos");
		int option = reader.nextInt();

		switch(option){

			case 1: 
				System.out.println(shop.totalPagesRead());
				break;
			
			case 2:
				System.out.println(shop.totalPagesReadPerType());
				break;
			case 3:
				System.out.println(shop.getTransactions());
				break;
			case 4:
				System.out.println(shop.reportGenre());
				break;
			case 5:
				System.out.println(shop.reportCategory());
				break;
			case 6:
				System.out.println(shop.totalPagesRead());
				System.out.println(shop.totalPagesReadPerType());
				System.out.println(shop.totalPagesRead());
				System.out.println(shop.reportGenre());
				System.out.println(shop.reportCategory());
		}
		
		
	}


}