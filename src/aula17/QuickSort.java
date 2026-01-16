package aula17;

public class QuickSort {

    public static void main(String[] args) {
        int[] vetor = {1, 13, 2, 5, 4, 9, 10};
        quickSort(vetor);
        System.out.println(java.util.Arrays.toString(vetor));
    }

    static void quickSort(int[] vetor) {
        int meio = vetor[vetor.length/2];

        int[] esquerda = new int[meio];
        int[] direita = new int[vetor.length - meio];


    }

}
