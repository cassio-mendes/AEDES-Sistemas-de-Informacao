package aula06;

public class Main {

    public static void main(String[] args) {
        double[] ordenado = {1, 2, 3, 4};
        double[] desordenado = {8, 9, 45, 7, 2.5};

        imprimeVetor(ordenado);
        imprimeVetor(desordenado);

        double[] resultado = Ordenacao.insere(ordenado, desordenado);
        imprimeVetor(resultado);
    }

    static void imprimeVetor(double[] vetor) {
        System.out.print("Vetor[");
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);

            if(i != vetor.length - 1) { System.out.print(", "); }
        }

        System.out.println("]");
    }

}
