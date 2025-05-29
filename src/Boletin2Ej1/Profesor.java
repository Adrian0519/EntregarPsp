package Boletin2Ej1;

import java.io.Serializable;

public class Profesor implements Serializable {
    int idProfesor;
    String nombre;
    Asignatura [] asignaturas;
    Especialidad esp;

    public Profesor(int idProfesor, String nombre, Asignatura[] asignaturas, Especialidad esp) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.esp = esp;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Especialidad getEsp() {
        return esp;
    }

    public void setEsp(Especialidad esp) {
        this.esp = esp;
    }
}
