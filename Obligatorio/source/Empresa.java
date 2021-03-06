package source;

import nodoSimple.MyLinkedList;

public class Empresa implements Comparable<Empresa>{
	
	private String name;
	
	private String ruc;
	
	private MyLinkedList<String> productosDeLaEmpresa;

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

	/*@Override
	public int compareTo(Empresa o) {
		Integer este = Integer.valueOf(this.getProductosDeLaEmpresa().size());
		Integer otro=Integer.valueOf(o.getProductosDeLaEmpresa().size());
		return este.compareTo(otro);
	
	}*/
	
	@Override
	public int compareTo(Empresa o) {
		Integer este = Integer.valueOf(this.getProductosDeLaEmpresa().size());
		Integer otro=Integer.valueOf(o.getProductosDeLaEmpresa().size());
		int resultado=0;
		if(este.compareTo(otro)==1) {
			resultado=1;
		}else if(este.compareTo(otro)==-1) {
			resultado=-1;
		}
		
		return resultado;
	
	}
	
	
}
