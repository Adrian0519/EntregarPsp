package MiPrimerUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUdp {
    public static void main(String[] args) throws IOException {
        int puerto=1234;
        DatagramSocket server=new DatagramSocket(1234);
        byte[]recibeBytes=new byte[1204];
        System.out.println("server esperando");
        DatagramPacket datagramPacket=new DatagramPacket(recibeBytes, recibeBytes.length);
        server.receive(datagramPacket);
        String mensaje =new String(datagramPacket.getData(),0, datagramPacket.getLength());
        System.out.println("Mensaje traducido : " + mensaje);

    }
}
