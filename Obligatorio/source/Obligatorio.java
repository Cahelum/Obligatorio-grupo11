package source;
import nodoSimple.MyLinkedList;

public class Obligatorio {
    private MyLinkedList<Pais> paises = new MyLinkedList<>(); //Cambiar por hash
    private MyLinkedList<Clase> clases= new MyLinkedList<>(); //Cambiar por hash
    private MyLinkedList<Marca> marcas= new MyLinkedList<>(); //Cambiar por hash
    private MyLinkedList<Empresa> empresa= new MyLinkedList<>(); //Cambiar por hash
    private MyLinkedList<Rubro> rubros= new MyLinkedList<>(); //Cambiar por hash
    
    public void crearProductoSoloStrings(String name, String fantasyName, String status, int idProduct, String clase, String pais, String marca, String empresa, MyLinkedList<Rubro> rubro) {
    	
    }

    public void crearProducto(String name, String fantasyName, String status, int idProduct, Clase clase, Pais pais, Marca marca, Empresa empresa, MyLinkedList<Rubro> rubros) {
    	Producto producto = new Producto(name, fantasyName, status, idProduct, clase, pais, marca, empresa, rubros);
    }
}

