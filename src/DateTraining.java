class DateTraining {
    public static void imprimirPesos(Percep perceptron) {
        System.out.println("\n Pesos Finales");
        double[] pesos = perceptron.getPesos();
        for (int i=0;i<pesos.length; i++) {
            System.out.println("w"+(i+1)+": "+pesos[i]);
        }
        System.out.println("Bias:"+perceptron.getBias());
    }
    public static void Ecuaciones(Percep perceptron) {
        System.out.println("\n Ecuación del modelo");
        System.out.print("Y=");
        double[] pesos = perceptron.getPesos();
        for (int i=0;i<pesos.length;i++) {
            System.out.print("("+pesos[i]+"*x"+(i+1)+")");
            if (i<pesos.length-1) {
                System.out.print("+");
            }
        }
        System.out.println("+"+perceptron.getBias());
    }
    public static void DatEntrada (int[][]conjuntoEntradas) {
        System.out.println("\n Datos de entrada");
        for (int i=0;i<conjuntoEntradas.length;i++) {
            System.out.print(+(i+1) +":");
            for (int j=0;j<conjuntoEntradas[i].length;j++) {
                System.out.print(conjuntoEntradas[i][j]+ "");
            }
            System.out.println();
        }
    }
    public static void imprimirPredicciones (Percep perceptron,int[][]conjuntoEntradas) {
        System.out.println("\n Predicciones");
        for (int i=0;i<conjuntoEntradas.length;i++) {
            int prediccion=perceptron.predecir(conjuntoEntradas[i]);
            System.out.print((i+1)+" : ");
            for (int valor:conjuntoEntradas[i]){
                System.out.print(valor+" ");
            }
            System.out.println("=> Predicción: " + prediccion);
        }
    }
}