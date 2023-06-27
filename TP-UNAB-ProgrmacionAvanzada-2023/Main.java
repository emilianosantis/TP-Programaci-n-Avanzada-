import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("1._Añadir un Producto.");
        System.out.println("2._Mostrar todos los productos.");
        System.out.println("3._Buscar un producto.");
        System.out.println("4._Ventas");
        System.out.println("5._Entrar como administrador");
        System.out.println("6._Salir del programa");
        System.out.println("SELECCIONE UNA OPCIION");
    }

    public static void menuAdministrador(){
        System.out.println("1._Modificar nombre de un producto.");
        System.out.println("2._Modificar stock de un producto.");
        System.out.println("3._Modificar precio de un producto.");
        System.out.println("4._Vender un producto con descuento.");
        System.out.println("5._Volver al menu anterior");
    }

    private static void salir(){
        System.out.println("SALIENDO DEL PROGRAMA.....");
        System. exit(0);
    }

    public static void main(String[] args) {

        System.out.println("SISTEMA DE GESTION DE TIENDA");
        System.out.println("*****************************");
        Scanner entrada = new Scanner(System.in);
        Supermercado mi_Mercado = new Supermercado("ArgenChinos");
        Hashtable< String , Producto> listaDeProductos = new Hashtable<>();

        int opcion = 0;

        do {
            try {
                menu();
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1: {

                        entrada.nextLine();
                        System.out.println("Nombre del producto");
                        String nombre = entrada.nextLine();
                        String nombreBonito = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();

                        System.out.println("Cantidad: ");
                        int cantidad = Integer.parseInt(entrada.nextLine());

                        System.out.println("Precio por unidad");
                        double precio = Double.parseDouble(entrada.nextLine());

                        Producto nuevoProducto = new Producto(nombreBonito, cantidad, precio);

                        mi_Mercado.agregarProducto(nuevoProducto, listaDeProductos);

                        break;
                    }
                    case 2: {;
                        System.out.println("Productos: ");
                        Enumeration productos = listaDeProductos.keys();

                        while (productos.hasMoreElements()) {
                            Object clave = productos.nextElement();
                            Producto producto = listaDeProductos.get(clave);
                            System.out.println(producto.datosDelProducto());
                        }
                        break;
                    }
                    case 3: {
                        entrada.nextLine();
                        System.out.println("Nombre del producto a buscar: ");
                        String palabraBuscada = entrada.nextLine();

                        Producto productoEncontrado = mi_Mercado.buscarProducto(palabraBuscada, listaDeProductos);

                        if (productoEncontrado != null) {
                            System.out.println("Producto encontrado");
                            System.out.println(productoEncontrado.datosDelProducto());

                        } else {
                            System.out.println("No se encontró el producto");

                        }

                        break;
                    }
                    case 4: {
                        entrada.nextLine();
                        System.out.println("Nombre del Producto: ");
                        String nombreProducto = entrada.nextLine();

                        Producto productoAVender = mi_Mercado.buscarProducto(nombreProducto, listaDeProductos);

                        if (productoAVender == null){
                            System.out.println("NO SE ENCONTRÓ EL PRODUCTO" );

                        } else {

                            System.out.println(mi_Mercado.buscarProducto(nombreProducto, listaDeProductos).datosDelProducto());

                            System.out.println("Cantidad a comprar: ");
                            int cantidad = Integer.parseInt(entrada.nextLine());

                            double precioTotal = mi_Mercado.venderProducto(productoAVender, cantidad, listaDeProductos);

                            System.out.println("TOTAL VENTA: " + "$" + precioTotal + "\n"
                                    + "El stock fue modificado: " + "\n"
                                    + (mi_Mercado.buscarProducto(nombreProducto, listaDeProductos) != null ?
                                    mi_Mercado.buscarProducto(nombreProducto, listaDeProductos).datosDelProducto():
                                    "No hay más Stock" ));
                        }


                        break;

                    }
                    case 5: {
                        System.out.println("Entrar como administrador");
                        System.out.println("Ingrese la contraseña:");

                        int pass = entrada.nextInt();

                        if (pass == 123){

                                Administrador administrador = new Administrador(mi_Mercado.nombreMercado);

                                menuAdministrador();
                                opcion = entrada.nextInt();

                                switch (opcion){
                                    case 1: {
                                        entrada.nextLine();
                                        System.out.println("Ingrese el producto a modificar: ");
                                        String nombreProducto = entrada.nextLine();

                                        entrada.nextLine();
                                        System.out.println("Ingrese el nuevo nombre: ");
                                        String nuevoNombre = entrada.nextLine();

                                        administrador.modificarNombreProducto(nombreProducto, listaDeProductos, nuevoNombre);
                                        break;
                                    }
                                    case 2: {
                                        entrada.nextLine();
                                        System.out.println("Ingrese el producto a modificar: ");
                                        String nombreProducto = entrada.nextLine();

                                        entrada.nextLine();
                                        System.out.println("Cantidad a sumar: ");
                                        String nuevoNombre = entrada.nextLine();
                                        
                                        administrador.modificarNombreProducto(nombreProducto, listaDeProductos, nuevoNombre);
                                        break;
                                    }
                                    case 3: {

                                    }
                                }
                           } else {
                            System.out.println("Contraseña erronea");
                        }
                        break;

                    }

                }


            } catch (InputMismatchException error) {
                System.err.println("Error de entrada");
                // System.err.println(error);
                entrada.nextLine();

            }

        } while (opcion != 6);

        salir();
    }
}

