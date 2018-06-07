package source;
import java.util.HashMap;

public class Obligatorio {
	
    private HashMap<String,Pais> paises = new HashMap<>(); //Cambiar por hash
    private HashMap<String,Clase> clases= new HashMap<>(); //Cambiar por hash
    private HashMap<String,Marca> marcas= new HashMap<>(); //Cambiar por hash
    private HashMap<String,Empresa> empresas= new HashMap<>(); //Cambiar por hash
    private HashMap<String,Rubro> rubros= new HashMap<>(); //Cambiar por hash
    
    public void crearProductoSoloStrings(String name, String fantasyName, String status, String idProduct, String clase, String pais, String marca, String empresa, String ruc, String rubro) {
    	
    	int idProduct2= Integer.parseInt(idProduct);
    	clases.putIfAbsent(clase,new Clase(clase));
    	paises.putIfAbsent(pais, new Pais(pais));
    	marcas.putIfAbsent(marca, new Marca(marca));
    	empresas.putIfAbsent(empresa,new Empresa(empresa,ruc));
    	rubros.putIfAbsent(rubro, new Rubro(rubro));
    	crearProducto(name, fantasyName, status, idProduct2, clases.get(clase), paises.get(pais), marcas.get(marca), empresas.get(empresa), rubros.get(rubro));
    
    }

    public void crearProducto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca, Empresa empresa, Rubro rubro) {
    	
    	Producto producto = new Producto(name, fantasyName, status, idProduct, clase, pais, marca, empresa, rubro);
    	
    }
    
    
    
}

