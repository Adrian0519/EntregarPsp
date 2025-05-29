package ObjetosUdp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorCochesUdp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto=1234;
        DatagramSocket servidor=new DatagramSocket(puerto);
        byte[]bytes=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
        servidor.receive(datagramPacket);

        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(datagramPacket.getData(),0, datagramPacket.getLength());
        ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
        Coche coche=(Coche) objectInputStream.readObject();
        System.out.println(coche);
        servidor.close();
    }
}
