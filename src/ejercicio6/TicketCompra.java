package ejercicio6;

import java.util.Scanner;

public class TicketCompra {
    public static void main(String[] args) {
        int codProd, cant;
        double precio, total;

        Scanner sc = new Scanner(System.in);
        //System.out.print("Introduzca el código del producto");
        codProd = sc.nextInt();
        //System.out.print("Introduzca el precio del producto");
        precio = sc.nextDouble();
        //System.out.print("Introduzca el cantidad del producto");
        cant = sc.nextInt();

        total = precio * cant;

        System.out.printf("%d - %.2f -%d - %.2f\n",codProd, precio, cant, total);
        sc.close();
    }


}
