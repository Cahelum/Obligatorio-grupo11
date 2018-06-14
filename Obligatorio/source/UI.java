package source;

import java.io.IOException;
import source.UIUtilities;

public class UI {

	public static void main(String[] args) {
		Obligatorio obligatorio = new Obligatorio();

		String start = "Hola Daniel";
		boolean reporte = false;
		while (!start.equals("start")) {
			start = UIUtilities.pedirString("Escriba 'start' para cargar archivo CSV básico");
		}
		long startTime = System.nanoTime(); 
		System.out.println("Cargando archivo CSV, espere por favor");
		try {
			obligatorio.lectura("v_producto_real_updated.csv");
		} catch (IOException e) {
			System.out.println("Error en la lectura, consulte con el administrador del sistema para solucionarlo.");
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println("Demoró "+duration/1000000+" milisegundos");
		while (true) {
			reporte = UIUtilities.siONo("¿Desea realizar un reporte? (Responda con 'si' o 'no')");
			if (reporte) {
				boolean eleccionReporte = false;
				while (eleccionReporte == false) {
					eleccionReporte=obligatorio.elegirReporte();
				}
			} else {
				boolean cargarCSV = UIUtilities.siONo("¿Desea cargar otro archivo CSV del mismo formato? (Responda con 'si' o 'no')");
				boolean funcionaCarga=false;
				while (cargarCSV&!funcionaCarga) {
					String file = UIUtilities
							.pedirString("Escriba la dirección del archivo CSV (Favor de verificar compatibilidad)");
					try {
						System.out.println("Cargando nuevo archivo CSV, espere por favor.");
						obligatorio.lectura(file);
					} catch (IOException e) {
						System.out.println("Error en la lectura, verifique ubicación/compatibilidad.");
					}
				}
			}
		}
	}
}
