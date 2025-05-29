package OperacionesU;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) throws IOException {
        //1 elegimos el puerto
        int puerto=1234;
        //2 iniciamos el servidor.
        DatagramSocket servidor=new DatagramSocket(1234);
        //3 preparamos las zonas para desempaquetar los bytes indicandole un tamaño
        byte[]recibeBytes=new byte[1024];
        byte[]recibeBytes2=new byte[1024];
        //4 le indicamos en que paquete se van a introducir
        DatagramPacket paquete1=new DatagramPacket(recibeBytes, recibeBytes.length);
        DatagramPacket packet2=new DatagramPacket(recibeBytes2, recibeBytes2.length);
        //5 recivimos los datos en el paquete.
        servidor.receive(paquete1);
        servidor.receive(packet2);
        //6Desempaquetamos y casteamos a string para poder leerlo.
        String dato1=new String(paquete1.getData(),0,paquete1.getLength());
        String dato2=new String(packet2.getData(),0,packet2.getLength());
        System.out.println("Se llama " + dato1 + " con apellidos " + dato2);
        String completo=dato1 + " " + dato2;
        //7 Pasamos completo a bytes.
        byte[]bytes=completo.getBytes();
        //8 obtenemos la direccion y puerto del cliente.
        InetAddress inetAddress=paquete1.getAddress();
        int puertoCliente=paquete1.getPort();
        //9 lo empaquetamos indicando lo que empaquetamos el tamaño del paquete la direccion y el puerto y lo enviamos.
        DatagramPacket paquete=new DatagramPacket(bytes, bytes.length,inetAddress,puertoCliente);
        servidor.send(paquete);
    }
}
