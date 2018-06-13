package source;

import nodoSimple.MyLinkedList;

public class Clase implements Comparable<Clase>{
	
	private MyLinkedList<String> productoDeLaClase;
	
	public Clase(String name, String pais) {
		this.name = name;
		this.pais=pais;
		this.productoDeLaClase= new MyLinkedList<>();
	}

	private String name;
    
	private String pais;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public MyLinkedList<String> getProductoDeLaClase() {
		return productoDeLaClase;
	}

	public void addProductoDeLaClase(String producto) {
		productoDeLaClase.add(producto);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean resultado = false;

		if (obj instanceof Clase) {

			if (getName().equals(((Clase) obj).getName())) {

				resultado = true;

			} else {
				resultado = false;
			}

		} else {
			resultado = false;
		}

		return resultado;
	}

	@Override
	public int compareTo(Clase o) {
		Integer este = Integer.valueOf(this.getProductoDeLaClase().size());
		Integer otro = Integer.valueOf(o.getProductoDeLaClase().size());
		int resultado = 0;
		if (este.compareTo(otro) == 1) {
			resultado = 1;
		} else if (este.compareTo(otro) == -1) {
			resultado = -1;
		}

		return resultado;

	}
}
