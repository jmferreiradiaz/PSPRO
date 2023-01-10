package conexionTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        try {
            // 1. CreaciÃ³n del socket servidor
            System.out.println("(Servidor): Abriendo conexiÃ³n...");
            ServerSocket socketServidor = new ServerSocket(50000);

            // 2. Espera y acepta conexiones
            System.out.println("(Servidor): Aceptando conexiÃ³n...");
            Socket socketCliente = socketServidor.accept();

            // 3. Flujos de entrada y salida
            System.out.println("(Servidor): Abriendo flujos de entrada y salida...");
            InputStream is = socketCliente.getInputStream();
            OutputStream os = socketCliente.getOutputStream();

            // 4. Intercambiar datos con el cliente
            System.out.println("(Servidor): Leo mensaje del cliente");
            System.out.println("Mensaje del cliente: " + is.read());

            System.out.println("(Servidor): EnvÃ­o mensaje al cliente con 7...");
            os.write(7);

            // 5. Cerramos flujos de lectura y escritura
            is.close();
            os.close();

            // 6. Cerramos la conexiÃ³n
            socketCliente.close();
            socketServidor.close();
        }
        catch (IOException e) {
            System.err.println("Error: Error al crear el socket en el puerto 50000");
        }
    }
}