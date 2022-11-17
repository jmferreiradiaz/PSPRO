package hilosnumerooculto;

public class HiloNumeroOculto extends Thread{
    public static  int numeroAdivinar;
    public static boolean acertado = false;

    @Override
    public void run(){
        int numero = (int)(Math.random()*100)+1;
        int res = propuestaNumero(numero);

        while(res == 0){
            numero = (int)(Math.random()*100)+1;
            res = propuestaNumero(numero);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        //Interrumpir en cualquier caso
    }

    public static synchronized int propuestaNumero(int numero){
        int res = 0;
        if (numero == numeroAdivinar && !acertado){
            res = 1;
            acertado = true;
            System.out.println("El hilo "+currentThread().getName()+" ha averiguado el número secreto "+numeroAdivinar);
            //Interrumpir hilo
            currentThread().interrupt();
        }if(acertado) {
            res =-1;
            //Interrumpir hilo
            currentThread().interrupt();
        }
        return res;
    }

    public static void main(String[] args) {
        numeroAdivinar = (int)(Math.random()*100)+1;

        for (int i = 1; i<=10 ; i++){
            new HiloNumeroOculto().start();
        }

    }
}
