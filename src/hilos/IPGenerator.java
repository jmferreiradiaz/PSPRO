package hilos;

public class IPGenerator {
    public static void main(String[] args) {
        Thread h = Thread.currentThread();//hilo actual
        System.out.println(h.getName());//Obtener nombre hilo
        System.out.println(h.getState());//Obtener estado hilo
        System.out.println(h.getId());//Obtener id
        System.out.println(h.isDaemon());//Comprueba si es demonio
        System.out.println(h.getPriority());//Devuelve la prioridad

        System.out.println("PRIORIDADES:");
        System.out.println("PRIORIDADES MÁXIMA "+Thread.MAX_PRIORITY);
        System.out.println("PRIORIDADES MÍNIMA "+Thread.MIN_PRIORITY);
        System.out.println("PRIORIDADES POR DEFECTO "+Thread.NORM_PRIORITY);
        for (int i = 0; i < 10; i++){
            String ip  = new String("");
            for (int j = 0; j < 4; j++){
               int num = (int) (Math.random()* (255 - 0) + 0);
               if (j == 3) {
                   ip += ""+num;} else { ip += ""+num+".";}
            }
            System.out.println(ip);
        }
    }
}
