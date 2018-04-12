package Hilo;

public class Hilo_Runnable implements Runnable {

    private String _argumento;
    private int _sleep;
    private Thread _hilo;

    public Hilo_Runnable(String argumento, int sleep) {
        this._argumento = argumento;
        this._sleep = sleep;
        _hilo = new Thread(this,argumento);
        _hilo.start();
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

