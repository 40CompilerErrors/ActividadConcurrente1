/*
Implemente un programa que escriba un “hola mundo” por cada hilo de ejecución que se
cree (seis es un número razonable) y que además indique desde que hilo se imprime.
Luego  haga que cada uno espere un tiempo proporcional a su identificador antes de imprimir 
el mensaje (el thread 1, un segundo, el 2, dos segundos, el 3, tres segundos,...).
Lance los threads mediante la clase Thread y luego mediante el interfaz runnable 
¿Qué diferencias aprecia?

 */


public class Main {
    public static void main(String[] args) {
		
		//Creamos los hilos
		
        Hilo_Thread h1 = new Hilo_Thread("Hilo 1: Thread", 1000);
        Hilo_Thread h2 = new Hilo_Thread("Hilo 2: Thread", 2000);
        Hilo_Thread h3 = new Hilo_Thread("Hilo 3: Thread", 3000);
        Hilo_Thread h4 = new Hilo_Thread("Hilo 4: Thread", 4000);
        Hilo_Thread h5 = new Hilo_Thread("Hilo 5: Thread", 5000);
        Hilo_Thread h6 = new Hilo_Thread("Hilo 6: Thread", 6000);

		//iniciamos los hilos
		
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();

		//Creamos los hilos runnables
		
        Hilo_Runnable hr1 = new Hilo_Runnable("Hilo 1 : Runnable", 1000);
        Hilo_Runnable hr2 = new Hilo_Runnable("Hilo 2 : Runnable", 2000);
        Hilo_Runnable hr3 = new Hilo_Runnable("Hilo 3 : Runnable", 3000);
        Hilo_Runnable hr4 = new Hilo_Runnable("Hilo 4 : Runnable", 4000);
        Hilo_Runnable hr5 = new Hilo_Runnable("Hilo 5 : Runnable", 5000);
        Hilo_Runnable hr6 = new Hilo_Runnable("Hilo 6 : Runnable", 6000);

		//Debido a que en el constructor de la clase Hilo_Runnable ya invocamos al start()
		//solo tenemos que ejecutar el metodo run
		
        hr1.run();
        hr2.run();
        hr3.run();
        hr4.run();
        hr5.run();
        hr6.run();


    }


}
