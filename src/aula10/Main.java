package aula10;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] vetor = new int[5000];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = new Random().nextInt(1000);
        }

        final int NUMERO = 7;

        imprimirVetor(vetor);

        long inicio = System.currentTimeMillis();
        mergeSort(vetor);       //Mais rápido
        //insertionSort(vetor); //Mediano
        //selectionSort(vetor); //Mais lento
        long fim = System.currentTimeMillis();

        imprimirVetor(vetor);
        System.out.printf("Tempo para ordenar: %s milissegundos\n\n", (fim - inicio));

        inicio = System.currentTimeMillis();
        int indiceEncontrado = binarySearch(vetor, NUMERO);
        fim = System.currentTimeMillis();

        System.out.println("Índice do número " + NUMERO + ": " + indiceEncontrado);
        System.out.printf("Tempo para encontrar o número: %s milissegundos\n\n", (fim - inicio));
        System.out.println(NUMERO + "! == " + fatorialRecursivo(NUMERO));
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
        int i = 0, j = 0, k = 0;

        while(j < esquerda.length && k < direita.length) {
            if(esquerda[j] < direita[k]) {
                vetor[i] = esquerda[j];
                j++;
            } else {
                vetor[i] = direita[k];
                k++;
            }
            i++;
        }

        if(j < esquerda.length) {
            for (int i2 = j; i2 < esquerda.length; i2++) {
                vetor[i] = esquerda[i2];
                i++;
            }
        } else if(k < direita.length) {
            for (int i3 = k; i3 < direita.length; i3++) {
                vetor[i] = direita[i3];
                i++;
            }
        }
    }

}
