package queueSimple;

import nodoSimple.*;



public class MyQueue<T> implements Queue<T> {

	
	private LinkedList<T> list;
	
	public MyQueue(){
		
		list=new MyLinkedList<>();
		
	}
	
	
	public void enqueue (T element){
		
		list.add(element);
		
	}
	
	public void dequeue (){
		
		list.delete(0);
		
	}
	
	public boolean isEmpty(){
		
		boolean esVacio=false;
		int cantelementos=list.size();
		 
		if(cantelementos==0){
			esVacio=true;
		}
		
		
		return esVacio;
	}
	
	public T getFirst(){
		
	return list.getElementFrom(0);
	
	}
	
	public int size(){
		
		return list.size();
		
	}
	
	
}
