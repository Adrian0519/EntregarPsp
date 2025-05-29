package UdpDatos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Puerto en el que el servidor escuchará los paquetes UDP
        int puerto = 1234;

        // Crear un socket UDP y vincularlo al puerto especificado
        DatagramSocket servidor = new DatagramSocket(1234);

        // Crear un arreglo de bytes para almacenar los datos recibidos (buffer)
        byte[] bytes1 = new byte[1024];

        // Crear un paquete UDP para recibir datos, con el buffer definido
        DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length);

        // Esperar a recibir un paquete UDP (bloquea hasta que llega un paquete)
        servidor.receive(datagramPacket);

        // Crear un flujo de bytes a partir de los datos recibidos (solo la parte válida)
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                datagramPacket.getData(), 0, datagramPacket.getLength());

        // Crear un flujo para deserializar objetos desde el flujo de bytes
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        // Leer y convertir el objeto Producto que se envió desde el cliente
        Producto producto = (Producto) objectInputStream.readObject();

        // Mostrar en consola el objeto recibido (para debug o verificación)
        System.out.println("La mierda " + producto);

        // Obtener los datos del producto para hacer la operación
        int cantidad = producto.getCantidad();
        int precio = producto.getPrecio();

        // Calcular el precio total multiplicando cantidad por precio unitario
        int precioTotal = cantidad * precio;

        // Crear un mensaje de respuesta con el resultado calculado
        String mensajeRespuesta = "Precio total: " + precioTotal + "€";

        // Convertir el mensaje de texto en bytes para enviar por UDP
        byte[] respuestaBytes = mensajeRespuesta.getBytes();

        // Obtener la dirección IP y puerto del cliente desde el paquete recibido
        InetAddress direccionCliente = datagramPacket.getAddress();
        int puertoCliente = datagramPacket.getPort();

        // Crear un paquete UDP para enviar la respuesta al cliente, usando su IP y puerto
        DatagramPacket respuesta = new DatagramPacket(respuestaBytes, respuestaBytes.length,
                direccionCliente, puertoCliente);

        // Enviar el paquete de respuesta al cliente
        servidor.send(respuesta);

        // Informar en consola que la respuesta fue enviada
        System.out.println("Respuesta enviada al cliente.");

        // Cerrar el socket UDP del servidor (liberar recursos)
        servidor.close();
    }
}


