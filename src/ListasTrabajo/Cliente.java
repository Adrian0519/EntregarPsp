package ListasTrabajo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        String localhost="localhost";
        int puerto=6000;
        Socket cliente=new Socket(localhost,puerto);
        OutputStream outputStream=cliente.getOutputStream();
        DataOutputStream salida=new DataOutputStream(outputStream);
        InputStream inputStream=cliente.getInputStream();
        ObjectInputStream entrada=new ObjectInputStream(inputStream);
        System.out.println("Servidor iniciado");
        System.out.println("Inserte un nombre");
        String nombre=scanner.nextLine();
        salida.writeUTF(nombre);
        Persona persona= (Persona) entrada.readObject();
        if (persona!=null){
            System.out.println(persona);
        }else {
            System.out.println("Error, error, erro, fail, 間違い, 错误, ошибка, lỗi, σφάλμα, errore, خطأ, 에러, hatası, fout, błąd, λάθος, hibás, eroare, ralat, σφάλμα, қате, помилка, səhv, שגיאה, त्रुटि, பிழை, نقص, қате, भूल, エラー, 오류, помилка, መሳረያ ስህተት, грешка, ຂໍ້ຜິດພາດ, ก ำ ลัง ผิด พลาด, gabim, त्रुटी, दोष, fel, fej, қате, hitilafu, hibak, səhvlər, gabime, fel, flaws, missatge d'error, қате хабар, կասեցում, పొరపాటు, ຂໍ້ຜິດພາດ, ŝarĝo-eraro");

        }

    }
}
