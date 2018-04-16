public class Hilo3 extends Thread {
	//Atributos de la clase
    String _argumento;
    int _iteraciones;
	
	//Constructor de la clase
    public Hilo3(String argumento, int iteraciones) {
        this._argumento = argumento;
        this._iteraciones = iteraciones;
    }

	//Ejecucion del algoritmo de Lampert
    @Override
    public void run() {
        int maximo = 0;
        int incrementacion = 0;
        while (true) {
            Main.flag[0] = true;
            maximo = Math.max(Main.numero[0], Main.numero[1]);
            Main.numero[2] = Math.max(maximo, Main.numero[2]) + 1;
            Main.flag[0] = false;
            for (int i = 0; i < Main.numero.length; i++) {
                while (Main.flag[i]) {
                }
                while (Main.numero[i] != 0 && (Main.numero[i] < Main.numero[2]) || (Main.numero[i] == Main.numero[2] && i < 2)) {
                    incrementacion = Main.contador.Incrementar(this._iteraciones); // Llamada a la funcion contador
                }
                System.out.println(this._argumento + " Incrementacion: " + incrementacion);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Main.numero[2] = 0;
            }
        }
    }
}
