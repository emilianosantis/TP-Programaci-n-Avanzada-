
public class Productos {
    private String nombreDelProducto ;
    private int cantidadDelProducto;
    private double precioUnitario;
    public boolean stock(int numero) {
        if (numero <= cantidadDelProducto){
            numero -= cantidadDelProducto;
            return true;
        }
        else {
            System.out.println("NO HAY MAS");
            return false;
        }

    }
    public Productos(String nombreDelProducto , int cantidadDelProducto , double precioUnitario){
        this.nombreDelProducto = nombreDelProducto;
        this.cantidadDelProducto = cantidadDelProducto;
        this.precioUnitario = precioUnitario;
    }
    public String getNombreDelProducto(){
        return nombreDelProducto;
    }
    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }
    public int getCantidadDelProducto(){
        return cantidadDelProducto;
    }
    public void setCantidadDelProducto(int cantidad){
        this.cantidadDelProducto = cantidad;
    }
    public double getPrecioUnitario() {  return precioUnitario;  }
    public void setPrecioUnitario(double precioUnitario){
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString(){
        return "NOMBRE:"+ nombreDelProducto + ", CANTIDAD:" + cantidadDelProducto+ ", PRECIO DE LA UNIDAD: "+ '$' + precioUnitario;
    }

}
