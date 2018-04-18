package apartado2;

import java.util.Vector;

import apartado2.MatVectorConcurrente.Hilo;

public class MatVectorThreadConcurrente extends MatVector {
	//Hereda de MatVector porque exceptuando solucion, el resto de metodos y atributos son iguales
	
	//El main es igual, solo cambia cual se esta ejecutando
	public static void main(String[] args) {
		System.out.println("Multiplicador de Matriz-Vector concurrente (Thread)");
		getDimensions();
		printMatriz();
		printVector();
		solucion();
		printSolucion();
	}
	
	//Algoritmo que soluciona el problema
	public static void solucion() {
		
		Vector<Thread> vector = new Vector<Thread>();
		//Crear todos los hilos
		for(int i = 0; i< filas;i++) {
			Hilo h = new Hilo(i);
			vector.add(h);
		}
		//Empezar todos los hilos
		for(Thread t : vector) t.start();
		//Esperar a que terminen todos los hilos
		for(Thread t : vector) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nTodos los hilos "
							+ "finalizados\n");
		
	}
	
	public static class Hilo extends Thread{

		int fila;
		
		Hilo(int fila){
			this.fila = fila;
		}
		//Funcion que se ejecuta cuando se inicia el hilo
		public void run() {
			System.out.println("Hilo " + fila + " empezado");
			int total = 0;
			for(int j = 0; j< columnas; j++) {
				total += (vector[j] * matriz[fila][j]);
			}
			solucion[fila] = total;
			System.out.println("Hilo " + fila + " terminado");
		}
		
		
	}
}
