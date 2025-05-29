package OperacionesU;

import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        //1 paso configurar el puerto.
        int puert=1234;
        //2 paso asignar la ip
        DatagramSocket cliente=new DatagramSocket();
        //3 paso asignar la direccion
        InetAddress direccion=InetAddress.getByName("LocalHost");
        //4 paso pedir el nombre y apellido y pasarlo a bytes y luego convertirlos a bytes
        Scanner scanner=new Scanner(System.in);
        System.out.println("Inserta el nombre");
        String nombre= scanner.nextLine();
        byte[]mensajeDato1=nombre.getBytes();
        System.out.println("Inserta el 2 valor");
        String apellido= scanner.nextLine();
        byte[]mensajeDato2=apellido.getBytes();
        //5 paso empaquetarlos
        DatagramPacket enviarDato1=new DatagramPacket(mensajeDato1,mensajeDato1.length,direccion,puert);
        DatagramPacket enviarDato2=new DatagramPacket(mensajeDato2,mensajeDato2.length,direccion,puert);
        //6 paso enviarlos
        cliente.send(enviarDato1);
        cliente.send(enviarDato2);
        //7 Preparamos para recibir de vuelta el paquete del servidor.
        byte[]bytes=new byte[1024];
        DatagramPacket datagramPacket1=new DatagramPacket(bytes,bytes.length);
        cliente.receive(datagramPacket1);
        //8 Lo desempaquetamos y mostramos
        String dato=new String(datagramPacket1.getData(),0,datagramPacket1.getLength());
        System.out.println(dato);

    }
}
