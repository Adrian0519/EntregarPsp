package MiPrimerUDP;

import java.io.IOException;
import java.net.*;
import java.net.spi.InetAddressResolver;

public class Cliente {
    public static void main(String[] args) throws IOException {
        int puerto =1234;
        DatagramSocket cliente=new DatagramSocket();
        InetAddress direccionIP= InetAddress.getByName("LocalHost");

        String mensaje="Hola cortesia del cliente";
        byte[]sendData=mensaje.getBytes();
        DatagramPacket enviarPaquete=new DatagramPacket(sendData, sendData.length,direccionIP,puerto);
        cliente.send(enviarPaquete);
    }
}
