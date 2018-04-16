public class Hilo_Runnable implements Runnable {

	//Atributos de la clase
    private String _argumento;
    private int _sleep;
    private Thread _hilo; //Empleamos un hilo debido a que la clase Runnable esta implementada y no heredada

	// Constructor de la clase
    public Hilo_Runnable(String argumento, int sleep) {
        this._argumento = argumento;
        this._sleep = sleep;
        _hilo = new Thread(this,argumento); //Se inicializa el hilo
        _hilo.start();
    }
	
	// Método para ejecutar el hilo:
	// Ejecuta un bucle for de 100 iteraciones que imprime por pantalla "Hola Mundo"
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(_argumento + " Hola Mundo!");
                try {
                    Thread.sleep(_sleep);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

