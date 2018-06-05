package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class LeerCsv {

	    public static void lectura () throws FileNotFoundException {
	        Scanner scanner = new Scanner(new File("v_producto_real_updated.csv"));
	        scanner.useDelimiter(";");
	        while(scanner.hasNext()){
	            System.out.print(scanner.next()+"|");
	        }
	        scanner.close();
			
	    }
	    public static String borrarComillas(String stringConComillas) {
			return stringConComillas;
	    	
	    }

}

