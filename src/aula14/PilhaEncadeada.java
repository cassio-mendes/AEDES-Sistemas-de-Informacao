package aula14;

public class PilhaEncadeada {

    private static class Celula { Object item; Celula proximo; }

    private Celula topo;
    private int tamanho;

    public PilhaEncadeada() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void empilhar(Object item) {
        Celula auxiliar = this.topo; //Referencia o antigo topo

        this.topo = new Celula(); //Cria o novo topo
        this.topo.proximo = auxiliar; //Novo topo aponta para o antigo
        this.topo.item = item; //Adiciona o item ao novo topo
        this.tamanho++; //Atualiza o tamanho em +1
    }

    public Object desempilhar() {
        if(this.vazia()) return null; //Se a pilha está vazia, não é possível desempilhar

        Object item = this.topo.item; //Item a ser retornado

        //Se a pilha só tem um elemento, ela fica vazia, senão o topo aponta para a próxima célula
        this.topo = this.tamanho == 1 ? null : this.topo.proximo;

        this.tamanho--; //Atualiza o tamanho em -1
        return item; //Retorna o item removido
    }

    public void imprimir() {
        Celula atual = this.topo; //Referencia a primeira célula da pilha

        for(int i = 0; i < this.tamanho; i++) { //Itera pela pilha inteira

            System.out.println(atual.item); //Imprime o toString() do item na célula atual
            atual = atual.proximo; //Atualiza o valor da célula atual com a referência da próxima célula da lista
        }
    }

    public boolean vazia() { return this.tamanho == 0; }
}
