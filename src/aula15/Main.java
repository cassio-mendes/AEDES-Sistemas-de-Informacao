package aula15;

public class Main {

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.imprimir();

        System.out.println();
        lista.remover(2);
        lista.imprimir();

        System.out.println();
        lista.inserir(4);
        lista.imprimir();

        System.out.println();
        lista.retirarPrimeiro();
        lista.retirarUltimo();
        lista.imprimir();

        System.out.println("\n" + lista.pesquisa(3));
        System.out.println(lista.pesquisa(1));
    }

}
