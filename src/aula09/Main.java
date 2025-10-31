package aula09;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Character[] vetorChar = new Character[5000];

        for (int i = 0; i < vetorChar.length; i++) {
            vetorChar[i] = (char)(new Random().nextInt(48, 126)); //Preenche com char's aleatórios
        }

        long inicio = System.currentTimeMillis();
        ordenarVetorTexto(vetorChar);
        long fim = System.currentTimeMillis();

        imprimirVetor(vetorChar);
        System.out.printf("Tempo: %s milissegundos\n\n", (fim - inicio));

        String[] vetorString = {"cabelo", "arroz", "zebra", "24", "Capuz"};
        ordenarVetorTexto(vetorString);
        imprimirVetor(vetorString);
    }

    //Ordenações via SelectionSort completo
    static void ordenarVetorTexto(Object[] vetor) {
        int indiceMenor;

        for (int i = 0; i < vetor.length; i++) {
            indiceMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                //Verifica se os objetos são Character ou String, depois compara qual é o "menor"
                if(compararStringOuCharacter(vetor[indiceMenor], vetor[j]) < 0) {
                    indiceMenor = j; //Atualiza o indiceMenor
                }
            }

            //Troca de valores
            Object auxiliar = vetor[i];
            vetor[i] = vetor[indiceMenor];
            vetor[indiceMenor] = auxiliar;
        }
    }

    static int compararStringOuCharacter(Object item1, Object item2) {
        if(item1 instanceof Character && item2 instanceof Character) {
            return ((Character) item2).compareTo((Character) item1);
        } else {
            return (String.valueOf(item2)).compareTo(String.valueOf(item1)); //Se não for Character, é String
        }
    }

    static void imprimirVetor(Object[] vetor) {
        System.out.print("[");
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
            if(i != vetor.length - 1) { System.out.print(", "); }
        }
        System.out.println("]");
    }

}
