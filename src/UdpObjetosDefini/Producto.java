package UdpObjetosDefini;

import java.io.Serializable;

public class Producto implements Serializable {
    private int cantidad;
    private int precio;

    public Producto(int cantidad, int precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

