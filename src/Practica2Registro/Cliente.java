package Practica2Registro;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        int numero, numero2, numero3;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserte su número:");
        numero = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        int puerto = 6000;
        String host = "localhost";

        Socket cliente = new Socket(host, puerto);
        System.out.println("Conexión iniciada");

        // Salida hacia el servidor
        OutputStream outputStream = cliente.getOutputStream();
        DataOutputStream fsalida = new DataOutputStream(outputStream);

        // Entrada desde el servidor
        InputStream inputStream = cliente.getInputStream();
        DataInputStream fsEntrada = new DataInputStream(inputStream);

        // Enviar número al servidor
        fsalida.writeInt(numero);

        // Recibir respuestas
        numero2 = fsEntrada.readInt();
        numero3 = fsEntrada.readInt();

        int grande=numero+numero2+numero3;

        System.out.println("La suma de todos los datos es " + grande);

        // Cerrar conexiones
        fsalida.close();
        fsEntrada.close();
        cliente.close();
    }
}

