
package aula12;

public class ListaArranjo {
    private Object[] lista;
    private int ultimo;
    
    public ListaArranjo(int n){
        this.lista = new Object[n];
        this.ultimo = 0;
    }

    //Insere no final
    public void insere(Object elemento){
        if((lista == null) || (ultimo >= lista.length)){
            System.out.println("Erro: lista cheia");
            return; //termina a exec do metodo
        } 
        lista[ultimo] = elemento;
        ultimo++;
    }
    //Exclui o primeiro elemento
    public Object retira(){
        if (lista == null || ultimo == 0){
            System.out.println("Erro: lista vazia");
            return null; 
        }

        Object elemento = lista[0];
        ultimo--;

        //Reorganiza os elementos no vetor lista
        for(int i=0;i< ultimo; i++){
            lista[i] = lista[i+1];
        }
        return elemento;
    }
    
    public int tamanho(){
        return ultimo;
    }

    public Object primeiro() {
        if(this.ultimo <= 0)
            return null;

        return this.lista[0];
    }

    public boolean vazia() {
        return this.ultimo == 0;
    }

    public void imprime(){
        if((lista == null) || ultimo==0){
            System.out.println("Erro: lista vazia");
            return;
        }    
        for(int i=0; i < ultimo; i++){
            System.out.println(lista[i]);
        }
    }
}
