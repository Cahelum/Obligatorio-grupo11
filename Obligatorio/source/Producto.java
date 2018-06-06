package source;
import nodoSimple.MyLinkedList;

public class Producto {
	
	private String name;
	
	private String fantasyName;
	
	private String status;

    private int idProduct;
	
	private Rubro rubro;

	private Pais pais;

	private Marca marca;

	private Empresa empresa;
	
	private Clase clase;

    public Producto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca, Empresa empresa, Rubro rubro) {
		super();
		this.name = name;
		this.fantasyName = fantasyName;
		this.status = status;
        this.idProduct = idProduct;
        this.clase=clase;
        this.pais=pais;
        this.marca=marca;
        this.empresa=empresa;
        this.rubro=rubro;
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
	
}
