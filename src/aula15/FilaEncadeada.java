package aula15;

public class FilaEncadeada {

    private static class Celula { Object item; Celula proximo; }

    private Celula frente, tras;

    public FilaEncadeada() {
        this.frente = new Celula();
        this.tras = this.frente;
    }

    public void enfileirar(Object item) {
        this.tras.proximo = new Celula();
        this.tras = this.tras.proximo;
        this.tras.item = item;
        this.tras.proximo = null;
    }

    public Object desenfileirar() {
        if(this.vazia()) return null;

        this.frente = this.frente.proximo;
        return this.frente.item;
    }

    public void imprimir() {
        if(this.vazia()) {
            System.out.println("Fila vazia");
        } else {
            Celula atual = this.frente.proximo;

            while(atual != null) {
                System.out.println(atual.item);
                atual = atual.proximo;
            }
        }
    }

    private boolean vazia() { return this.frente == this.tras; }
}
