package binaryTree;

import nodoSimple.LinkedList;
import nodoSimple.MyLinkedList;
import queueSimple.MyQueue;



public class MyBinaryTree<K extends Comparable<K>,T> implements BinaryTree<K,T> {
	
	private NodeBST<K,T> root;
	
	public T find(K key){
		
		NodeBST<K,T> aux=root.find(key);
		
		return aux.getData();
		
	}
	public void insert (K key, T data){
		
		NodeBST<K, T> node=new NodeBST<>(key,data);
		
		
		if(root==null){
			root=node;
		}else{
			
			root.insert(node);
			
			
		}
	
	}
	public LinkedList<K> porNivel(){
		
		LinkedList<K> retorno=new MyLinkedList<>();
		 retorno=root.porNivel();
		 
		 return retorno;
		
	}
	public void delete (K key){
	/*NodeBST<K,T> parent=root.findParent(key);*/
		root.deleteNode(key,root);
		
		
	}
	
	

}
