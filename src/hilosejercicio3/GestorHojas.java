package hilosejercicio3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorHojas extends Thread {

	//Cambiamos la clase ArrayList por CopyOnWriteArrayList para asegurar la seguridad
	//de los subprocesos.
	private static List<String> lista = new CopyOnWriteArrayList<>();

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			lista.add(new String("Texto" + i));
		}

		for (String string : lista) {
			System.out.println(string);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new GestorHojas().start();
		}

	}

}
