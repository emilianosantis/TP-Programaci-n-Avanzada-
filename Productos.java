package Mercado;

public class Productos {

    private String nombre ;
    private int cantidad;
    private double precio;
    public Productos(String nombre , int cantidad , double precio){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public int getPrecio(){
        return cantidad;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public boolean stock(int numero) {
        if (numero <= cantidad){
            numero -= cantidad;
        }
        else {
            System.out.println("NO HAY MAS");
            return false;
        }
        return true;

    }
    @Override
    public String toString(){
        return "NOMBRE: "+ nombre + " CANTIDAD: "+ cantidad +" PRECIO DE LA UNIDAD: " + "$" + precio + "\n" ;
    }

}
