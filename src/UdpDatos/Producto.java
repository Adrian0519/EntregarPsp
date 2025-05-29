package UdpDatos;

import java.io.Serializable;

public class Producto implements Serializable {
    int precio;
    int cantidad;

    public Producto(int precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
