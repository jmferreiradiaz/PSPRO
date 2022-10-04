package ejercicio4;

import java.io.File;
import java.io.IOException;

public class Ejercicio4 {

    public static void main(String[] args) {
        String[] comando = {"java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio2\\ProcesoLento.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.redirectOutput(new File("C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio4\\salidaProcesoLento.txt"));

        //pb.inheritIO();

        try {
            Process p = pb.start();
            while (p.isAlive()){
                System.out.println("Proceso sigue en ejecución");
                Thread.sleep(1000);
            }

            System.out.println("Proceso ha muerto");
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
