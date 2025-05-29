package UdpDefi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        int puerto=9876;
        DatagramSocket servidor=new DatagramSocket(puerto);
        byte[]bytes=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
        servidor.receive(datagramPacket);
        String nombre = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(nombre);
    }
}
