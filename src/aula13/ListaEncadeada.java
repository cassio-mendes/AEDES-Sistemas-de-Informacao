package aula13;

public class ListaEncadeada {

    private static class Celula { Object item; Celula proximo; } //Objeto que vai armazenar dados (item)

    private Celula cabeca, ultimo; //cabeca é a célula cabeça ("vazia") e ultimo é a última célula

    public ListaEncadeada() {
        this.cabeca = new Celula();
        this.ultimo = this.cabeca;
        this.ultimo.proximo = null;
    }

    public void inserir(Object x) {
        this.ultimo.proximo = new Celula(); //Cria uma nova célula na referência proximo

        this.ultimo = this.ultimo.proximo; //Atualiza a última célula da lista, ultimo, com a célula recém-criada

        this.ultimo.item = x; //Insere o objeto x na nova célula

        this.ultimo.proximo = null; //Atualiza a referência da última célula da lista para null
    }

    public Object retirarPrimeiro() {
        if(this.vazia()) return null; //Se a lista estiver vazia, não tem o que retornar

        Object item = this.cabeca.proximo.item; //O item da primeira célula da lista

        this.cabeca = this.cabeca.proximo; //Torna a antiga primeira célula útil na célula cabeça, inutilizando-a

        return item; //Retorna o item retirado;
    }

    public Object remover(Object itemAlvo) { //Tenta remover o itemAlvo da lista
        if(this.vazia() || itemAlvo == null) return null;

        Celula auxiliar = this.cabeca; //Referência para percorrer a lista

        //Enquanto há uma próxima célula e o item nessa célula é diferente do itemAlvo
        while(auxiliar.proximo != null && !auxiliar.proximo.item.equals(itemAlvo)) {

            auxiliar = auxiliar.proximo; //Incrementa o ponteiro
        }

        if(auxiliar.proximo == null) return null; //Item não encontrado

        Celula celulaRemovida = auxiliar.proximo; //Célula a ser removida
        Object retorno = celulaRemovida.item; //Item encontrado, pronto para ser retornado

        //O ponteiro proximo da célula auxiliar passa a ser o proximo da célula removida, para manter a continuidade
        auxiliar.proximo = celulaRemovida.proximo;

        if(auxiliar.proximo == null) { //Significa que, agora, a célula auxiliar é a última da lista

            this.ultimo = auxiliar; //Atualiza o ponteiro ultimo da lista
        }

        return retorno; //Retorna o item encontrado
    }

    public boolean pesquisa(Object itemPesquisado) { //Retorna se o itemPesquisado está na lista
        if(this.vazia() || itemPesquisado == null) //Se a lista está vazia, ou itemPesquisado é nulo
            return false; //Não tem como pesquisar

        Celula atual = this.cabeca.proximo; //Célula atual da lista
        while(atual != null) { //Percorre a lista até atual ser igual à referência proximo de ultimo, que é null

            if(atual.item.equals(itemPesquisado)) return true; //Se encontrou o item, retorna true
            atual = atual.proximo; //Senão, vai para a próxima célula
        }

        return false; //Item não encontrado
    }

    public void imprimir() {
        Celula atual = this.cabeca.proximo; //Referencia a primeira célula da lista

        while(atual != null) { //Enquanto a referência da célula atual for diferente de null

            System.out.println(atual.item); //Imprime o toString() do item na célula atual
            atual = atual.proximo; //Atualiza o valor da célula atual com a referência da próxima célula da lista
        }
    }

    public boolean vazia() { return this.cabeca == this.ultimo; } //Retorna se a lista está vazia
}
