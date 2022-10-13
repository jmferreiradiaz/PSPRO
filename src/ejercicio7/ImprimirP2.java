package ejercicio7;

import java.util.Scanner;

public class ImprimirP2 {
    public static void main(String[] args) {
        String ip = new String("");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            ip = sc.nextLine();
            String[] ipArray = ip.split("\\.");
            int primerOcteto = Integer.parseInt(ipArray[0]);
            if (primerOcteto <= 127) {
                System.out.println(ip + " Es de clase A");
            } else if (primerOcteto <= 191) {
                System.out.println(ip + " Es de clase B");
            } else if (primerOcteto <= 224) {
                System.out.println(ip + " Es de clase C");
            }
        }
    }
}
