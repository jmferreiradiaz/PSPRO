package ejercicio7;

import java.util.Scanner;

public class ImprimirIP {
    public static void main(String[] args) {
        String ip = new String("");
        Scanner sc = new Scanner(System.in);

        for (int i=0; i< 10; i++ ){
            ip = sc.nextLine();
            String [] ipArray = ip.split("\\.");
            int primerOcteto = Integer.parseInt(ipArray[0]);
            if (primerOcteto <= 223){
                System.out.println(ip);
            }
        }
    }
}
