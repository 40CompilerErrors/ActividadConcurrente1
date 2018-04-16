public class Main {
    public static volatile boolean flag[] = {false, false, false, false};
    public static volatile int numero[] = {0, 0, 0, 0};
    public static volatile Contador contador = new Contador();

    public static void main(String[] args) {
        Hilo1 h1 = new Hilo1("Hilo 1", 5);
        Hilo2 h2 = new Hilo2("Hilo 2", 15);
        Hilo3 h3 = new Hilo3("Hilo 3", 10);
        Hilo4 h4 = new Hilo4("Hilo 4", 25);

        h1.start();
        h2.start();
        h3.start();
        h4.start();


    }
}
