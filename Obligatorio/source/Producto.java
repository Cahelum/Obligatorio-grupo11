package source;

public class Producto {

	private String name;

	private String fantasyName;

	private String status;

	private String nroHab;

	private int idProduct;

	private Pais pais;

	private Marca marca;

	private Empresa empresa;

	private Clase clase;

	private boolean exp;

	private boolean elab;

	public Producto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca,
			Empresa empresa, boolean exp, boolean elab, String nroHab) {

		this.name = name;
		this.fantasyName = fantasyName;
		this.status = status;
		this.idProduct = idProduct;
		this.clase = clase;
		this.pais = pais;
		this.marca = marca;
		this.empresa = empresa;
		this.exp = exp;
		this.elab = elab;
		this.nroHab = nroHab;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNroHab() {
		return nroHab;
	}

	public void setNroHab(String nroHab) {
		this.nroHab = nroHab;
	}

	public String getRubro() {
		if (elab == true & exp == true) {
			return "expendedor-elaborador";
		} else if (elab == false & exp == true) {
			return "expendedor";
		} else {
			return "elaborador";
		}
	}
	
	public void setExp(boolean exp) {
		this.exp = exp;
	}

	public void setElab(boolean elab) {
		this.elab = elab;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

}
