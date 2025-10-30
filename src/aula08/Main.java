package aula08;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random gerador = new Random();

        final int TAMANHO = 5000;
        Lista.criaListaVazia(TAMANHO);

        for (int i = 0; i < TAMANHO; i++) {
            Lista.inserir(gerador.nextInt(1, TAMANHO + 1));
        }

        System.out.println("2 -");
        //Ordenação por seleção
        long inicio = System.currentTimeMillis();
        System.out.println("Instante inical (SELEÇÃO): " + inicio);

        Lista.sortSelecao(TAMANHO);

        long fim = System.currentTimeMillis();
        System.out.println("Instante final (SELEÇÃO): " + fim);
        System.out.println("Tempo gasto (em milisegundos): " + (fim - inicio));

        //Ordenação por inserção
        inicio = System.currentTimeMillis();
        System.out.println("\nInstante inical (INSERÇÃO): " + inicio);

        Lista.sortInsercao(TAMANHO);

        fim = System.currentTimeMillis();
        System.out.println("Instante final (INSERÇÃO): " + fim);
        System.out.println("Tempo gasto (em milisegundos): " + (fim - inicio));

        //Custos de execução
        System.out.println("3 -");

        //SELEÇÃO
        System.out.println("\nOrdenação por SELEÇÃO:");
        System.out.println("Custo de comparações (n=5000): 25.000.000"); //O(n²)
        System.out.println("Custo de comparações (n=10000): 100.000.000"); //O(n²)

        System.out.println("\nCusto de movimentações (n=5000): 5000"); //O(n)
        System.out.println("Custo de movimentações (n=10000): 10000"); //O(n)

        //INSERÇÃO
        System.out.println("\nOrdenação por INSERÇÃO:");
        System.out.println("Custo de comparações (n=5000): 25.000.000"); //O(n²)
        System.out.println("Custo de comparações (n=10000): 100.000.000"); //O(n²)

        System.out.println("\nCusto de movimentações (n=5000): 25.000.000"); //O(n²)
        System.out.println("Custo de movimentações (n=10000): 100.000.000"); //O(n²)

        System.out.println("Portanto, ambos os métodos têm o mesmo custo em comparações, mas a seleção é menos custosa" +
                " em movimentações (considerando sempre os casos médios de custo).\nPor outro lado, o método de seleção" +
                " demorou mais milissegundos para terminar sua execução");

        System.out.println("\n4 - Inserindo os valores [5, 6, 2, 9] à lista e ordenando-os com selectionSort");
        Lista.insereEOrdena(new int[]{5, 6, 2, 9});

        System.out.println("Resultado final:");
        Lista.imprimeLista();
    }

}
