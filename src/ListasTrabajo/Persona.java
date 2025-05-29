package ListasTrabajo;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String trabajo;


    public Persona(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", trabajo='" + trabajo + '\'' +
                '}';
    }


}
