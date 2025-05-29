package UdpObjetosDefini;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

public class ServerUDP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto = 1000;
        DatagramSocket socket = new DatagramSocket(puerto);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        System.out.println("Esperando paquete...");
        socket.receive(packet);

        // Usa getLength para limitar los bytes a leer
        ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Producto producto = (Producto) ois.readObject();
        System.out.println("Producto recibido: " + producto);

        socket.close();
    }
}




