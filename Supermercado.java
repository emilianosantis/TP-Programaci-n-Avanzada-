import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermercado {
    String nombreMercado;
    static Hashtable < String , Productos> listaDeProductos = new Hashtable<>();
    public Supermercado(String nombre){
        this.nombreMercado=nombre;
    }
    public void agregarProducto(Productos a){
        String clave = a.getNombreDelProducto();
        if(!listaDeProductos.containsKey(clave)){
            listaDeProductos.put(clave , a);
            System.out.println("Se ha añadido correctamente el producto a la lista.");
        }else{
            System.out.println("Error , no se pudo agregar.");
        }
    }
    public Productos buscarProducto(String nombre){
        Productos a;
        if(listaDeProductos.containsKey(nombre)){
            a = (Productos) listaDeProductos.get(nombre);
            System.out.println("Producto encontrado");
            System.out.println(a);
            return a;
        }else {
            System.out.println("No se pudo encontrar el producto");
            return null;
        }
    }
    public double venderProducto(String nombre,int cantidad){
        Productos a = buscarProducto(nombre);
        double stock = 0;

        if(a == null){
            stock = -1;
        } else if (a.stock(cantidad)) {
            stock = cantidad*a.getPrecioUnitario();
            if(a.getCantidadDelProducto()==0){
                listaDeProductos.remove(nombre);
            }
            return stock;
        }
    return stock;
    }
    public static void menu(){
        System.out.println("1._Añadir un Producto.");
        System.out.println("2._Mostrar todos los productos.");
        System.out.println("3._Buscar un producto.");
        System.out.println("4._Ventas");
        System.out.println("5._Salir del programa");
        System.out.println("SELECCIONE UNA OPCIION");
    }

    public static void main(String[] args) {

        System.out.println("SISTEMA DE GESTION DE TIENDA");
        System.out.println("***********");
        Scanner entrada = new Scanner(System.in);
        Supermercado mi_Mercado = new Supermercado("ArgenChinos");
        int opcion = 0;

        do {
            try {
                menu();
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre del producto");
                        String nombre = entrada.nextLine();

                        System.out.println("CANTIDAD: ");
                        cad = entrada.nextLine();
                        int cantidad = Integer.parseInt(cad);

                        System.out.println("Precio por unidad");
                        cad = entrada.nextLine();
                        double pvp = Double.parseDouble(cad);

                        Productos aux = new Productos(nombre, cantidad, pvp);
                        mi_Mercado.agregarProducto(aux);

                        break;
                    }
                    case 2: {
                        Object clave;
                        Productos producto;
                        Enumeration e = listaDeProductos.keys();

                        System.out.println("Productos: ");

                        while (e.hasMoreElements()) {
                            clave = e.nextElement();
                            producto = (Productos)listaDeProductos.get(clave);
                            System.out.println(producto.toString());
                        }
                        break;
                    }
                    case 3: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre del producto a buscar: ");
                        cad = entrada.nextLine();

                        Productos producto = mi_Mercado.buscarProducto(cad);
                        if (producto != null) {
                            System.out.println("Nombre: " + producto.getNombreDelProducto() + ", Cantidad: " + producto.getCantidadDelProducto() + ", Precio por unidad: " + producto.getPrecioUnitario() + "$");
                            System.out.println("");
                        }
                        break;
                    }
                    case 4: {
                        String nombre;
                        entrada.nextLine();
                        System.out.println("Nombre del Producto: ");
                        nombre = entrada.nextLine();
                        System.out.println("Cantidad a comprar: ");
                        int cantidad = entrada.nextInt();
                        double venta = mi_Mercado.venderProducto(nombre, cantidad);
                        if (venta != 0 && venta != 1) {
                            System.out.println("TOTAL VENTA: " + venta + "$");
                        }
                        break;

                    }

                }


            } catch (InputMismatchException e) {
                entrada.nextLine();
                System.err.println("Error de entrada");

            }

        } while (opcion != 5);

        System.out.println("SALIENDO DEL PROGRAMA.....");

    }
}
