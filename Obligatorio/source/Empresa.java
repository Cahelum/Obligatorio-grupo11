package source;

import nodoSimple.MyLinkedList;

public class Empresa {
	
	private String name;
	
	private String ruc;
	
	private MyLinkedList<String> productosDeLaEmpresa;
	
	private int nroProductos;

	public Empresa(String name, String ruc) {
		this.name=name;
		this.ruc=ruc;
		this.productosDeLaEmpresa=new MyLinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getNroProductos() {
		return nroProductos;
	}

	public void setNroProductos(int nroProductos) {
		this.nroProductos = nroProductos;
	}

	public MyLinkedList<String> getProductosDeLaEmpresa() {
		return productosDeLaEmpresa;
	}

	public void addProductoDeLaEmpresa(String productoDeLaEmpresa) {
		productosDeLaEmpresa.add(productoDeLaEmpresa);
	}
	
	/*@Override
	public int hashCode() {

		int sumASCII=0;
		
    	for (int x=0;x<name.length();x++) {
    		
    	  sumASCII=sumASCII+name.codePointAt(x);
    		
    	}
    	
    	
    	
    	return ((sumASCII/name.length()));
		
		
	}*/
	
	@Override
	public boolean equals(Object obj) {
		boolean resultado=false;
		
		
		if (obj instanceof Empresa) {
			
			if (getName().equals(((Empresa) obj).getName())) {
				
			resultado=true;
			
			}else {
				resultado=false;
			}
			
			
			
		}else {
			resultado=false;
		}
		
		return resultado;
	}
	
	
}
