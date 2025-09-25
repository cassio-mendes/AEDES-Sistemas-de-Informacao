package aula03;

public class Lista {

    private static Object[] lista;
    private static int ultimo; //Índice do primeiro espaço vazio

    public static void criaListaVazia(int tamanho) {
        lista = new Object[tamanho];
        ultimo = 0;
    }

    public static void inserir(Object elemento) {
        if (lista == null) {
            System.out.println("Erro: lista não existe :(");

        } else if(ultimo >= lista.length) {
            System.out.println("Erro: lista cheia :(");

        } else {
            lista[ultimo] = elemento;
            ultimo++;
        }
    }

    //Apaga o primeiro elemento
    public static Object retirar() {
        if(lista == null || ultimo == 0) {
            System.out.println("Erro: lista não existe ou está vazia :(");
            return null;
        }

        //Registra o valor removido e atualiza o índice ultimo
        Object removido = lista[0];
        ultimo --;

        //Reorganizando os elementos da lista
        for (int i = 0; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }

        if(lista[lista.length - 1] != null) { //Tornando o último elemento nulo
            lista[lista.length - 1] = null;
        }

        return removido; //Retornando o elemento removido
    }

    public static void imprimeLista() {
        if(lista == null) {
            System.out.println("Erro: lista não existe :(");
            return;
        } else if(ultimo == 0) {
            System.out.println("Erro: lista vazia :(");
            return;
        }

        String retorno = "Lista[";

        for(int i = 0; i < lista.length; i++) {
            retorno += lista[i] == null ? "<Vazio>" : lista[i];

            if(i != lista.length - 1) { retorno += ", "; }
        }

        retorno += "]\n";
        System.out.println(retorno);
    }

}
