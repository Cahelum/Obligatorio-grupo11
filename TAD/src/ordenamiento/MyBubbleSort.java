package ordenamiento;

public class MyBubbleSort<T extends Comparable<T>> implements AlgoritmoOrdenamiento<T> {

	

	
	public T[] order(T[] myList) {

		int recorrido = myList.length;

		boolean cambio = true;

		while (cambio == true) {
			cambio = false;
			recorrido--;
			for (int i = 0; i < recorrido; i++) {

				if (myList[i].compareTo(myList[i + 1]) == 1) {

					T mayor = myList[i];
					T menor = myList[i + 1];

					myList[i] = menor;
					myList[i + 1] = mayor;
					cambio = true;
				}

			}

		}

		return myList;
	}
	
}
