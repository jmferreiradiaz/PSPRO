package lanzaprocesoruntime;

import java.io.*;

public class LanzaProcesoRuntime {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String[] comando = {"java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio7\\IPGenerator.java"};

        try{
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));

            String line= br.readLine();
            while(line!=null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            bw.close();
            br.close();
            isr.close();
            is.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
