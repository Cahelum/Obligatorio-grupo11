package source;

import java.util.HashMap;
import nodoSimple.MyLinkedList;

public class Pais {

    private String name;
    
    private HashMap<String,Marca> marcasPorPais; //cambiar por nuestro hash
    
    private MyLinkedList<Producto> productosPorPais;

    public Pais(String name) {
        this.name = name;
        this.marcasPorPais=new HashMap<>();
        this.productosPorPais=new MyLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public HashMap<String,Marca> getMarcasPorPais() {
		return marcasPorPais;
	}

	public void agregarMarcasPorPais(Marca marca) {
		this.marcasPorPais.putIfAbsent(marca.getName(), marca);
	}

	public MyLinkedList<Producto> getProductosPorPais() {
		return productosPorPais;
	}

	public void agregarProductosPorPais(Producto producto) {
		this.productosPorPais.add(producto);
	}
    
    
}
