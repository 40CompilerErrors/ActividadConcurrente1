public class Contador {
	//Constructor por defecto
    public Contador() {

    }
	//Metodo incrementar, recibe un entero n y devuelve la suma de n iteraciones
    public int Incrementar(int n) {
        int numero = 0;
        for (int i = 0; i < n; i++) {
            numero++;
        }
        return numero;
    }
}
