package hash;

public class MyHashTable<K, T> implements HashTable<K, T> {
	NodeH<K, T>[] aux;
	NodeH<K, T>[] hash;
	int cantElementos;

	public MyHashTable(int arrayLenght) {

		hash = new NodeH[arrayLenght];

	}

	public void insertar(K clave, T valor) throws ElementoYaExistenteException {

		int coord = 1;
		coord = Math.abs(clave.hashCode()) % hash.length;
		NodeH nodo = new NodeH<K, T>(clave, valor, false);

		int cont = coord;
		
        while (hash[coord] != null && hash[coord].getEliminado() == false /*&& cont < hash.length*/) {
			 if (hash[coord].getClave().equals(clave) && hash[coord].getEliminado() == false) {
				throw new ElementoYaExistenteException("este elemento ya fue ingresado");
				
			}
			
			coord = FuncionColicion(coord);
            
		}

		if (cont < hash.length) {

			cantElementos++;
			hash[coord] = nodo;

		} else {
			throw new ElementoYaExistenteException(
					"la posicion original elegida a traves de la clave ya estaba ocupada y la funcion de colicion fallo en encontrar una posicion libre");
		}
		
        double auxCantElementos=cantElementos;
        double auxHashL=hash.length;
    
        
		if (auxCantElementos / auxHashL > 0.8) {
			 System.out.println(auxCantElementos / auxHashL+"indice de ocupacion ------"+cantElementos);	
		System.out.println("agrando"+hash.length+"inicio");

			aux = new NodeH[(hash.length)];

			for (int c = 0; c < aux.length; c++) {

				aux[c] = hash[c];
			}

			hash = new NodeH[(int) (hash.length * 1.5)];

			for (int c = 0; c < aux.length; c++) {
				
				if(aux[c]!=null) {
					int newCoord = Math.abs(aux[c].getClave().hashCode()) % hash.length;
				    hash[newCoord] = aux[c];
				}
				

				

			}
			System.out.println("agrando"+hash.length+"final");

		}

	}

	public boolean pertenece(K clave) {

		boolean resultado = false;

		int coord = Math.abs(clave.hashCode()) % hash.length;

		while (hash[coord] != null && coord < hash.length && resultado == false) {

			if (hash[coord].getClave().equals(clave)) {

				resultado = true;

			}
			coord = FuncionColicion(coord);

		}

		return resultado;
	}

	public void borrar(K clave) {

		boolean resultado = false;

		int coord = Math.abs(clave.hashCode()) % hash.length;

		while (hash[coord] != null && coord < hash.length && resultado == false) {

			if (hash[coord].getClave().equals(clave)) {

				resultado = true;

			}else {
			coord = FuncionColicion(coord);
			}

		}
		if(resultado==true) {
			hash[coord].setEliminado(true);
		}

	}

	public int FuncionColicion(int coord) {
		int funcion=0;
		
		if (coord<hash.length-1) {
			
			funcion = coord + 1;
		}else {
			
			funcion=0;
			
		}
		return funcion;

	}

	public T obtener(K clave) {
		boolean resultado = false;
		T res=null;

		int coord = Math.abs(clave.hashCode()) % hash.length;
		while (hash[coord] != null && coord < hash.length && resultado == false) {
			if (hash[coord].getClave().equals(clave) && hash[coord].getEliminado()==false) {
				resultado = true;

			}else {
				coord = FuncionColicion(coord);
			}

		}
		if(resultado==true) {
			res=hash[coord].getValor();
		}else {
			res=null;
			}
		

		return res;
	}
	public void insertarFaltante(K clave, T valor) {
		try {
			insertar(clave, valor);
		} catch (ElementoYaExistenteException e) {
		
		}
	}
}
