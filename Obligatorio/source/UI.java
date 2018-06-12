package source;

import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		String opcion;
     do {
		opcion=pedirString("ingrese alguna de la siguientes opciones:");
		
		switch(opcion){
        case "1":
           
            break;
        case "2":
          
            break;
        case "3":
            
            break;
        case "4":
            
            break;
        }
     }while (!opcion.equals("0"));
		
		
		
    }
		

	
	
	
	
	public static String pedirString(String letra){
		
		
		
	    Scanner sc= new Scanner(System.in);
	    String pedido;
	    do{
	        System.out.println(letra);
	        System.out.println("1 - listar las 20 empresas con mayor cantidad de productos habilitados");
			System.out.println("2 - lists la 10 marcas por pais que tienen mas productos habilitados");
			System.out.println("3 - listar los 10 paises con mayor cantidad de productos habilitados");
			System.out.println("4 - listar las 20 clases por pais que tienen mayor cantidad de productos habilitados");
			System.out.println("0 - para salir(precione otra tecla para mostrara nuevamente el mensaje)");
	        pedido=sc.nextLine();
	        
	    } while(pedido.isEmpty());
	    
	    
	    return pedido;
	}
	
	

}
