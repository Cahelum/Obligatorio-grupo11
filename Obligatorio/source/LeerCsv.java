package source;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerCSV {
	
	public static void lectura () {
		
		Obligatorio obligatorio=new Obligatorio();
        String csvFile = "v_producto_real_updated.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            
            while ((line = br.readLine()) != null) {

            	String[] datos = line.split(cvsSplitBy);
                String nombreProducto= datos[0];
                String nombreDeFantasia= datos[1];
                String status=datos[20];
                String idProduct=datos[2];
                String clase=datos[10];
                String pais=datos[13];
                String marca=datos[12];
                String empresa=datos[5];
                String ruc=datos[23];
                String rubro=datos[3];
                obligatorio.crearProductoSoloStrings (nombreProducto, nombreDeFantasia, status, idProduct, clase, pais, marca, empresa, ruc, rubro);
                
                
                
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