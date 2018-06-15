package source;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import hash.HashTable;
import hash.MyHashTable;
import ordenamiento.AlgoritmoOrdenamiento;
import ordenamiento.MyQuickSort;

public class Obligatorio {

	private HashTable<String, Pais> paises = new MyHashTable<>(100);
	private HashTable<String, Clase> clases = new MyHashTable<>(10000);
	private HashTable<String, Marca> marcas = new MyHashTable<>(10000);
	private HashTable<String, Empresa> empresas = new MyHashTable<>(10000);
	private HashTable<String, Producto> productos = new MyHashTable<>(70000);
	private int contadorProductosHabilitados = 0;

	public void crearProductoSoloStrings(String name, String fantasyName, String status, String idProduct, String clase,
			String pais, String marca, String empresa, String ruc, String rubro, String nroHab) {
		int idProduct2 = Integer.parseInt(idProduct);

		Empresa oEmpresa;
		if (empresas.pertenece(empresa)) {
			oEmpresa = empresas.obtener(empresa);
		} else {
			oEmpresa = new Empresa(empresa, ruc);
			empresas.insertarFaltante(empresa, oEmpresa);
		}

		Clase oClase;
		if (clases.pertenece(clase)) {
			oClase = clases.obtener(clase);
		} else {
			oClase = new Clase(clase, pais);
			clases.insertarFaltante(clase + pais, oClase);
		}

		Pais oPais;
		if (paises.pertenece(pais)) {
			oPais = paises.obtener(pais);
		} else {
			oPais = new Pais(pais);
			paises.insertarFaltante(pais, oPais);
		}

		Marca oMarca;
		if (marcas.pertenece(marca)) {
			oMarca = marcas.obtener(marca);
		} else {
			oMarca = new Marca(marca, pais);
			marcas.insertarFaltante(marca + pais, oMarca);
		}

		Rubro oRubro;
		if (rubro.equals("Exp")) {
			oRubro = Rubro.EXPENDEDOR;
		} else if (rubro.equals("Elab")) {
			oRubro = Rubro.ELABORADOR;
		} else {
			oRubro = Rubro.EXPENDEDOR_ELABORADOR;

		}

		Producto producto = new Producto(name, fantasyName, status, idProduct2, oClase, oPais, oMarca, oEmpresa, oRubro,
				nroHab);

		productos.insertarFaltante(producto.getIdProduct() + producto.getName(), producto);

		if (status.equals("HABILITADO")) {
			empresas.obtener(empresa)
					.addProductoDeLaEmpresa(producto.getIdProduct() + producto.getName() + producto.getNroHab());

			marcas.obtener(marca + pais)
					.addProductoDeLaMarca(producto.getIdProduct() + producto.getName() + producto.getNroHab());

			paises.obtener(pais)
					.agregarProductosPorPais(producto.getIdProduct() + producto.getName() + producto.getNroHab());

			clases.obtener(clase + pais)
					.addProductoDeLaClase(producto.getIdProduct() + producto.getName() + producto.getNroHab());

			contadorProductosHabilitados = contadorProductosHabilitados + 1;
		}
	}

	public void lectura(String path) throws IOException {
		File file = new File(path);
		CsvReader csvReader = new CsvReader();
		csvReader.setFieldSeparator(';');
		csvReader.setContainsHeader(true);
		CsvContainer csv;
		csv = csvReader.read(file, StandardCharsets.UTF_8);
		for (CsvRow row : csv.getRows()) {

			String nombreProducto = row.getField(0);
			String nombreDeFantasia = row.getField(1);
			String idProduct = row.getField(2);
			String rubro = row.getField(3);
			String nroHab = row.getField(4);
			String empresa = row.getField(5);
			String clase = row.getField(10);
			String marca = row.getField(12);
			if (marca.contains("  ")) {
				marca = marca.replace("  ", " ");
			}
			String pais = row.getField(13);
			String status = row.getField(20);
			String ruc = row.getField(23);

			crearProductoSoloStrings(nombreProducto, nombreDeFantasia, status, idProduct, clase, pais, marca, empresa,
					ruc, rubro, nroHab);
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
			System.out.println("-Empresa: " + reporte1[(reporte1.length) - j].getName() + " -Cantidad de productos: "
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
			System.out.println("-Marca: " + reporte2[(reporte2.length) - j].getName() + " -Cantidad de productos: "
					+ reporte2[(reporte2.length) - j].getProductoDeLaMarca().size() + " -País de origen: "
					+ reporte2[(reporte2.length) - j].getPais());
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
			System.out.println("-Pais: " + reporte3[(reporte3.length) - j].getName() + " -Cantidad de productos: "
					+ reporte3[(reporte3.length) - j].getProductosPorPais().size() + " -Porcentaje del total: "
					+ 100 * reporte3[(reporte3.length) - j].getProductosPorPais().size() / contadorProductosHabilitados
					+ "%");
		}

	}

	public void reporte20ClasesConMasProductosHabilitados() {
		int i = 0;
		Iterator<Clase> itr = clases.iterator();
		Clase[] reporte4 = new Clase[(clases.getCantElementos()) - 1];

		while (itr.hasNext()) {

			Clase clase = itr.next();
			reporte4[i] = clase;

			i++;

		}

		AlgoritmoOrdenamiento<Clase> quicksort = new MyQuickSort<>();
		reporte4 = quicksort.order(reporte4);
		for (int j = 1; j < 21; j++) {
			System.out.println("-Clase: " + reporte4[(reporte4.length) - j].getName() + " -Cantidad de productos: "
					+ reporte4[(reporte4.length) - j].getProductoDeLaClase().size() + " -Pais de origen: "
					+ reporte4[(reporte4.length) - j].getPais());
		}

	}

	public boolean elegirReporte() {
		Scanner sc = new Scanner(System.in);
		String pedido;
		do {
			System.out.println("1- Listar las 20 empresas que disponen de mayor cantidad de productos habilitados.");
			System.out.println("2- Listar las 10 marcas por país que tienen mayor cantidad de productos habilitados.");
			System.out.println("3- Listar los 10 países que disponen la mayor cantidad de productos habilitados.");
			System.out.println("4- Listar las 20 clases por país que tienen mayor cantidad de productos habilitados.");
			System.out.println("Elija escribiendo '1', '2', '3' o '4'.");
			pedido = sc.nextLine();
		} while (!pedido.equals("1") && !pedido.equals("2") && !pedido.equals("3") && !pedido.equals("4"));

		long startTime = 0;
		long endTime = 0;
		long duration = 0;
		switch (pedido) {
		case "1":
			startTime = System.nanoTime();

			reporte20EmpresasConMasProductosHabilitados();

			endTime = System.nanoTime(); // Medición de tiempo en cada caso para evitar error
			duration = (endTime - startTime);
			System.out.println("Demoró " + duration / 1000000 + " milisegundos.");
			break;
		case "2":
			startTime = System.nanoTime();

			reporte10MarcasConMasProductosHabilitados();

			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Demoró " + duration / 1000000 + " milisegundos.");
			break;
		case "3":
			startTime = System.nanoTime();

			reporte10PaisesConMasProductosHabilitados();

			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Demoró " + duration / 1000000 + " milisegundos.");
			break;
		case "4":
			startTime = System.nanoTime();

			reporte20ClasesConMasProductosHabilitados();

			endTime = System.nanoTime();
			duration = (endTime - startTime);
			System.out.println("Demoró " + duration / 1000000 + " milisegundos.");
			break;
		}

		return true;
	}
}
