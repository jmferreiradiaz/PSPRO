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
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        HiloDurmiente hilo1 = new HiloDurmiente("Hilo 1");
        hilo1.start();
        HiloDurmiente hilo2 = new HiloDurmiente("Hilo 2");
        hilo2.start();
        HiloDurmiente hilo3 = new HiloDurmiente("Hilo 3");
        hilo3.start();
        HiloDurmiente hilo4 = new HiloDurmiente("Hilo 4");
        hilo4.start();
        HiloDurmiente hilo5 = new HiloDurmiente("Hilo 5");
        hilo5.start();
    }
}
