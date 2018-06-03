import binaryTree.MyBinaryTree;

public class Pais {

    private String name;

    private MyBinaryTree<Integer, Producto> productosPais;

    public Pais(String name) {
        this.name = name;
        this.productosPais = new MyBinaryTree<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProductoPais(Producto producto) {
        productosPais.insert(producto.getIdProduct(), producto);
    }
}
