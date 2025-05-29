package ListasTrabajo;

import java.io.*;
import java.net.Socket;

public class HiloServidor extends Thread{
    private String nombre;
    private Socket consultar;
    private Persona[]personas;


    public HiloServidor(String nombre, Socket consultar, Persona[] personas) {
        this.nombre = nombre;
        this.consultar = consultar;
        this.personas = personas;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = consultar.getInputStream();
            DataInputStream entrada = new DataInputStream(inputStream);

            OutputStream outputStream = consultar.getOutputStream();
            ObjectOutputStream salida = new ObjectOutputStream(outputStream);

            String nombre = entrada.readUTF();
            Persona personaEncontrada = null;

            for (Persona persona : personas) {
                if (persona.getNombre().equals(nombre)) {
                    personaEncontrada = persona;
                    break;
                }
            }

            // Enviar la persona o null si no se encontró
            salida.writeObject(personaEncontrada);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
