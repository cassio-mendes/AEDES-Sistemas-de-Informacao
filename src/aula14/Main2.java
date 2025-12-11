package aula14;

public class Main2 {

    public static void main(String[] args) {
        PilhaEncadeada pilha = new PilhaEncadeada();

        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.imprimir();

        System.out.println();
        pilha.desempilhar();
        pilha.imprimir();
    }

}
