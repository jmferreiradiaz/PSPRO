package hilosdurmientes;

import org.w3c.dom.ranges.Range;

import java.util.Random;

public class HiloDurmiente extends Thread {

    @Override
    public void run(){
        int numAle = (int)Math.floor(Math.random()*10+1);
        while (true){
            Thread hilo = currentThread();
            System.out.println("Soy el bucle "+hilo.getName()+" y estoy trabajando");
            try {
                Thread.sleep(100 * numAle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HiloDurmiente hilo1 = new HiloDurmiente();
        hilo1.setName("hilo1");
        hilo1.start();
        HiloDurmiente hilo2 = new HiloDurmiente();
        hilo2.setName("hilo2");
        hilo2.start();
        HiloDurmiente hilo3 = new HiloDurmiente();
        hilo3.setName("hilo3");
        hilo3.start();
        HiloDurmiente hilo4 = new HiloDurmiente();
        hilo4.setName("hilo4");
        hilo4.start();
        HiloDurmiente hilo5 = new HiloDurmiente();
        hilo5.setName("hilo5");
        hilo5.start();
    }
}
