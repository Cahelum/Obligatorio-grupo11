package source;

import nodoSimple.MyLinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class LeerCsv {

	    public static MyLinkedList<String> lectura () throws FileNotFoundException {
	    	MyLinkedList<String> lectura=new MyLinkedList<>();
	        Scanner scanner = new Scanner(new File("v_producto_real_updated.csv"));
	        scanner.useDelimiter(";");
	        while(scanner.hasNext()){
    			lectura.add(scanner.next());
	        }
	        scanner.close();
	        return lectura;
			
	    }
	    public static MyLinkedList<String> borrarComillas(MyLinkedList<String> lectura) {
	    	for(int i=0; i<lectura.size();i++) {
	    		
	    	}
			return lectura;
	    	
	    }

}

