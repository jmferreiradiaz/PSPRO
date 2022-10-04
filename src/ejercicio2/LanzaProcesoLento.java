package ejercicio2;

import java.io.File;
import java.io.IOException;

public class LanzaProcesoLento {

    public static void main(String[] args) {
        String[] comando = {"java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio2\\LanzaProcesoLento.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();

            while (p.isAlive()){
                System.out.println("Proceso sigue en ejecución");
                Thread.sleep(1000);
            }

            System.out.println("Proceso ha muerto");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
