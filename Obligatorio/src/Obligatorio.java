import binaryTree.MyBinaryTree;

public class Obligatorio {
    private MyBinaryTree<String, Pais> paises = new MyBinaryTree<>();

    public void crearProducto(String name, String fantasyName, String status, int idProduct, String pais) {
        if (paises.find(pais) == null) {
            Pais pais1 = new Pais(pais);
            Producto producto = new Producto(name, fantasyName, status, idProduct);
            pais1.addProductoPais(producto);
            paises.insert(pais1.getName(), pais1);
        } else {
            Producto producto = new Producto(name, fantasyName, status, idProduct);
            paises.find(pais).addProductoPais(producto);
        }
    }
}

