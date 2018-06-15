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

	private Rubro rubro;

	public Producto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca,
			Empresa empresa, Rubro rubro, String nroHab) {

		this.name = name;
		this.fantasyName = fantasyName;
		this.status = status;
		this.idProduct = idProduct;
		this.clase = clase;
		this.pais = pais;
		this.marca = marca;
		this.empresa = empresa;
		this.rubro=rubro;
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
