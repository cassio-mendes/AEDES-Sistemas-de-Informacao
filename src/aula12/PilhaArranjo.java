
package aula12;

public class PilhaArranjo {
     private int topo;
     private Object[] pilha;
     
     public PilhaArranjo(int n){
         this.pilha = new Object[n];
         this.topo = 0;
     }
     
     public void empilha(Object elemento){
          if (this.topo >= this.pilha.length){
              System.out.println("Erro! Pilha cheia!");
              return;
          }

          this.pilha[topo] = elemento;
          this.topo++;
     }
     
     public Object desempilha(){
         if (vazia()){
             System.out.println("Erro: pilha vazia!");
             return null;
         }

         return this.pilha[--topo];
     }
     
     public Object espiar(){ // peek em Inglês
        if (vazia()){
            System.out.println("Erro: pilha vazia!");
            return null;
         }
         return this.pilha[(topo - 1)];
     }
     
     public boolean vazia(){
         if (this.pilha == null || this.topo ==0){
              return true;
         }
         return false;
     }
     
     public void imprime(){
         if (vazia()){
             System.out.println("Pilha vazia!");
             return;
         }
         for(int i= (this.topo -1); i >=0; i--){
             System.out.println(this.pilha[i]);
         }
     }
     
}
