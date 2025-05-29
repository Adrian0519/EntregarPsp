package ObjetosUdp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ClienteCoche {
    public static void main(String[] args) throws IOException {
        Coche coche=new Coche("Ferrari","1234ba",123321);
        int puerto=1234;
        DatagramSocket cliente=new DatagramSocket();
        InetAddress inetAddress=InetAddress.getByName("localhost");

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(coche);
        byte[]bytes= byteArrayOutputStream.toByteArray();

        DatagramPacket enviar=new DatagramPacket(bytes,bytes.length,inetAddress,puerto);
        cliente.send(enviar);
        System.out.println("Coche enviado al server");
    }
}
