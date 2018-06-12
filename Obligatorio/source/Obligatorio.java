package source;

import java.util.Iterator;
import hash.HashTable;
import hash.MyHashTable;
import nodoSimple.LinkedList;
import nodoSimple.MyLinkedList;

public class Obligatorio {

	private LinkedList<Empresa> reporte1= new MyLinkedList<>();
	private HashTable<String, Pais> paises = new MyHashTable<>(100);
	private HashTable<String, Clase> clases = new MyHashTable<>(1000);
	private HashTable<String, Marca> marcas = new MyHashTable<>(10000);
	private HashTable<String, Empresa> empresas = new MyHashTable<>(10000);
	private HashTable<String, Rubro> rubros = new MyHashTable<>(11);
	private HashTable<String, Producto> productos = new MyHashTable<>(70000);

	public void crearProductoSoloStrings(String name, String fantasyName, String status, String idProduct, String clase,
			String pais, String marca, String empresa, String ruc, String rubro, String nroHab) {

		int idProduct2 = Integer.parseInt(idProduct);
		clases.insertarFaltante(clase, new Clase(clase));
		paises.insertarFaltante(pais, new Pais(pais));
		marcas.insertarFaltante(marca, new Marca(marca));
		empresas.insertarFaltante(empresa, new Empresa(empresa, ruc));
		rubros.insertarFaltante(rubro, new Rubro(rubro));
		
		Producto producto = new Producto(name, fantasyName, status, idProduct2, clases.obtener(clase), paises.obtener(pais),
				marcas.obtener(marca), empresas.obtener(empresa), rubros.obtener(rubro), nroHab);

		productos.insertarFaltante(producto.getIdProduct() + producto.getName(), producto);
		if(status=="HABILITADO") {
			empresas.obtener(empresa).addProductoDeLaEmpresa(producto.getIdProduct() + producto.getName()+producto.getNroHab());
		}
		marcas.obtener(marca).addProductoDeLaMarca(producto.getIdProduct() + producto.getName()+producto.getNroHab());
		paises.obtener(pais).agregarProductosPorPais(producto.getIdProduct() + producto.getName()+producto.getNroHab());
	}

	

	public void reporte20EmpresasConMasProductosHabilitados(){
		int i=0;
		Iterator<Empresa> itr = empresas.iterator();
		while(itr.hasNext()) {
	         Empresa empresa = itr.next();
	         reporte1.add(empresa);
	      }
		
	}
	
}
