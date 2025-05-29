package Practica2Registro;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor iniciado. Esperando conexión...");

        Socket cliente = serverSocket.accept();
        System.out.println("Cliente conectado.");

        // Flujo de entrada desde el cliente (lo que recibimos)
        InputStream entrada = cliente.getInputStream();
        DataInputStream usaEntrada = new DataInputStream(entrada);

        // Flujo de salida hacia el cliente (lo que enviamos)
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream usaSalida = new DataOutputStream(salida);

        // Leer número del cliente
        int numero = usaEntrada.readInt();
        System.out.println("El número enviado fue: " + numero);

        // Procesar
        int numero2 = numero * numero;
        int numero4 = numero2 * numero2;

        System.out.println("Número al cuadrado: " + numero2);
        System.out.println("Número a la cuarta: " + numero4);

        // Enviar respuesta al cliente
        usaSalida.writeInt(numero2);
        usaSalida.writeInt(numero4);

        // Cerrar conexiones
       usaEntrada.close();
        usaSalida.close();
        cliente.close();
        serverSocket.close();
    }
}

