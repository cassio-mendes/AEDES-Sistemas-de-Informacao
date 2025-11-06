package aula10;

public class Main { //Metodo de ordenação de arrays(vetores): Selection Sort

    public static void main(String[] args) {
        int[] vetor = {12, 7, 4, 16, 61, 25, 116, 7};
        final int NUMERO = 16;

        imprimirVetor(vetor);
        mergeSort(vetor);
        imprimirVetor(vetor);
        //System.out.println("Índice do número " + NUMERO + ": " + binarySearch(vetor, NUMERO));
        //System.out.println(NUMERO + "! == " + fatorialRecursivo(NUMERO));
    }

    static void selectionSort(int[] vetor) {
        int minIndex, auxiliar;

        for(int i = 0; i < vetor.length - 1; i++) {
            minIndex = i;

            for(int j = i + 1; j < vetor.length; j++) {
                if(vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }

            auxiliar = vetor[i];
            vetor[i] = vetor[minIndex];
            vetor[minIndex] = auxiliar;
        }
    }

    //[3, 5, 1] = [3, 5, 5] = [3, 3, 5] = [1, 3, 5]
    static void insertionSort(int[] vetor) {
        int j, auxiliar;

        for (int i = 1; i < vetor.length; i++) {
            j = i - 1;
            auxiliar = vetor[i];

            while(j >= 0 && auxiliar < vetor[j]) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = auxiliar;
        }
    }

    static int binarySearch(int[] vetor, int numeroAlvo) {
        int primeiro = 0, ultimo = vetor.length - 1, indiceAtual;

        while(ultimo >= primeiro) {
            indiceAtual = (primeiro + ultimo) / 2;

            if(vetor[indiceAtual] == numeroAlvo)
                return indiceAtual;

            if(numeroAlvo > vetor[indiceAtual]) {
                primeiro = indiceAtual + 1;
            } else {
                ultimo = indiceAtual - 1;
            }
        }

        return -1;
    }

    static void imprimirVetor(int[] vetor) {
        System.out.print("{");

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);

            if(i != vetor.length - 1) { System.out.print(", "); }
        }

        System.out.println("}");
    }

    static long fatorialRecursivo(int n) {
        if(n < 0) return -1;
        if(n == 0) return 1;

        return n * fatorialRecursivo(n - 1);
    }

    static void mergeSort(int[] vetor) {
        int[] esquerda, direita;
        int indiceMetade = vetor.length / 2;

        esquerda = new int[indiceMetade];
        direita = new int[vetor.length - esquerda.length];

        for (int i = 0; i < esquerda.length; i++) {
            esquerda[i] = vetor[i];
        }

        for (int i = 0; i < direita.length; i++) {
            direita[i] = vetor[i + esquerda.length];
        }

        if (indiceMetade > 0) {
            mergeSort(esquerda);
            mergeSort(direita);
        }

        merge(esquerda, direita, vetor);
    }

    static void merge(int[] esquerda, int[] direita, int[] vetor) {
        int j = 0, k = 0;

        for (int i = 0; i < vetor.length; i++) {
            if(esquerda[j] < direita[k]) {
                vetor[i] = esquerda[j];
                j++;
            } else {
                vetor[i] = direita[k];
                k++;
            }
        }
    }

}
