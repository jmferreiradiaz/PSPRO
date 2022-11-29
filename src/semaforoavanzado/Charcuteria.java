package semaforoavanzado;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.currentThread;

public class Charcuteria implements Runnable{
    Semaphore carniceria = new Semaphore(4);
    Semaphore charcuteria = new Semaphore(2);


    @Override
    public void run() {
        //Declaramos 2 booleanos para controlar si entra en la carnicería o en la charcutería
        boolean isCar = false;
        boolean isChar = false;
        try {
            //Mientras los 2 booleanos no estén a true, se seguirá ejecutando
            while(!isCar || !isChar){
                //Utilizamos availablePermits para saber cuantos permisos quedan en el semáforox
                if (carniceria.availablePermits() > 0 && !isCar){
                    carniceria.acquire();
                    System.out.println("El "+currentThread().getName()+" está siendo atendido en la carnicería");
                    Thread.sleep(10000);
                    System.out.println("El "+currentThread().getName()+" ha terminado en la carnicería");
                    isCar = true;
                    carniceria.release();
                }

                if (charcuteria.availablePermits() > 0 && !isChar){
                    charcuteria.acquire();
                    System.out.println("El "+currentThread().getName()+" está siendo atendido en la charcuteria");
                    Thread.sleep(10000);
                    System.out.println("El "+currentThread().getName()+" ha terminado en la charcuteria");
                    isChar = true;
                    charcuteria.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Charcuteria ch = new Charcuteria();
        for(int i=0; i<10; i++) {
            //Creamos un hilo
            Thread th = new Thread(ch);
            //Le ponemos un nombre al hilo
            th.setName("cliente "+i);
            //Lanzamos el hilo
            th.start();
        }
    }

}
