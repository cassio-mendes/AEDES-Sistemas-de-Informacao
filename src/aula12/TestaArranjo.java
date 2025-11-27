package aula12;

public class TestaArranjo {

    public static void main(String[] args) {
        ListaArranjo l1 = new ListaArranjo(10);
        ListaArranjo l2 = new ListaArranjo(20);

        l1.insere("Açúcar");
        l1.insere("Farinha");
        l1.insere("Sal");
        l1.insere("Pimenta");

        l2.insere("Açúcar");
        l2.insere("Leite Condensado");
        l2.insere("Chantilly");

        l1.imprime();
        while(!l2.vazia()) {
            l1.insere(l2.retira());
        }

        System.out.println();
        l1.imprime();

        PilhaArranjo p1 = new PilhaArranjo(5);
    }

}
