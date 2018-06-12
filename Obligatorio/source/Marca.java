package source;

import nodoSimple.MyLinkedList;

public class Marca {
	
	private String name;
	
	private MyLinkedList<String> productoDeLaMarca;
	
	public Marca(String name) {
		this.name = name;
		this.productoDeLaMarca=new MyLinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<String> getProductoDeLaMarca() {
		return productoDeLaMarca;
	}

	public void addProductoDeLaMarca(String producto) {
		productoDeLaMarca.add(producto);
	}
	
    @Override
	public int hashCode() {

		int sumASCII=0;
		
    	for (int x=0;x<name.length();x++) {
    		
    	  sumASCII=sumASCII+name.codePointAt(x);
    		 
    	}
    	
    	
    	
    	return ((sumASCII/name.length()));
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean resultado=false;
		
		
		if (obj instanceof Marca) {
			
			if (getName().equals(((Marca) obj).getName())) {
				
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
