package hilosestudiantesylibros;

public class EstudiantesYLibros extends Thread {

    public static boolean[] libros = new boolean[9];

    /**
     * Método asíncrono que recibe 2 libros aleatorios, y espera a que estén libres para cogerlos
     * @param libro1
     * @param libro2
     */
    public synchronized  void reservaLibros(int libro1, int libro2){
        //Mientras esten reservados espera
        while(libros[libro1] == true || libros[libro2] == true){
             try{
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }

        //Reservo los libros
        libros[libro1] = true;
        libros[libro2] = true;
    }

    /**
     * Método asíncrono que recibe los libros a soltar
     * @param libro1
     * @param libro2
     */
    public synchronized void soltarLibros(int libro1, int libro2){
        //Vuelven a estar disponible
        libros[libro1] = false;
        libros[libro2] = false;
        this.notifyAll();
    }
    @Override
    public void run(){
        while(true) {
            try {
                int libro1 = (int) (Math.random() * 8);
                int libro2 = (int) (Math.random() * 8);

                while (libro1 == libro2) {
                    libro2 = (int) (Math.random() * 8);
                }

                reservaLibros(libro1, libro2);
                System.out.println("El estudiante " + currentThread().getName() + " ha reservado el libro " + libro1 + " y el libro " + libro2);
                currentThread().sleep((int) (Math.random() * 2000) + 3000);
                soltarLibros(libro1, libro2);
                System.out.println("El estudiante " + currentThread().getName() + " ha soltado el libro " + libro1 + " y el libro " + libro2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++){
            Thread estudiante = new EstudiantesYLibros();
            estudiante.setName("Estudiante "+i);
            estudiante.start();
        }
    }
}
