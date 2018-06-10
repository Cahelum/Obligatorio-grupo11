package source;
import java.util.HashMap;

import hash.ElementoYaExistenteException;
import hash.HashTable;
import hash.MyHashTable;

public class Obligatorio {
	
    private HashTable<String,Pais> paises = new MyHashTable(100);
    private HashTable<String,Clase> clases= new MyHashTable<>(1000);
    private HashTable<String,Marca> marcas= new MyHashTable<>(10000);
    private HashTable<String,Empresa> empresas= new MyHashTable<>(10000);
    private HashTable<String,Rubro> rubros= new MyHashTable<>(10);
    
    public void crearProductoSoloStrings(String name, String fantasyName, String status, String idProduct, String clase, String pais, String marca, String empresa, String ruc, String rubro) {
    	
    	int idProduct2= Integer.parseInt(idProduct);
    	try {
			clases.insertar(clase, new Clase(clase));
			paises.insertar(pais, new Pais(pais));
	    	marcas.insertar(marca, new Marca(marca));
	    	empresas.insertar(empresa,new Empresa(empresa,ruc));
	    	rubros.insertar(rubro, new Rubro(rubro));
	    	
		} catch (ElementoYaExistenteException e) {
			System.out.println(e);
			//e.printStackTrace();
		}
    	
    	crearProducto(name, fantasyName, status, idProduct2, clases.obtener(clase), paises.obtener(pais), marcas.obtener(marca), empresas.obtener(empresa), rubros.obtener(rubro));
    	    	
    }

    public void crearProducto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca, Empresa empresa, Rubro rubro) {
    	
    	Producto producto = new Producto(name, fantasyName, status, idProduct, clase, pais, marca, empresa, rubro);
    	empresas.obtener(empresa.getName()).addProductoDeLaEmpresa(producto);
    	marcas.obtener(marca.getName()).addProductoDeLaMarca(producto);
    	paises.obtener(pais.getName()).agregarMarcasPorPais(marca);
    	paises.obtener(pais.getName()).agregarProductosPorPais(producto);
    }
    
    
    
}

