package hash;

public interface HashTable<K,T>{
	
	
	
	public void insertar(K clave, T valor) throws ElementoYaExistenteException;

	public boolean pertenece(K clave);

	public void borrar(K clave);
	
	public T obtener(K clave);
	
	public void insertarFaltante(K clave, T valor);
	
	public int size();
	
}
