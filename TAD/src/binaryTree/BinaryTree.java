package binaryTree;

import nodoSimple.LinkedList;

public interface BinaryTree<K extends Comparable<K>,T> {
	
	public T find(K key);
	public void insert (K key, T data);
	public void delete (K key);
	public LinkedList<K> porNivel();
	
	

}
