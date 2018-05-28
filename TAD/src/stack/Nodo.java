package stack;

public class Nodo<T> {

	private Nodo next;
	private T valor;
	private Nodo before;
	
	
	public Nodo (T entero) {
		
		this.valor = entero;
		this.next = null;
		this.before=null;
		
	}


	public Nodo getNext() {
		return next;
	}


	public void setNext(Nodo next) {
		this.next = next;
	}


	public T getValor() {
		return valor;
	}


	public void setValor(T valor) {
		this.valor = valor;
	}


	public Nodo getBefore() {
		return before;
	}


	public void setBefore(Nodo before) {
		this.before = before;
	}
	
	
	
	
}
