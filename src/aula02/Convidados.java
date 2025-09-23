package aula02;

import java.util.Scanner;

public class Convidados {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();

            opcao = input.nextInt();
            input.skip("\n");

            switch (opcao) {
                case 1:
                    System.out.println("\nQuantos convidados a lista deve ter?");
                    Lista.criaListaVazia(input.nextInt());
                    input.skip("\n");
                    break;

                case 2:
                    System.out.print("Digite o nome do convidado: ");
                    Lista.inserir(input.next()); break;

                case 3:
                    System.out.print("Informe o índice do convidado que deve ser removido: ");
                    String nome = Lista.retirarEm(input.nextInt());
                    input.skip("\n");

                    if(nome != null) { System.out.println(nome + " removido da lista"); }
                    break;

                case 4:
                    System.out.print("Informe o nome a ser pesquisado: ");
                    String resultado = Lista.pesquisar(input.next());

                    if(resultado != null) { System.out.println(resultado); }
                    break;

                case 5:
                    Lista.imprimeLista();
            }
        } while(opcao != 6);
    }

    static void mostrarMenu() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Inicializar a lista");
        System.out.println("2 - Inserir convidado");
        System.out.println("3 - Excluir convidado");
        System.out.println("4 - Pesquisar convidado");
        System.out.println("5 - Imprimir a lista de convidados");
        System.out.println("6 - SAIR\n");
        System.out.print("Digite aqui: ");
    }

}
