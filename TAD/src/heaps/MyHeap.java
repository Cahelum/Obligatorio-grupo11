package heaps;

public class MyHeap<K extends Comparable<K>, T> implements Heap<K, T> {
	boolean esMax;
	int comparar=0;
	public MyHeap(boolean tipo) {

		esMax = tipo;
	}

	NodeH<K, T>[] myList = new NodeH[10];
	
   

	public void add(K key, T data) {
		
		if(esMax==true) {
			comparar=1;
		}else {
			comparar=-1;
		}

		NodeH<K, T> node = new NodeH<>(key, data);
		int i = 0;
		if (myList[0] == null) {
			myList[0] = (node);
		} else {
			while (myList[i] != null && i < myList.length) {
				i++;
			}

			myList[i] = node;

			// Los hijos de i están en 2*i+1 y 2*i+2
			// El padre de i está en (i-1)/2
			boolean cambio = true;

			do {
				if (myList[i].getKey().compareTo(myList[(i - 1) / 2].getKey()) == comparar) {
					NodeH<K, T> hijo = myList[i];
					NodeH<K, T> padre = myList[(i - 1) / 2];

					myList[i] = padre;
					myList[(i - 1) / 2] = hijo;

					i = (i - 1) / 2;

				} else {
					cambio = false;
				}
			} while (cambio == true);

		}

	}

	public NodeH<K, T> find(K key) {
		int i = 0;
		NodeH<K, T> oExit = null;
		while (myList[i] != null && i < myList.length) {

			if (myList[i].getKey().compareTo(key) == 0) {
				oExit = myList[i];
			}
			i++;
		}

		return oExit;
	}

	// Los hijos de i están en 2*i+1 y 2*i+2
	// El padre de i está en (i-1)/2

	@Override
	public void delete() {
		
		if(esMax==true) {
			comparar=1;
		}else {
			comparar=-1;
		}
		
		
		int i = 0;
		boolean izquierdo = true;
		boolean cambio = true;
		if (myList[0] == null) {
			System.out.println("el heap esta vacio");
		} else {

			while (myList[i] != null && i < myList.length) {
				i++;
			}
			i--;
			myList[0] = myList[i];
			myList[i] = null;

			i = 0;

			while (cambio == true) {

				if (myList[2 * i + 1] != null && myList[2 * i + 2] != null) {

					if (myList[2 * i + 1].getKey().compareTo(myList[2 * i + 2].getKey()) == comparar) {

						if (myList[2 * i + 1].getKey().compareTo(myList[(((2 * i + 2) - 1) / 2)].getKey()) == comparar) {

							izquierdo = true;

							cambio = true;
						} else {
							cambio = false;
						}

					} else {

						if (myList[2 * i + 2].getKey().compareTo(myList[(((2 * i + 2) - 1) / 2)].getKey()) == comparar) {

							izquierdo = false;
							cambio = true;
						} else {
							cambio = false;
						}

					}

				} else {

					if (myList[2 * i + 1] != null && myList[i].getKey().compareTo(myList[2 * i + 2].getKey()) == comparar) {

						izquierdo = true;

					}

					cambio = false;

				}
				if (cambio == true) {
					if (izquierdo == true) {

						NodeH<K, T> padre = myList[i];
						NodeH<K, T> hijo = myList[2 * i + 1];

						myList[i] = hijo;
						myList[2 * i + 1] = padre;
						i = 2 * i + 1;

					} else {

						NodeH<K, T> padre = myList[i];
						NodeH<K, T> hijo = myList[2 * i + 2];

						myList[i] = hijo;
						myList[2 * i + 2] = padre;
						i = 2 * i + 2;

					}

				}

			}

		}

	}

	@Override
	public void imprimir() {

		int i = 0;
		while (myList[i] != null && i < myList.length) {
			System.out.println(myList[i].getKey());
			i++;
		}

	}

}
