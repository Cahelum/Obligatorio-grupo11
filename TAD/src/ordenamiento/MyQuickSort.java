package ordenamiento;

public class MyQuickSort<T extends Comparable<T>> implements AlgoritmoOrdenamiento<T> {
	boolean casoLim = false;

	public T[] order(T[] myList) {

		return orederQuick(myList, 0, myList.length - 1);
	}

	private T[] orederQuick(T[] myList, int start, int finish) {

		if (finish > 0) {
			T pivot = myList[finish];
			int i = start - 1;

			for (int x = start; x < finish; x++) {
                
				if (pivot.compareTo(myList[x]) == 1) {
					i = i + 1;
					T menor = myList[x];
					T mayor = myList[i];
					myList[i] = menor;
					myList[x] = mayor;
				}

			}

			for (int x = finish; x > i+1; x--) {

				T primero = myList[x - 1];
				T segundo = myList[x];
				myList[x - 1] = segundo;
				myList[x] = primero;

			}

			if (start < i) {
				myList = orederQuick(myList, start, i);
			}
			if (i + 1 < finish) {
				myList = orederQuick(myList, i + 2, finish);
			}
		}
		return myList;
	}

}
