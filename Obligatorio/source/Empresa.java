package source;
public class Empresa {
	
	private String name;
	
	private String ruc;
	
	private int nroProductos;

	public Empresa(String name, String ruc) {
		this.name=name;
		this.ruc=ruc;
		this.nroProductos=0;
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
	
	
}
