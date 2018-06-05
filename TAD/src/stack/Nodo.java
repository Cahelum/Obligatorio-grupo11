package stack;

public class Nodo<T> {

	private Nodo<T> next;
	private T valor;
	private Nodo<T> before;
	
	
	public Nodo (T entero) {
		
		this.valor = entero;
		this.next = null;
		this.before=null;
		
	}


	public Nodo<T> getNext() {
		return next;
	}


	public void setNext(Nodo<T> next) {
		this.next = next;
	}


	public T getValor() {
		return valor;
	}


	public void setValor(T valor) {
		this.valor = valor;
	}


	public Nodo<T> getBefore() {
		return before;
	}


	public void setBefore(Nodo<T> before) {
		this.before = before;
	}
	
	
	
	
}
