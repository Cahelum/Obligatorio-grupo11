package source;

import nodoSimple.MyLinkedList;

public class Marca implements Comparable<Marca> {

	private String name;

	private String pais;

	private MyLinkedList<String> productoDeLaMarcaPorPais;

	public Marca(String name, String pais) {
		this.name = name;
		this.pais = pais;
		this.productoDeLaMarcaPorPais = new MyLinkedList<>();
	}

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

	public MyLinkedList<String> getProductoDeLaMarca() {
		return productoDeLaMarcaPorPais;
	}

	public void addProductoDeLaMarca(String producto) {
		productoDeLaMarcaPorPais.add(producto);
	}

	@Override
	public int hashCode() {

		int sumASCII = 0;

		for (int x = 0; x < name.length(); x++) {

			sumASCII = sumASCII + name.codePointAt(x);

		}

		return ((sumASCII / name.length()));

	}

	@Override
	public boolean equals(Object obj) {
		boolean resultado = false;

		if (obj instanceof Marca) {

			if (getName().equals(((Marca) obj).getName())) {

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
	public int compareTo(Marca o) {
		Integer este = Integer.valueOf(this.getProductoDeLaMarca().size());
		Integer otro = Integer.valueOf(o.getProductoDeLaMarca().size());
		int resultado = 0;
		if (este.compareTo(otro) == 1) {
			resultado = 1;
		} else if (este.compareTo(otro) == -1) {
			resultado = -1;
		}

		return resultado;

	}
}
