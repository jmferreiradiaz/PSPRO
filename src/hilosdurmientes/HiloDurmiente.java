package hilosdurmientes;

import org.w3c.dom.ranges.Range;

import java.util.Random;

public class HiloDurmiente extends Thread {

    private String nombre;

    public HiloDurmiente(String nombre){
        super();
        this.nombre = nombre;
    }

    public void run(){
        int numAle = (int)Math.floor(Math.random()*10+1);
        while (true){
            Thread hilo = currentThread();
            System.out.println("Soy el bucle"+hilo.getName()+"y estoy trabajando");
        }
    }

    public static void main(String[] args) {
        HiloDurmiente hilo1 = new HiloDurmiente("Hilo 1");
        HiloDurmiente hilo2 = new HiloDurmiente("Hilo 2");
        HiloDurmiente hilo3 = new HiloDurmiente("Hilo 3");
        HiloDurmiente hilo4 = new HiloDurmiente("Hilo 4");
        HiloDurmiente hilo5 = new HiloDurmiente("Hilo 5");
    }
}
