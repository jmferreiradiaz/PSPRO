package ejercicio3;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] comando = sc.nextLine().split(" ");

        ProcessBuilder pb = new ProcessBuilder(comando);

        pb.inheritIO();
        sc.close();

        try {
            Process p = pb.start();
            //Esperar a que el proceso termine
            p.waitFor();

            System.out.println("El proceso ha terminado");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
