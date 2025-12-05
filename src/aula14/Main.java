package aula14;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada l1 = new ListaEncadeada();
        ListaEncadeada l2 = new ListaEncadeada();

        l1.inserir(1);
        l1.inserir(2);
        l2.inserir(3);
        l2.inserir(4);

        System.out.println("Lista 1:");
        l1.imprimir();

        System.out.println("Lista 2:");
        l2.imprimir();

        System.out.println("Lista concatenada:");
        l1.concatenar(l2);
        l1.imprimir();

        System.out.println("l1 sem o último:");
        l1.retirarUltimo();
        l1.imprimir();

        System.out.println("l1 sem o primeiro:");
        l1.retirarPrimeiro();
        l1.imprimir();
    }

}
