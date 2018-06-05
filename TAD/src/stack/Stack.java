package stack;
import nodoSimple.*;

public interface Stack<T> {

	public void push(T entero);
	public void pop() throws ExepcionStackVacio;
	public T top() throws ExepcionStackVacio;
	public boolean isEmpty();
	public void makeEmpty(); 
	
	
	
	
	
}
