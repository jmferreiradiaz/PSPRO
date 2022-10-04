package ejercicio6;

import java.io.File;
import java.io.IOException;

public class lanzarTicketCompra {
    public static void main(String[] args) {
        String[] comando = {"java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio6\\TicketCompra.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio6\\ticketCompra.txt")));

        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
