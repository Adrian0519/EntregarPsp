package Practica1;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto = 6000;
        System.out.println("Conexion con el servidor iniciada ...");
        Socket cliente=new Socket(host,puerto);
        cliente.close();
    }
}
