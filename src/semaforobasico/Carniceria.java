package semaforobasico;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.currentThread;

public class Carniceria implements Runnable{
    Semaphore semaforo = new Semaphore(4);

    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println("El "+currentThread().getName()+" está siendo atendido");
            Thread.sleep(10000);
            System.out.println("El "+currentThread().getName()+" ha terminado en la carnicería");
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Carniceria c = new Carniceria();
        for(int i=0; i<10; i++) {
            Thread th = new Thread(c);
            th.setName("cliente "+i);
            th.start();
        }
    }

}
