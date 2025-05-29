package UdpDatos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        // Puerto del servidor al que se enviarán los datos UDP
        int puerto = 1234;

        // Crear un socket UDP para enviar y recibir paquetes
        DatagramSocket cliente = new DatagramSocket();

        // Obtener la dirección IP del host "localhost" (127.0.0.1)
        InetAddress inetAddress = InetAddress.getByName("Localhost");

        // Crear un objeto Producto con valores de ejemplo (por ejemplo, cantidad=12, precio=12)
        Producto producto = new Producto(12, 12);

        // Crear un flujo en memoria para guardar bytes
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Crear un flujo para escribir objetos serializables dentro del flujo de bytes
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        // Serializar el objeto producto y escribirlo en el flujo de bytes
        objectOutputStream.writeObject(producto);

        // Convertir el contenido del flujo en un arreglo de bytes que representa el objeto
        byte[] bytes = byteArrayOutputStream.toByteArray();

        // Crear un paquete UDP con los bytes del objeto, indicando destino IP y puerto
        DatagramPacket enviar = new DatagramPacket(bytes, bytes.length, inetAddress, puerto);

        // Enviar el paquete UDP al servidor
        cliente.send(enviar);

        // Informar por consola que se envió el pedido y se espera respuesta
        System.out.println("Pedido enviado esperando factura");

        // Crear un arreglo de bytes para recibir la respuesta (tamaño máximo 1024 bytes)
        byte[] bytes1 = new byte[1024];

        // Crear un paquete UDP vacío para recibir datos
        DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length);

        // Esperar y recibir un paquete UDP del servidor (bloquea hasta recibir)
        cliente.receive(datagramPacket);

        // Convertir los bytes recibidos en un String, solo la parte válida del buffer
        String mensaje = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

        // Mostrar el mensaje recibido en consola
        System.out.println("Mensaje recibido: " + mensaje);
    }
}

