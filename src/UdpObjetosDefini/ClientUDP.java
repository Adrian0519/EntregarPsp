package UdpObjetosDefini;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int puerto = 1000;
        DatagramSocket cliente = new DatagramSocket();

        Producto producto = new Producto(754, 3);

        // 1. Crear un ByteArrayOutputStream para almacenar bytes en memoria
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // 2. Crear ObjectOutputStream que escribe objetos en el byteArrayOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        // 3. Escribir el objeto producto en el ObjectOutputStream (serializar)
        objectOutputStream.writeObject(producto);

        // 4. Cerrar el ObjectOutputStream para terminar la escritura
        objectOutputStream.close();

        // 5. Obtener el arreglo de bytes que contiene el objeto serializado
        byte[] bytes = byteArrayOutputStream.toByteArray();

        // 6. Crear el DatagramPacket con los bytes serializados, la dirección y el puerto del servidor
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, puerto);

        // 7. Enviar el paquete al servidor
        cliente.send(datagramPacket);

        // 8. Cerrar el socket para liberar recursos
        cliente.close();
    }
}

