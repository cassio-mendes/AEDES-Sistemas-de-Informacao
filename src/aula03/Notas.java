package aula03;

import java.util.Scanner;

public class Notas {

    static int tamanho;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();

            opcao = input.nextInt();
            input.skip("\n");

            switch (opcao) {
                case 1:
                    System.out.println("\nQuantas notas a lista deve armazenar?");
                    tamanho = input.nextInt();

                    Lista.criaListaVazia(tamanho);
                    input.skip("\n");
                    break;

                case 2:
                    System.out.print("Digite a nota do aluno: ");
                    Lista.inserir(input.nextDouble()); break;

                case 3:
                    Lista.imprimeLista();
                    break;

                case 4:
                    System.out.println("A média do aluno é " + calcularMedia());
            }
        } while(opcao != 5);
    }

    static void mostrarMenu() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Inicializar a lista");
        System.out.println("2 - Inserir nota");
        System.out.println("3 - Imprimir a lista de notas");
        System.out.println("4 - Calcular média");
        System.out.println("5 - SAIR\n");
        System.out.print("Digite aqui: ");
    }

    static double calcularMedia() {
        double soma = 0.0;

        for (int i = 0; i < tamanho; i++) {
            soma += (double)Lista.retirar();
        }

        return soma / tamanho;
    }
}
