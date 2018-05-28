package nodoSimple;

public interface LinkedList<T> {

	public void add(T elemento);

	public int size();

	public boolean search(T elemento);

	public T getElementFrom(int entero);

	public void delete(int entero);//eleimina por coordenada sindo el primer elemento 0

	public void addFirst(T elemento);
	
	public void addCoord(T elemento,int coordenada);
}
