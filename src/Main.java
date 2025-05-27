public class Main {
    public static void main(String[] args) {
        int[][]entradas2 = {{0, 0}, {0, 1},{1, 0},{1, 1}};
        int[] salidasAND2 = {0, 0, 0, 1};
        int[] salidasOR2 = {0, 1, 1, 1};
        int[][]entradas3 = {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        int[] salidasAND3 = {0, 0, 0, 0, 0, 0, 0, 1};
        int[] salidasOR3 = {0, 1, 1, 1, 1, 1, 1, 1};

        entrenarYMostrarResultados(new Percep (2, 0.3), "AND 2 Entradas", entradas2, salidasAND2);
        entrenarYMostrarResultados(new Percep (2, 0.3), "OR 2 Entradas", entradas2, salidasOR2);
        entrenarYMostrarResultados(new Percep (3, 0.3), "AND 3 Entradas", entradas3, salidasAND3);
        entrenarYMostrarResultados(new Percep (3, 0.3), "OR 3 Entradas", entradas3, salidasOR3);
    }
    private static void entrenarYMostrarResultados(Percep perceptron, String Encabezado, int[][] entradas, int[] salidas) {
        perceptron.entrenar(entradas, salidas, 100);
        System.out.println("\n "+Encabezado +" ");
       DateTraining.DatEntrada(entradas);
       DateTraining.imprimirPesos(perceptron);
        DateTraining.Ecuaciones(perceptron);
        DateTraining.imprimirPredicciones(perceptron, entradas);
    }
}