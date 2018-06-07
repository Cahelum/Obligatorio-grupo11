package source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerCSV {
public static void lectura (Obligatorio obligatorio) {
    	
        String csvFile = "v_producto_real_updated.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        char csvQuote='"';
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {
            	
            	String[] datos = line.split(cvsSplitBy);
                String nombreProducto= datos[0].substring(1, datos[0].length()-1);
                System.out.print(nombreProducto+" nProducto ");
                String nombreDeFantasia= datos[1].substring(1, datos[1].length()-1);
                System.out.print(nombreDeFantasia+" nomFan ");
                String status=datos[20].substring(1, datos[20].length()-1);
                System.out.print(status+" status ");
                String idProduct=datos[2].substring(1, datos[2].length()-1);
                System.out.print(idProduct+" id ");
                String clase=datos[10].substring(1, datos[10].length()-1);
                System.out.print(clase+" clase ");
                String pais=datos[13].substring(1, datos[13].length()-1);
                System.out.print(pais+" pais ");
                String marca=datos[12].substring(1, datos[12].length()-1);
                System.out.print(marca+" marca ");
                String empresa=datos[5].substring(1, datos[5].length()-1);
                System.out.print(empresa+" empresa ");
                String ruc=datos[23].substring(1, datos[23].length()-1);
                System.out.print(ruc+" ruc ");
                String rubro=datos[3].substring(1, datos[3].length()-1);
                System.out.print(rubro+" rubro ");
                obligatorio.crearProductoSoloStrings (nombreProducto, nombreDeFantasia, status, idProduct, clase, pais, marca, empresa, ruc, rubro);
                System.out.println(" ");
                
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
