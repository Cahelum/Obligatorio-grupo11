
public class Producto {
	
	private String name;
	
	private String fantasyName;
	
	private String status;
	
	public Producto(String name, String fantasyName, String status) {
		super();
		this.name = name;
		this.fantasyName = fantasyName;
		this.status = status;
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
	
}
