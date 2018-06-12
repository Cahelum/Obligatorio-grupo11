package source;
import java.util.HashMap;

import hash.ElementoYaExistenteException;
import hash.HashTable;
import hash.MyHashTable;

public class Obligatorio {
	
    private HashTable<String,Pais> paises = new MyHashTable(100);
    private HashTable<String,Clase> clases= new MyHashTable<>(256);
    private HashTable<String,Marca> marcas= new MyHashTable<>(10000);
    private HashTable<String,Empresa> empresas= new MyHashTable<>(10000);
    private HashTable<String,Rubro> rubros= new MyHashTable<>(11);
    
    public void crearProductoSoloStrings(String name, String fantasyName, String status, String idProduct, String clase, String pais, String marca, String empresa, String ruc, String rubro) {
    	
    	int idProduct2= Integer.parseInt(idProduct);
		clases.insertarFaltante(clase, new Clase(clase));
		paises.insertarFaltante(pais, new Pais(pais));
    	marcas.insertarFaltante(marca, new Marca(marca));
    	empresas.insertarFaltante(empresa,new Empresa(empresa,ruc));
    	rubros.insertarFaltante(rubro, new Rubro(rubro));
    	crearProducto(name, fantasyName, status, idProduct2, clases.obtener(clase), paises.obtener(pais), marcas.obtener(marca), empresas.obtener(empresa), rubros.obtener(rubro));
    	    	
    }

    public void crearProducto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca, Empresa empresa, Rubro rubro) {
    	Producto producto = new Producto(name, fantasyName, status, idProduct, clase, pais, marca, empresa, rubro);
    	Empresa prueba1= empresas.obtener(empresa.getName());
    	prueba1.addProductoDeLaEmpresa(producto);
    	Marca prueba= marcas.obtener(marca.getName());
    	prueba.addProductoDeLaMarca(producto);
    	paises.obtener(pais.getName()).agregarMarcasPorPais(marca);
    	paises.obtener(pais.getName()).agregarProductosPorPais(producto);
    }
    
    
    
}

