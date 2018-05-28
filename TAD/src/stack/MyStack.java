package stack;
public class MyStack<T> implements Stack<T> {

	private Nodo<T> first;
	private Nodo<T> last;

	public MyStack() {

		this.first = null;
		this.last = null;

	}

	public void push(T entero) {

		if (first == null) {

			this.first = new Nodo<T>(entero);

		} else if (last == null) {

			last = new Nodo<T>(entero);
			last.setBefore(first);
			first.setNext(last);

		} else {

			Nodo<T> another = new Nodo<T>(last.getValor());
			another.setNext(last);
			another.setBefore(last.getBefore());
			last.setValor(entero);
			last.setBefore(another);

		}

	}

	public void pop() throws ExepcionStackVacio {

		if (first == null) {
			ExepcionStackVacio esv = new ExepcionStackVacio();
			throw esv;
		} else {

			if (first.getNext() == null) {

				first = null;

			} else if (last.getBefore() != first) {
				Nodo<T> scope = null;
				scope = last.getBefore();

				last.setValor(scope.getValor());
				last.setBefore(scope.getBefore());
				scope = scope.getBefore();
				scope.setNext(last);
			} else {
				first.setNext(null);
				last = null;
			}
		}

	}

	public T top() throws ExepcionStackVacio {
		

		if (first == null) {
			ExepcionStackVacio esv = new ExepcionStackVacio();
			throw esv;
		} else {
			if (last == null) {
				return first.getValor();
			} else {
				return last.getValor();
			}
		}
	}

	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}

	}

	public void makeEmpty() {

		last = null;
		first = null;

	}

}
