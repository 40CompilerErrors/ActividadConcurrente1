public class Hilo4 extends Thread {
	//Atributos de la clase
    String _argumento;
    int _iteraciones;
	//Constructor de la clase
    public Hilo4(String argumento, int iteraciones) {
        this._argumento = argumento;
        this._iteraciones = iteraciones;
    }
	
	//Algoritmo de Lamport
    @Override
    public void run() {
        int incrementacion = 0;
        int maximo = 0;
        while (true) {
            Main.flag[3] = true;
            maximo = Math.max(Main.numero[0], Main.numero[1]);
            Main.numero[3] = Math.max(maximo, Main.numero[3]) + 1;
            Main.flag[3] = false;
            for (int i = 0; i < Main.numero.length; i++) {
                while (Main.flag[i]) {
                }
                while (Main.numero[i] != 0 && (Main.numero[i] < Main.numero[3]) || (Main.numero[i] == Main.numero[3] && i < 3)) {
                    incrementacion = Main.contador.Incrementar(this._iteraciones); //llamada a la funcion incrementar de la clase contador
                }
                System.out.println(this._argumento + " Incrementacion: " + incrementacion);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Main.numero[0] = 0;
            }
        }
    }
}
