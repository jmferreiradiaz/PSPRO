package ejercicio5;

import java.io.File;
import java.io.IOException;

public class LanzaPreguntaNombre {
    public static void main(String[] args) {
        String[] comando = {"java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio5\\PreguntaNombre.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);

        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectInput(new File("C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio5\\entrada.txt"));

        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

