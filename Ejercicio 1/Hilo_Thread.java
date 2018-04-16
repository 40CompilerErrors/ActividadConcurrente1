public class Hilo_Thread extends Thread {
	//Atributos de la clase
    private String _argumento;
    private int _sleep;

	// Constructor de la clase
    public Hilo_Thread(String argumento, int sleep) {
        this._argumento = argumento;
        this._sleep = sleep;
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
