package aula04;

public class TestaFila {

    public static void main(String[] args) {
        Fila.criarFila(5);

        Fila.enfileirar('A');
        Fila.enfileirar('B');
        Fila.enfileirar('C');
        Fila.enfileirar('D');
        Fila.enfileirar('E');
        Fila.imprimirFila();

        System.out.println("'" + Fila.desenfileirar() + "' saiu da fila");
        System.out.println("'" + Fila.desenfileirar() + "' saiu da fila");
        Fila.imprimirFila();
    }

}
