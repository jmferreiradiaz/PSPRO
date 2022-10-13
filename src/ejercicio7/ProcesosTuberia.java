package ejercicio7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcesosTuberia {
    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio7\\IPGenerator.java");
        ProcessBuilder pb2 = new ProcessBuilder("java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio7\\ImprimirIP.java");
        ProcessBuilder pb3 = new ProcessBuilder("java", "C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio7\\ImprimirP2.java");
        //ProcessBuilder pb4 = new ProcessBuilder("");

        List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();
        lpb.add(pb1);
        lpb.add(pb2);
        lpb.add(pb3);
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb3.redirectError(ProcessBuilder.Redirect.INHERIT);

        pb3.redirectOutput(new File("C:\\Users\\jmferreira\\Desktop\\PSPRO\\PSPRO\\src\\ejercicio7\\salida.txt"));
        //lpb.add(pb3);
       // lpb.add(pb4);

        try{
            List<Process> lProcess = ProcessBuilder.startPipeline(lpb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
