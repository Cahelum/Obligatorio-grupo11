package hash;

import java.util.Iterator;

public class MyHashTable<K, T> implements HashTable<K, T>, Iterable<T> {
	NodeH<K, T>[] hash;
	int cantElementos = 0;
	private int size;
	
	public MyHashTable(int arrayLenght) {

		hash = new NodeH[arrayLenght];
		size=arrayLenght;
		
	}

	public void insertar(K clave, T valor) throws ElementoYaExistenteException {
		// System.out.println(cantElementos+"inicio insertar");
		int coord = 1;
		coord = Math.abs(clave.hashCode()) % size;
		NodeH<K, T> nodo = new NodeH<K, T>(clave, valor, false);

		while (hash[coord] != null && hash[coord].getEliminado() == false) {
			if (hash[coord].getClave().equals(clave) && hash[coord].getEliminado() == false) {
				throw new ElementoYaExistenteException("este elemento ya fue ingresado");

			}

			coord = FuncionColicion(coord);

		}
		// System.out.println(cantElementos+"antes de suma");
		cantElementos++;
		// System.out.println(cantElementos+"Despues de suma");

		hash[coord] = nodo;

		double auxCantElementos = cantElementos;
		double auxHashL = size;
		if (auxCantElementos / auxHashL > 0.8) {
			agrandarHash();
		}

	}

	public void agrandarHash() {
		NodeH<K, T>[] aux;

		aux = new NodeH[(int) (size * 2)];

		for (int c = 0; c < size; c++) {
			
			if (hash[c] != null) {
				int newCoord = Math.abs(hash[c].getClave().hashCode()) % size;
				
				if (aux[newCoord] == null) {
					aux[newCoord] = hash[c];
				} else {
					int newCoord2=newCoord;
					while (aux[newCoord] != null &&hash[newCoord].getEliminado()) {
						if (newCoord >= size) {
							newCoord = 0;
						} else {
							newCoord++;
						}
					}
					aux[newCoord] = hash[c];
				}
				

			}

			hash = aux;
			size=size*2;
		}
	}

	public boolean pertenece(K clave) {

		boolean resultado = false;

		int coord = Math.abs(clave.hashCode()) % size;

		while (hash[coord] != null && coord < size && resultado == false) {

			if (hash[coord].getClave().equals(clave)) {

				resultado = true;

			}
			coord = FuncionColicion(coord);

		}

		return resultado;
	}

	public void borrar(K clave) {

		boolean resultado = false;

		int coord = Math.abs(clave.hashCode()) % size;

		while (hash[coord] != null && coord < size && resultado == false) {

			if (hash[coord].getClave().equals(clave)) {

				resultado = true;

			} else {
				coord = FuncionColicion(coord);
			}

		}
		if (resultado == true) {
			hash[coord].setEliminado(true);
		}

	}

	public int FuncionColicion(int coord) {
		int funcion = 0;

		if (coord < size - 1) {

			funcion = coord + 1;
		} else {

			funcion = 0;

		}
		return funcion;

	}

	public T obtener(K clave) {
		boolean resultado = false;
		T res = null;

		int coord = Math.abs(clave.hashCode()) % size;
		while (hash[coord] != null && coord < size && resultado == false) {
			if (hash[coord].getClave().equals(clave) && hash[coord].getEliminado() == false) {
				resultado = true;

			} else {
				coord = FuncionColicion(coord);
			}

		}
		if (resultado == true) {
			res = hash[coord].getValor();
		} else {
			res = null;
		}

		return res;
	}

	public void insertarFaltante(K clave, T valor) {
		try {
			insertar(clave, valor);
		} catch (ElementoYaExistenteException e) {

		}
	}

	public int size() {

		return size;

	}

	public int getCantElementos() {
		return cantElementos;
	}

	public Iterator<T> iterator() {

		Iterator<T> iterator = new Iterator<T>() {
			private int indexActual = -1;
			private int elementos = 1;

			@Override
			public boolean hasNext() {
				// System.out.println("elementos: "+elementos+" cant elementos:
				// "+cantElementos+" : "+size);
				return elementos < cantElementos;
			}

			@Override
			public T next() {
				do {
					indexActual++;
				} while (hash[indexActual] == null || hash[indexActual].eliminado);
				elementos++;

				T valorDelNodo = hash[indexActual].getValor();

				return valorDelNodo;
			}
		};
		return iterator;
	}

}
