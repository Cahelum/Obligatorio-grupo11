package queueSimple;

public interface Queue<T> {
	
	void enqueue (T element);//ingresa un elemento
	public void dequeue (); //throws EmptyQueueException;
	boolean isEmpty();
	public T getFirst(); //throws EmptyQueueException;
	public int size();
	
}
