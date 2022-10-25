package ejercicio9;

import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String[] comando = {"java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio5\\PreguntaNombre.java"};

        try{
            Process p = r.exec(comando);
            FileReader fr = new FileReader("C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio9\\entrada.txt");
            BufferedReader br = new BufferedReader(fr);

            OutputStream os = p.getOutputStream();
            OutputStreamWriter osr = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osr);

            String line = br.readLine();
            while(line!=null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }

            bw.close();
            p.waitFor();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br2 = new BufferedReader(isr);

            String linea = br2.readLine();
            while(linea!= null){
                System.out.println(linea);
                linea = br2.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
