public class Hilo2 extends Thread {
	//Atributos de la clase
    private String _argumento;
    private int _iteraciones;

	//Constructor de la clase
    public Hilo2(String argumento, int iteraciones) {
        this._argumento = argumento;
        this._iteraciones = iteraciones;
    }

    @Override
	//Ejecucion del algoritmo de Lampert
    public void run() {
        int incrementacion = 0;
        int maximo = 0;
        while (true) {
            Main.flag[1] = true;
            maximo = Math.max(Main.numero[0], Main.numero[1]);
            Main.numero[1] = Math.max(maximo, Main.numero[2]) + 1;
            Main.flag[1] = false;
            for (int i = 0; i < Main.numero.length; i++) {
                while (Main.flag[i]) {
                }
                while (Main.numero[i] != 0 && (Main.numero[i] < Main.numero[1]) || (Main.numero[i] == Main.numero[1] && i < 1)) {
                    incrementacion = Main.contador.Incrementar(this._iteraciones); //llamada a la funcion contador
                }
                System.out.println(this._argumento + " Incrementacion: " + incrementacion);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Main.numero[1] = 0;
            }
        }
    }
}
