import java.util.Hashtable;

public class Administrador extends Supermercado{

    public Administrador(String nombreMercado) {
        super(nombreMercado);
    }

    public void modificarNombreProducto (String nombreProducto, Hashtable listaDeProductos, String nuevoNombre) {
       Producto producto = super.buscarProducto(nombreProducto, listaDeProductos);

       producto.setNombreDelProducto(nuevoNombre);
    }

    public void agregarCantidad (String nombreProducto, Hashtable listaDeProductos, int cantidadAgregada) {
        Producto producto = super.buscarProducto(nombreProducto, listaDeProductos);

       producto.setCantidadDelProducto(producto.getCantidadDelProducto() + cantidadAgregada);
    }
}
