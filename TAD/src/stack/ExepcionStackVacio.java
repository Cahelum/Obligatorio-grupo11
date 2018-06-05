package stack;
public class ExepcionStackVacio extends Exception {

	public ExepcionStackVacio() {
		super();
	}
     public String toString(){
    	 return "el stack esta vacio";
     }
}
