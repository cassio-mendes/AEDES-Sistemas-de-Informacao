package aula05;

import java.util.Scanner;

public class TestaFilaCircular {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Qual o tamanho da fila: ");
        FilaCircular.criarFila(input.nextInt());

        int opcao;
        do {
            mostrarMenu();

            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    FilaCircular.enfileirar(input.next()); break;

                case 2:
                    System.out.println("Cliente chamado: " + FilaCircular.desenfileirar()); break;

                case 3:
                    System.out.println("Pessoas na fila:");
                    FilaCircular.imprimirFila(); break;

                case 4:
                    System.out.println("Número de pessoas atualmente na fila: " + FilaCircular.getTamanho()); break;

                default:
                    if(opcao != 5) { System.out.println("Opção inválida"); }
            }
        } while(opcao != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n1 - Enfileirar cliente");
        System.out.println("2 - Chamar um cliente");
        System.out.println("3 - Pacientes atualmente na fila");
        System.out.println("4 - Número de pacientes na fila");
        System.out.println("5 - SAIR");
    }

}
