package ListasTrabajo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        int puerto=6000;
        int contador=0;
        Persona[] personas = crearArray();
        ServerSocket servidor=new ServerSocket(puerto);
        Socket cliente=servidor.accept();
        InputStream inputStream=cliente.getInputStream();
        DataInputStream entrada=new DataInputStream(inputStream);
        OutputStream outputStream=cliente.getOutputStream();
        ObjectOutputStream salida=new ObjectOutputStream(outputStream);
        String nombre=entrada.readUTF();
        System.out.println(nombre);
        contador++;
        System.out.println("Esta es la " + contador + "del dia ");
        // Lanzamos el hilo para manejar al cliente
        HiloServidor hilo = new HiloServidor(nombre, cliente,personas);
        hilo.start();

    }

    public static Persona[] crearArray() {
        Persona[] personas = new Persona[5];
        personas[0] = new Persona("a", "Acceso a Datos");
        personas[1] = new Persona("b", "Acceso a Datos");
        personas[2] = new Persona("c", "Datos");
        personas[3] = new Persona("d", "a");
        personas[4] = new Persona("e", "Acceso ");
        return personas;
    }
}
