package hash;

public class NodeH<K,T> {
	
	K clave;
	T valor;
	boolean eliminado;
	
	public NodeH(K clave, T valor,boolean eliminado) {
		
		this.clave = clave;
		this.valor = valor;
		this.eliminado=eliminado;
		
	}
	
	public boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public K getClave() {
		return clave;
	}
	public void setClave(K clave) {
		this.clave = clave;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resultado=false;
		
		
		if (obj instanceof NodeH) {
			if(getEliminado()==false) {
				if (getClave().equals(((NodeH) obj).getClave())) {
				
					resultado=true;
			
				}else {
					resultado=false;
				}
			
			}
			
		}else {
			resultado=false;
		}
		
		return resultado;
	}
	

}
