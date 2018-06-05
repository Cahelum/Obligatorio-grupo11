package heaps;



public class NodeH<K extends Comparable<K>, T> {
	
	K key;
	T data;
	

	public NodeH(K key, T data) {

		this.key = key;
		this.data = data;
		

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
	
	

}
