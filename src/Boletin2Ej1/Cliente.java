package Boletin2Ej1;

/*
Crea las siguientes clases con los siguientes atributos, los constructores y los métodos get y
set necesarios:
Clase Asignatura:
int id;
String nombreAsig;
Clase Especialidad:
int id;
String nombreEsp;
Clase Profesor:
int idProfesor;
String nombre;
Asignatura [] asignaturas;
Especialidad esp;
Un profesor podrá impartir hasta 3 asignaturas.
Utilizando sockets TCP, implementar un programa servidor que inicialice un array de 5 objetos
de tipo Profesor. El servidor aceptará conexiones de clientes en un bucle infinito. Cada vez
que se conecte un cliente, el servidor le asignará un id, que empezará en 1 e irá
incrementándose cada vez que se conecta un nuevo cliente. El servidor recibirá del cliente un
idProfesor y le devolverá el objeto Profesor asociado.
Crea un programa cliente en el que se introduzca por teclado el idProfesor que se desea
consultar. Dicho programa recogerá datos hasta recibir un * por parte del usuario.
Si el idProfesor no se encuentra registrado, el servidor le devolverá un objeto Profesor con
datos vacíos
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String localhost = "localhost";
        int puerto = 6000;
        Socket cliente = new Socket(localhost, puerto);
        InputStream inputStream=cliente.getInputStream();
        DataInputStream entrada=new DataInputStream(inputStream);
        OutputStream outputStream=cliente.getOutputStream();
        DataOutputStream salida=new DataOutputStream(outputStream);
        System.out.println("Conexion con el server iniciada");
        System.out.println("Inserte la id ");
        int id= scanner.nextInt();
    }

}
