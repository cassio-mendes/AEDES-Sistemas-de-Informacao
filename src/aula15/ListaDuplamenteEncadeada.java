package aula15;

public class ListaDuplamenteEncadeada {

    private static class Celula { Object item; Celula anterior; Celula proximo; }

    private Celula cabeca, ultimo;

    public ListaDuplamenteEncadeada() {
        this.cabeca = new Celula();
        this.cabeca.anterior = null;

        this.ultimo = this.cabeca;
        this.ultimo.proximo = null;
    }

    public void inserir(Object item) {
        Celula antigoUltimo = this.ultimo;

        this.ultimo.proximo = new Celula();
        this.ultimo = this.ultimo.proximo;
        this.ultimo.item = item;
        this.ultimo.proximo = null;
        this.ultimo.anterior = antigoUltimo;
    }

    public Object retirarPrimeiro() {
        if(this.vazia()) return null;

        Object item = this.cabeca.proximo.item;
        this.cabeca = this.cabeca.proximo;
        this.cabeca.anterior = null;

        return item;
    }

    public Object retirarUltimo() {
        if(this.vazia()) return null;

        Object item = this.ultimo.item;
        this.ultimo = this.ultimo.anterior;
        this.ultimo.proximo = null;

        return item;
    }

    public Object remover(Object itemAlvo) {
        if(this.vazia() || itemAlvo == null) return null;

        Celula atual = this.cabeca.proximo;

        while(atual != null && !(atual.item.equals(itemAlvo))) {

            atual = atual.proximo;
        }

        if(atual == null) return null;

        Object itemEncontrado = atual.item;
        Celula celulaAnterior = atual.anterior;
        Celula proximaCelula = atual.proximo;

        celulaAnterior.proximo = proximaCelula;
        proximaCelula.anterior = celulaAnterior;

        if(atual.proximo == null)
            this.ultimo = celulaAnterior;

        return itemEncontrado;
    }

    public boolean pesquisa(Object itemAlvo) {
        if(this.vazia()) return false;

        Celula atual = this.cabeca.proximo;

        while(atual != null) {

            if(atual.item.equals(itemAlvo)) return true;
            atual = atual.proximo;
        }

        return false;
    }

    public void imprimir() {
        if(this.vazia()) {
            System.out.println("Lista vazia");
        } else {
            Celula atual = this.cabeca.proximo;

            while(atual != null) {
                System.out.println(atual.item);
                atual = atual.proximo;
            }
        }
    }

    private boolean vazia() { return this.cabeca == this.ultimo; }
}
