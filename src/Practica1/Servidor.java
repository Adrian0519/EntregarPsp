package Practica1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto=6000;
        System.out.println("Esperando cliente");

        ServerSocket servidor=new ServerSocket(puerto);
        System.out.println("InfoJob" + servidor.getLocalPort());

        System.out.println("Esperando al 1 cliente");
        Socket cliente=servidor.accept();
        System.out.println("Puerto del cliente1 " +cliente.getLocalPort());
        System.out.println("Puerto direccion "+cliente.getInetAddress());
        System.out.println("Puerto " +cliente.getPort());


        System.out.println("Otro cliente pls");


        Socket cliente1=servidor.accept();
        System.out.println("Puerto del cliente1 " +cliente.getLocalPort());
        System.out.println("Puerto direccion "+cliente.getInetAddress());
        System.out.println("Puerto " +cliente.getPort());

        servidor.close();
    }
}
