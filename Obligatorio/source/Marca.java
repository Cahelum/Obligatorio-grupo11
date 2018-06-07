package source;

import nodoSimple.MyLinkedList;

public class Marca {
	
	private String name;
	
	private MyLinkedList<Producto> productoDeLaMarca;
	
	public Marca(String name) {
		this.name = name;
		this.productoDeLaMarca=new MyLinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<Producto> getProductoDeLaMarca() {
		return productoDeLaMarca;
	}

	public void addProductoDeLaMarca(Producto producto) {
		productoDeLaMarca.add(producto);
	}
	
}
