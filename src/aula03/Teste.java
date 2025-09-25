package aula03;

public class Teste {

    public static void main(String[] args) {
        Lista.criaListaVazia(30);
        Lista.inserir(10.0);
        Lista.inserir(20.30);
        Lista.inserir(2.30);
        Lista.inserir(10.30);
        Lista.inserir(9.30);
        Lista.inserir(10.50);

        Lista.imprimeLista();

        double retirado = (double)Lista.retirar();
        double retirado2 = (double)Lista.retirar();
        System.out.println("Retirados: " + retirado + ", " + retirado2 + "\n");

        Lista.imprimeLista();
    }

}
