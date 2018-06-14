package source;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import hash.HashTable;
import hash.MyHashTable;
import ordenamiento.AlgoritmoOrdenamiento;
import ordenamiento.MyQuickSort;

public class Obligatorio {

	private HashTable<String, Pais> paises = new MyHashTable<>(100);
	private HashTable<String, Clase> clases = new MyHashTable<>(1000);
	private HashTable<String, Marca> marcas = new MyHashTable<>(10000);
	private HashTable<String, Empresa> empresas = new MyHashTable<>(10000);
	private HashTable<String, Rubro> rubros = new MyHashTable<>(11);
	private HashTable<String, Producto> productos = new MyHashTable<>(70000);
	private int contadorProductosHabilitados=0;
	
	public void crearProductoSoloStrings(String name, String fantasyName, String status, String idProduct, String clase,
			String pais, String marca, String empresa, String ruc, String rubro, String nroHab) {
		int idProduct2 = Integer.parseInt(idProduct);
		clases.insertarFaltante(clase+pais, new Clase(clase,pais));
		paises.insertarFaltante(pais, new Pais(pais));
		marcas.insertarFaltante(marca+pais, new Marca(marca, pais));
		empresas.insertarFaltante(empresa, new Empresa(empresa, ruc));
		rubros.insertarFaltante(rubro, new Rubro(rubro));

		Producto producto = new Producto(name, fantasyName, status, idProduct2, clases.obtener(clase+pais),
				paises.obtener(pais), marcas.obtener(marca+pais), empresas.obtener(empresa), rubros.obtener(rubro), nroHab);

		productos.insertarFaltante(producto.getIdProduct() + producto.getName(), producto);
		
		if (status.equals("HABILITADO")) {
			empresas.obtener(empresa)
					.addProductoDeLaEmpresa(producto.getIdProduct() + producto.getName() + producto.getNroHab());
			contadorProductosHabilitados= contadorProductosHabilitados+1;
		}
		if(status.equals("HABILITADO")){
			marcas.obtener(marca+pais).addProductoDeLaMarca(producto.getIdProduct() + producto.getName() + producto.getNroHab());
		}
		if(status.equals("HABILITADO")){
		paises.obtener(pais)
				.agregarProductosPorPais(producto.getIdProduct() + producto.getName() + producto.getNroHab());
		}
		if(status.equals("HABILITADO")){
			clases.obtener(clase+pais).addProductoDeLaClase(producto.getIdProduct() + producto.getName() + producto.getNroHab());
			}
	}

	public void lectura() throws IOException {
		File file = new File("v_producto_real_updated.csv");
		CsvReader csvReader = new CsvReader();
		csvReader.setFieldSeparator(';');
		csvReader.setContainsHeader(true);
		CsvContainer csv;
			csv = csvReader.read(file, StandardCharsets.UTF_8);
			for (CsvRow row : csv.getRows()) {
				
				String nombreProducto = row.getField("nombre"); 
				String nombreDeFantasia= row.getField("nom_fantasia"); 
				String idProduct = row.getField("idprod"); 
				String rubro = row.getField("rubro"); 
				String nroHab = row.getField("nro_hab");
				String empresa = row.getField("empresa"); 
				String clase = row.getField("clase"); 
				String marca = row.getField("marca");
				String pais= row.getField("pais"); 
				String status = row.getField("estado");
				String ruc = row.getField("ruc");
				
				crearProductoSoloStrings(nombreProducto, nombreDeFantasia, status, idProduct, clase, pais, marca, empresa, ruc, rubro, nroHab);
			}
		
		
	}
	
	public void reporte20EmpresasConMasProductosHabilitados() {
		int i = 0;
		Iterator<Empresa> itr = empresas.iterator();
		Empresa[] reporte1 = new Empresa[(empresas.getCantElementos()) - 1];
		while (itr.hasNext()) {
			Empresa empresa = itr.next();
			reporte1[i] = empresa;

			i++;

		}
		AlgoritmoOrdenamiento<Empresa> quicksort = new MyQuickSort<>();
		reporte1 = quicksort.order(reporte1);
		for (int j = 1; j < 21; j++) {
			System.out.println(reporte1[(reporte1.length) - j].getName() + " "
					+ reporte1[(reporte1.length) - j].getProductosDeLaEmpresa().size());
		}
	}

	public void reporte10MarcasConMasProductosHabilitados() {
		int i = 0;
		Iterator<Marca> itr = marcas.iterator();
		Marca[] reporte2 = new Marca[(marcas.getCantElementos()) - 1];
		while (itr.hasNext()) {
			Marca marca = itr.next();
			reporte2[i] = marca;
           
			i++;

		}
		AlgoritmoOrdenamiento<Marca> quicksort = new MyQuickSort<>();
		reporte2 = quicksort.order(reporte2);
		for (int j = 1; j < 11; j++) {
			System.out.println(reporte2[(reporte2.length) - j].getName() + " "
					+ reporte2[(reporte2.length) - j].getProductoDeLaMarca().size() + " "+ reporte2[(reporte2.length) - j].getPais()) ;
		}

	}
	
	public void reporte10PaisesConMasProductosHabilitados() {
		
		int i = 0;
		Iterator<Pais> itr = paises.iterator();
		Pais[] reporte3 = new Pais[(paises.getCantElementos()) - 1];
		while (itr.hasNext()) {
			Pais pais = itr.next();
			reporte3[i] = pais;

			i++;

		}
		AlgoritmoOrdenamiento<Pais> quicksort = new MyQuickSort<>();
		reporte3 = quicksort.order(reporte3);
		for (int j = 1; j < 11; j++) {
			System.out.println(reporte3[(reporte3.length) - j].getName() + " "
					+ reporte3[(reporte3.length) - j].getProductosPorPais().size() + " "+ 100*reporte3[(reporte3.length) - j].getProductosPorPais().size()/contadorProductosHabilitados) ;
		}
		
		
	}
	
	public void reporte20ClasesConMasProductosHabilitados() {
		int i = 0;
		Iterator<Clase> itr = clases.iterator();
		Clase[] reporte4 = new Clase[(clases.getCantElementos())-1];
		
		
		
		while (itr.hasNext()) {
		
			Clase clase = itr.next();
			reporte4[i] = clase;

			i++;
	
			}
		
		
		AlgoritmoOrdenamiento<Clase> quicksort = new MyQuickSort<>();
		reporte4 = quicksort.order(reporte4);
		for (int j = 1; j < 11; j++) {
			System.out.println(reporte4[(reporte4.length) - j].getName() + " "
					+ reporte4[(reporte4.length) - j].getProductoDeLaClase().size() + " "+ reporte4[(reporte4.length) - j].getPais()) ;
		}

	}

}
