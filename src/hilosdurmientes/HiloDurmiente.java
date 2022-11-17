package hilosdurmientes;

import org.w3c.dom.ranges.Range;

import java.util.Random;

public class HiloDurmiente extends Thread {

    @Override
    public void run(){
        //Generamos un int Aleatorio entre 1 y 10 incluidos
        int numAle = (int)(Math.random()*10)+1;

        while (true){
            //Cogemos el hilo que está actualmente en ejecucíón
            Thread hilo = currentThread();
            System.out.println("Soy el bucle "+hilo.getName()+" y estoy trabajando");
            try {
                //Detenemos la ejecución entre 1 y 10 segundos
                Thread.sleep(1000 * numAle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Declaramos e inicializamos los hilos
        HiloDurmiente hilo1 = new HiloDurmiente();
        HiloDurmiente hilo2 = new HiloDurmiente();
        HiloDurmiente hilo3 = new HiloDurmiente();
        HiloDurmiente hilo4 = new HiloDurmiente();
        HiloDurmiente hilo5 = new HiloDurmiente();

        //Asignamos un nombre a cada hilo
        hilo1.setName("hilo 1");
        hilo2.setName("hilo 2");
        hilo3.setName("hilo 3");
        hilo4.setName("hilo 4");
        hilo5.setName("hilo 5");

        //Lanzamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
