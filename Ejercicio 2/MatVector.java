package apartado2;

import java.util.Random;
import java.util.Scanner;

public class MatVector {
	
	static volatile int [][] matriz;
	static volatile int [] vector;
	static volatile int[] solucion;
	static int filas;
	static int columnas;
	static Scanner sc = new Scanner(System.in);

	//Main solo ejecuta los métodos que resuelven el problema
	public static void main(String[] args) {
		System.out.println("Multiplicador de Matriz-Vector en serie");
		getDimensions();
		printMatriz();
		printVector();
		solucion();
		printSolucion();
	}
	
	//Usar como único contenido en el main, c siendo la dimension de la matriz cuadrada, cuando se quiera probar tiempos.
	public static void timeTest(int c) {
		long total = 0;
		int cycles = 30;
		for(int i = 0; i < cycles; i++) {
			for (int j = 0; j < 20; j++) Runtime.getRuntime().gc();
			getDimensions(c,c);
			//printMatriz();
			//printVector();
			long start = System.nanoTime();
			solucion();
			long stop = System.nanoTime();
			//printSolucion();
			System.out.println("\n\n Se han tardado " + (stop - start) + " nsec");
			total += (stop-start);
			for (int j = 0; j < 20; j++) Runtime.getRuntime().gc();
		}
		System.out.println("\n\n MEDIA: " + (total/cycles));
	}
	
	
	public static void getDimensions() {
		
		int response = 0;
		//Se pregunta al usuario que desea hacer.
		do {
			System.out.println("Introduzca 1 para introducir dimensiones unicamente.");
			System.out.println("Introduzca 2 para introducir dimensiones y valores.");
			response =sc.nextInt();
		}while(response < 1 || response > 2);

		//Se piden las dimensiones de la matriz
		System.out.println("Introduzca el numero de columnas de la matriz");
		columnas = sc.nextInt();
		System.out.println("Introduzca el numero de filas de la matriz");
		filas =sc.nextInt();
		matriz = new int[filas][columnas];
		vector = new int[columnas];
		
		//Si ha querido seleccionar individualmente los elementos, se va preguntando.
		if(response == 2) {
			for(int i = 0; i< filas; i++) {
				for(int j = 0; j< columnas; j++) {
					System.out.println("Introduzca el numero de la fila " + i + " columna " + j + " .");
					matriz[i][j] = sc.nextInt();
				}
			}		
			for(int i = 0; i< columnas; i++) {
				System.out.println("Introduzca el numero " + i + " del vector.");
				vector[i] = sc.nextInt();
			}			
		}
		//En caso contrario se llena de numeros aleatorios entre 1 y 15
		else {
			System.out.println("Generando numeros aleatorios...");
			Random rand = new Random();
			for(int i = 0; i< filas; i++) {
				for(int j = 0; j< columnas; j++) matriz[i][j] = rand.nextInt(15) + 1;
			}
			for(int i = 0; i< columnas; i++) vector[i] = rand.nextInt(15) + 1;	
		}	
		solucion = new int[filas];
	}
	
	//Solo para testeo, genera matrices cuadradas con numeros aleatorios entre 1 y 15
	public static void getDimensions(int x, int y) {
		
		columnas = x;
		filas = y;
		matriz = new int[filas][columnas];
		vector = new int[columnas];
		System.out.println("Generando numeros aleatorios...");
		Random rand = new Random();
		for(int i = 0; i< filas; i++) {
			for(int j = 0; j< columnas; j++) matriz[i][j] = rand.nextInt(15) + 1;
		}
		for(int i = 0; i< columnas; i++) vector[i] = rand.nextInt(15) + 1;	
		solucion = new int[filas];
	}
	
	//Imprime la matriz para ser visible por el usuario
	public static void printMatriz() {
		System.out.println("Matriz a multiplicar");
		for(int i = 0; i< filas; i++) {
			for(int j = 0; j< columnas; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Imprime el vector para ser visible por el usuario
	public static void printVector() {
		System.out.println("Vector a multiplicar");
		for(int i = 0; i< columnas; i++) {
			System.out.print(vector[i] + " ");
		}
		System.out.print("\n\n");
	}
	
	//algoritmo que resuelve el problema
	public static void solucion() {
		for(int i = 0; i< filas;i++) {
			int total = 0;
			for(int j = 0; j< columnas; j++) {
				total += (vector[j] * matriz[i][j]);
			}
			solucion[i] = total;
		}
	}
	
	//Imprime el vector solucion para ser visible por el usuario
	public static void printSolucion() {
		System.out.println("Vector resultado");
		for(int i = 0; i< filas; i++) {
			System.out.print(solucion[i] + " ");
		}
		System.out.print("\n\n");
	}
}
