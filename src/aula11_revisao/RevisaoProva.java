package aula11_revisao;

import java.util.Scanner;

public class RevisaoProva {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Fila.criarFila(10);

        int opcao;
        while(true) {
            System.out.println("1 - Novo Processo");
            System.out.println("2 - Atender Processo");
            System.out.println("3 - Imprimir Fila de Processos");
            System.out.println("4 - SAIR");

            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Dê o ID e depois a descrição: ");

                    boolean resultado = Fila.enfileirar(new Processo(scan.nextInt(), scan.next()));
                    if(!resultado) {
                        System.out.println("Overflow: aguarde a fila de processos esvaziar\n");
                    } else {
                        System.out.println("Processo adicionado à fila\n");
                    }
                    break;

                case 2:

                    if(Fila.desenfileirar() == null) {
                        System.out.println("Erro: não há processos na fila\n");
                    } else {
                        System.out.println("Processo removido da fila\n");
                    }
                    break;

                case 3: Fila.imprimirFila(); break;

                case 4: System.exit(0);
            }
        }
    }

}

class Processo {

    private int id;
    private String descricao;

    public Processo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Processo[id=" + this.id + ", descricao=" + this.descricao + "]";
    }
}
