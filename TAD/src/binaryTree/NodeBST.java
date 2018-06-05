package binaryTree;

import queueSimple.MyQueue;
import queueSimple.Queue;
import nodoSimple.LinkedList;
import nodoSimple.MyLinkedList;


public class NodeBST<K extends Comparable<K>, T> {

	K key;
	T data;
	NodeBST<K, T> leftChild;
	NodeBST<K, T> rightChild;

	public NodeBST(K key, T data) {

		this.key = key;
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;

	}

	public NodeBST<K, T> find(K key) {
		NodeBST<K, T> oExit = null;

		if (key.compareTo(getKey()) == 0) {

			oExit = this;

		} else {
			if (key.compareTo(getKey()) == 1) {
				oExit = getRightChild().find(key);
			} else {
				oExit = getLeftChild().find(key);
			}
		}

		return oExit;
	}

	public void insert(NodeBST<K, T> node) {

		if (node.getKey().compareTo(getKey()) == 1) {
			if (getRightChild() == null) {
				setRightChild(node);
			} else {
				getRightChild().insert(node);
			}
		} else {
			if (getLeftChild() == null) {
				setLeftChild(node);
			} else {
				getLeftChild().insert(node);
			}

		}

	}

	public NodeBST<K, T> findParent(K key) {
		NodeBST<K, T> oExit = null;

		if (getKey().compareTo(key) == 0) {
			oExit = null;
		} else {
			if (getLeftChild() == null && getRightChild() == null) {
				oExit = null;
			} else {
				if (key.compareTo(getKey()) == 1) {
					if (key.compareTo(getRightChild().getKey()) == 0) {
						oExit = this;
					} else {
						oExit = getRightChild().findParent(key);
					}
				} else {
					if (key.compareTo(getLeftChild().getKey()) == 0) {
						oExit = this;
					} else {
						oExit = getLeftChild().findParent(key);
					}
				}
			}
		}
		return oExit;

	}

	public LinkedList<K> porNivel() {

		LinkedList<K> ll = new MyLinkedList<>();
		Queue<K> dq = new MyQueue<>();
		K temp = null;
		dq.enqueue(getKey());

		while (dq.size() != 0) {

			temp = dq.getFirst();
			dq.dequeue();
			NodeBST<K, T> aux = find(temp);

			if (aux.getLeftChild() != null) {

				dq.enqueue(aux.getLeftChild().getKey());

			}
			if (aux.getRightChild() != null) {
				dq.enqueue(aux.getRightChild().getKey());
			}

			ll.add(temp);
		}
		return ll;
	}
   
	public void deleteNode(K key,NodeBST<K,T> root) {
		 
		NodeBST<K, T> parent=null;
		 
		NodeBST<K, T> node = null;
		
		if (key.compareTo(this.getKey()) == 0) {
			
			parent=root.findParent(key);
			node = this;
			if (getLeftChild() == null && getRightChild() == null) {

				if (parent.getLeftChild()!=null) {
					
					if(parent.getLeftChild().equals(node)) {
						
						parent.setLeftChild(null);
						
					}else{
						parent.setRightChild(null);
					}
					
				} else{
					parent.setRightChild(null);
				}
			}else if (getLeftChild() == null) {
				if (parent.getLeftChild().equals(node)) {
					parent.setLeftChild(node.getRightChild());
				} else {
					parent.setRightChild(node.getRightChild());
				}

			} else {
				
				
				NodeBST<K,T> varAux=getLeftChild();
				NodeBST<K,T> maxIzq=getLeftChild();
				maxIzq=maxIzquierdo(varAux);
				
				deleteNode(maxIzq.getKey(), root);
				node.setData(maxIzq.getData());
				node.setKey(maxIzq.getKey());
				

			}
		} else if (key.compareTo(this.getKey()) == 1) {
			getRightChild().deleteNode(key,root);

		} else {
			getLeftChild().deleteNode(key,root);
		}

	}
	
	public NodeBST<K,T> maxIzquierdo(NodeBST<K,T> varAux){
		
		if(varAux.getRightChild() != null) {
			
			varAux=varAux.getRightChild().maxIzquierdo(varAux);
			
		}
		
		return varAux;
		
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeBST<K, T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeBST<K, T> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBST<K, T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeBST<K, T> rightChild) {
		this.rightChild = rightChild;
	}

}
