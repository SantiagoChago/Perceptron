import java.util.Random;

class Percep {
    private double[] pesos;
    private double tasaAprendizaje;
    private double bias;

    public Percep(int numEntradas,double tasaAprendizaje) {
        this.pesos = new double[numEntradas];
        this.tasaAprendizaje =tasaAprendizaje;
        inicializarPesos();
        this.bias = new Random().nextDouble() - 0.5; // Bias inicial
    }
    private void inicializarPesos() {
        Random random = new Random();
        for (int i=0;i<pesos.length;i++) {
            pesos[i]=random.nextDouble()-0.5;
        }
    }
    public double calcularSalida(int[] entradas) {
        double suma = bias;
        for (int i=0;i<pesos.length;i++) {
            suma +=entradas[i]*pesos[i];
        }
        return suma;
    }
    public void entrenar(int[][]conjuntoEntradas, int[]conjuntoSalidas,int numRondas) {
        for (int ronda =0;ronda<numRondas;ronda++) {
            for (int i =0;i<conjuntoEntradas.length; i++) {
                double salidaCalculada=calcularSalida(conjuntoEntradas[i]);
                double error=conjuntoSalidas[i]-salidaCalculada;// Usamos diferencia en lugar de 1 o 0
                actualizarPesos(conjuntoEntradas[i], error);
            }
        }
    }
    private void actualizarPesos(int[] entradas, double error) {
        for (int i=0;i<pesos.length; i++) {
            pesos[i]+=tasaAprendizaje*error*entradas[i];
        }
        bias+=tasaAprendizaje*error; // Ajuste más preciso
    }
    public double[] getPesos() {
        return pesos;
    }
    public double getBias() {
        return bias;
    }
    public int predecir(int[] entradas) {
        return (calcularSalida(entradas) >= 0) ? 1 : 0;
    }
}
