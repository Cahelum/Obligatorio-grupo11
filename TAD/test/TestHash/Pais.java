package TestHash;



public class Pais {

	private String name;
	

	public Pais(String name) {
	
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		
		int sumASCII = 0;

		for (int x = 0; x < name.length(); x++) {

			sumASCII = sumASCII + name.codePointAt(x);

		}

		return ((sumASCII / name.length()));

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
}