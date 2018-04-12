

public class Hilo_Thread extends Thread {
    private String _argumento;
    private int _sleep;

    public Hilo_Thread(String argumento, int sleep) {
        this._argumento = argumento;
        this._sleep = sleep;
    }

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
