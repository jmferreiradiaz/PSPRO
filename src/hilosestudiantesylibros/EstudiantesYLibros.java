package hilosestudiantesylibros;

public class EstudiantesYLibros extends Thread {

    public static boolean[] libros = new boolean[9];
    public static Object o = new Object();

    public synchronized  void reservaLibros(int libro1, int libro2){
        while(libros[libro1] == true || libros[libro2] == true){
             try{
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }

        //Reservo los libros, no están disponible
        libros[libro1] = true;
        libros[libro2] = true;
    }

    public synchronized void soltarLibros(int libro1, int libro2){
        //Vuelven a estar disponible
        libros[libro1] = false;
        libros[libro2] = false;
        this.notifyAll();
    }
    @Override
    public void run(){
        try{
            int libro1 = (int)(Math.random()*8);
            int libro2 = (int)(Math.random()*8);

            reservaLibros(libro1,libro2);
            //System.out.println("El estudiante "+currentThread().getName())
            currentThread().sleep((int)(Math.random()*2000) + 3000);
            soltarLibros(libro1, libro2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            Thread estudiante = new EstudiantesYLibros();
            estudiante.setName("Estudiante "+i);
            estudiante.start();
        }
    }
}
