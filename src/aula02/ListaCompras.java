package aula02;

import java.util.Scanner;

public class ListaCompras {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Qual o tamanho da lista: ");
        Lista.criaListaVazia(input.nextInt());

        Lista.inserir("Banana");
        Lista.inserir("Abacaxi");
        Lista.inserir("Abacate");
        Lista.imprimeLista();

        System.out.println("Item removido: " + Lista.retirar());
        Lista.imprimeLista();

        System.out.println("Pesquisando Banana: " + Lista.pesquisar("Banana"));
        System.out.println("Pesquisando Abacaxi: " + Lista.pesquisar("Abacaxi"));
        System.out.println("Pesquisando Aba: " + Lista.pesquisar("Aba"));
        Lista.imprimeLista();

        System.out.println("Inserindo Manga no índice 3:");
        Lista.inserirEm("Manga", 3);
        Lista.imprimeLista();

        System.out.println("Inserindo Laranja no índice 1:");
        Lista.inserirEm("Laranja", 1);
        Lista.imprimeLista();

        System.out.println("Removendo o item no índice 1: " + Lista.retirarEm(1));
        Lista.imprimeLista();

        System.out.println("Pesquisando o índice do elemento Abacaxi: " + Lista.pesquisarPosicao("Abacaxi"));
    }

}
