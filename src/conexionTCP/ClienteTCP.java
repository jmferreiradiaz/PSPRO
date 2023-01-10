package conexionTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {
    public static void main(String[] args) {
        try {
            //1 Creación del socket tipo cliente
            System.out.println("(Cliente):Creación de socket...");
            InetAddress direccion = InetAddress.getLocalHost();
            Socket socketCliente = new Socket(direccion,50000);

            //2 - Abrir flujos de lectura y escritura
            System.out.println("(Cliente): Apertura de flujos de entrada y salida");
            OutputStream os = socketCliente.getOutputStream();
            InputStream is = socketCliente.getInputStream();

            //3 - Intercambio de datos con el servidor
            System.out.println("(Cliente): Envia mensaje al servidor con 14");
            os.write(14);

            System.out.println("(Cliente): Lectura del mensaje del servidor");
            System.out.println("Mensaje recibido por el servidor: " + is.read());

            //4 - Cerrar flujos de lectura y escritura
            os.close();
            is.close();

        } catch (UnknownHostException e) {
            System.err.println("ERROR: no se encuentra el host");
            e.printStackTrace();
        } catch (IOException e){
            System.err.println("ERROR: Problema con la conexión");
            e.printStackTrace();
        }
    }
}
