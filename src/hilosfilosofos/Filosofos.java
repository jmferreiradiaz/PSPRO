package hilosfilosofos;

import hilosestudiantesylibros.EstudiantesYLibros;

public class Filosofos extends Thread{

    //El array de tenedores
    private static boolean tenedores[] = new boolean[5];

    //Variable que nos dirá que filósofo es el que coge el tenedor
    public int indice;

    public Filosofos(int i){
        this.indice = i;
    }

    /***
     * Devuelve el tenedor que está a la izquierda del filosofo actual.
     * @param filosofo
     * @return
     */
    public int tenedorIzquierda(int filosofo){
        return  filosofo;
    }

    /***
     * Devuelve el tenedor que está a la derecha del filosofo actual.
     * @param filosofo
     * @return
     */
    public int tenedorDerecha(int filosofo){
        int tenedor;

        if (filosofo == 4){
            tenedor = 0;
        } else {
            tenedor = filosofo + 1;
        }
        return tenedor;
    }

    /***
     * Método asíncrono que coge los 2 tenedores del filósofo actual
     * @param filosofo
     */
    public synchronized void cogerTenedores(int filosofo) {
        while(tenedores[tenedorIzquierda(filosofo)] || tenedores[tenedorDerecha(filosofo)]){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        tenedores[tenedorIzquierda(filosofo)] = true;
        tenedores[tenedorDerecha(filosofo)] = true;

    }

    /***
     * Método asíncrono que suelta los 2 tenedores del filósofo actual
     * @param filosofo
     */
    public synchronized void soltarTenedores(int filosofo) {
        tenedores[tenedorIzquierda(filosofo)] = false;
        tenedores[tenedorDerecha(filosofo)] = false;
        this.notifyAll();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(currentThread().getName() + " está pensando");
                currentThread().sleep((int) (Math.random() * 2000) + 3000);
                cogerTenedores(this.indice);
                System.out.println(currentThread().getName() + " está comiendo");
                currentThread().sleep(4000);
                System.out.println(currentThread().getName() + " ha terminado de comer, tenedor " + tenedorIzquierda(this.indice) + " y tenedor " + tenedorDerecha(this.indice) + " están libres");
                soltarTenedores(this.indice);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            //Le pasamos i como parámetro al constructor de filósofos para que se le asigne al índice
            Thread filosofo = new Filosofos(i);
            filosofo.setName("Filosofo "+i);
            filosofo.start();
        }
    }
}
