package source;
public class Rubro {
	private String rubro;

	public Rubro(String rubro) {
		this.rubro = rubro;
	}
	
	
	
	public String getRubro() {
		return rubro;
	}



	public void setRubro(String rubro) {
		this.rubro = rubro;
	}



	/*@Override
	public int hashCode() {

		int sumASCII=0;
		
    	for (int x=0;x<rubro.length();x++) {
    		
    	  sumASCII=sumASCII+rubro.codePointAt(x);
    		 
    	}
    	
    	System.out.println("123456987kxjcxjocxv");
    	
    	return ((sumASCII/rubro.length()));
		
		
	}*/
	
	@Override
	public boolean equals(Object obj) {
		boolean resultado=false;
		
		
		if (obj instanceof Rubro) {
			
			if (getRubro().equals(((Rubro) obj).getRubro())) {
				
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
