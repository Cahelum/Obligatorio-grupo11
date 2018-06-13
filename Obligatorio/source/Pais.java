package source;

import java.util.HashMap;
import nodoSimple.MyLinkedList;

public class Pais implements Comparable<Pais> {

    private String name;
    
    
    
    private MyLinkedList<String> productosPorPais;

    public Pais(String name) {
        this.name = name;
        this.productosPorPais=new MyLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public MyLinkedList<String> getProductosPorPais() {
		return productosPorPais;
	}

	public void agregarProductosPorPais(String producto) {
		this.productosPorPais.add(producto);// esta clave no esta completa
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
		
		
		if (obj instanceof Pais) {
			
			if (getName().equals(((Pais) obj).getName())) {
				
			resultado=true;
			
			}else {
				resultado=false;
			}
			
			
			
		}else {
			resultado=false;
		}
		
		return resultado;
	}
	@Override
	public int compareTo(Pais o) {
		Integer este = Integer.valueOf(this.getProductosPorPais().size());
		Integer otro = Integer.valueOf(o.getProductosPorPais().size());
		int resultado = 0;
		if (este.compareTo(otro) == 1) {
			resultado = 1;
		} else if (este.compareTo(otro) == -1) {
			resultado = -1;
		}

		return resultado;

	}
	
}
