package nodoSimple;

public class Nodo<T> {

	private T valor;
	private Nodo<T> next;

	public Nodo(T valor) {
		next = null;
		this.valor = valor;

	}

	public T getValor() {

		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {

		this.next = next;
	}

}
