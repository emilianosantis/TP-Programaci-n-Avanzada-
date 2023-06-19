package Mercado;

import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Hashtable;

public class Supermercado {
    String nombreMercado;
    static Hashtable < String , Productos> lista = new Hashtable<>();
    public Supermercado(String nombre){
        this.nombreMercado=nombre;
    }
    public void inserta(Productos a){
        String clave = a.getNombre();
        if(!lista.containsKey(clave)){
            lista.put(clave , a);
            System.out.println("Se ha añadido correctamente el producto a la lista.");
        }else{
            System.out.println("Error, no se pudo agregar.");
        }
    }
    public Productos buscar(String nombre){
        Productos a;
        if(lista.containsKey(nombre)){
            a = (Productos) lista.get(nombre);
            System.out.println("Producto encontrado");
        }else {

            System.out.println("No se pudo encontrar el producto");
        }
        return null;
    }
    public double vende(String nombre,int numero){
        Productos a = buscar(nombre);
        double stock = 0;
        if(a == null){
            stock = -1;
        } else if (a.stock(numero)) {
            stock = numero*a.getPrecio();
            if(a.getCantidad()==0){
                lista.remove(nombre);
            }
        }
        return stock;
    }
    public static void menu(){
        System.out.println("1._Añadir un Producto.");
        System.out.println("2._Mostrar todos los productos.");
        System.out.println("3._Buscar un producto.");
        System.out.println("4._Ventas");
        System.out.println("5._Salir del programa");
        System.out.println("SELECCIONE UNA OPCION");
    }
    public static void salir(){
        System.out.println("Saliendo del Programa...");
    }
    public static void main(String[] args) {
        System.out.println("SISTEMA DE GESTION DE TIENDA");
        System.out.println("*****************************");
        Scanner entrada = new Scanner(System.in);
        Supermercado mi_Mercado = new Supermercado("Chinos");
        int opcion = 0;

        do {
            try {
                menu();
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre del articulo");
                        String nombre = entrada.nextLine();

                        System.out.println("CANTIDAD: ");
                        cad = entrada.nextLine();
                        int cantidad = Integer.parseInt(cad);

                        System.out.println("Precio por unidad");
                        cad = entrada.nextLine();
                        double pvp = Double.parseDouble(cad);

                        Productos aux = new Productos(nombre, cantidad, pvp);
                        mi_Mercado.inserta(aux);

                        break;
                    }
                    case 2: {
                        Object clave;
                        Productos producto;
                        Enumeration e = lista.keys();

                        System.out.println("Productos: ");

                        while (e.hasMoreElements()) {
                            clave = e.nextElement();
                            producto = (Productos)lista.get(clave);
                            System.out.println(producto.toString());
                        }
                        break;
                    }
                    case 3: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("Nombre:");
                        cad = entrada.nextLine();

                        Productos producto = mi_Mercado.buscar(cad);
                        if (producto != null) {
                            System.out.println("Nombre: " + producto.getNombre() + "Cantidad: " + producto.getCantidad() + "Precio: " + producto.getPrecio() + "$");
                            System.out.println("");
                        }
                        break;
                    }
                    case 4: {
                        String cad;
                        entrada.nextLine();
                        System.out.println("NOMBRE: ");
                        cad = entrada.nextLine();
                        System.out.println("CANTIDAD: ");
                        int cantidad = entrada.nextInt();
                        double venta = mi_Mercado.vende(cad, cantidad);
                        if (venta != 0 && venta != 1) {
                            System.out.println("TOTAL VENTA: " + "$" + venta );
                        }
                        break;

                    }

                }


            } catch (InputMismatchException e) {
                entrada.nextLine();
                System.err.println("Error de entrada");

            }

        } while (opcion != 5);

        salir();

    }
}