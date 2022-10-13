package ejercicio7;

public class IPGenerator {
    public static void main(String[] args) {
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
