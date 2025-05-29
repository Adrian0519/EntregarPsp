package Boletin2Ej1;

import java.io.Serializable;

public class Especialidad implements Serializable {
    int id;
    String nombreEsp;

    public Especialidad(int id, String nombreEsp) {
        this.id = id;
        this.nombreEsp = nombreEsp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

}
