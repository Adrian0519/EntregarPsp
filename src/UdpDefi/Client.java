package UdpDefi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int puerto=9876;
        DatagramSocket cliente = new DatagramSocket();
        InetAddress inetAddress=InetAddress.getByName("localhost");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dime un nombre");
        String nombre=scanner.nextLine();
        byte[]bytes=new byte[1024];
        bytes=nombre.getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length,inetAddress,puerto);
        cliente.send(datagramPacket);
    }
}
