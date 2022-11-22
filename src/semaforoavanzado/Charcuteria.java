package semaforoavanzado;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.currentThread;

public class Charcuteria implements Runnable{
    Semaphore carniceria = new Semaphore(4);
    Semaphore charcuteria = new Semaphore(2);


    @Override
    public void run() {
        try {
            System.out.println(carniceria.availablePermits());
            if (carniceria.availablePermits() > 0 && carniceria.tryAcquire()){
                carniceria.acquire();
                System.out.println("El "+currentThread().getName()+" está siendo atendido en la carnicería");
                Thread.sleep(10000);
                System.out.println("El "+currentThread().getName()+" ha terminado en la carnicería");
                carniceria.release();
            }

            System.out.println(charcuteria.availablePermits());
            if (charcuteria.availablePermits() > 0 && charcuteria.tryAcquire()){
                charcuteria.acquire();
                System.out.println("El "+currentThread().getName()+" está siendo atendido en la charcuteria");
                Thread.sleep(10000);
                System.out.println("El "+currentThread().getName()+" ha terminado en la charcuteria");
                charcuteria.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Charcuteria ch = new Charcuteria();
        for(int i=0; i<10; i++) {
            Thread th = new Thread(ch);
            th.setName("cliente "+i);
            th.start();
        }
    }

}
