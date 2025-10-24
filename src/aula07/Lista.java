package aula07;

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

    //MÉTODOS DE ORDENAÇÃO DA LISTA\\

    //Metodo de SELEÇÃO
    public static void sortSelecao(Object[] vetor, int numElementos) {
        Integer[] v = (Integer[])vetor;
        int menor, auxiliar;

        for(int i = 0; i < numElementos - 1; i++){
            menor = i;

            for(int j = i + 1; j < numElementos; j++) {
                if(v[j] < v[i]) {
                    menor = j;
                }
            }

            if(v[i] != v[menor]) {
                auxiliar = v[i];
                v[i] = v[menor];
                v[menor] = auxiliar;
            }
        }
    }

    //Metodo de INSERÇÃO
    public static void sortInsercao(Object[] vetor, int numElementos) {
        Integer[] v = (Integer[])vetor;
        int auxiliar;

        for(int i = 1; i < numElementos; i++) {
            auxiliar = v[i];
            int j = i-1;

            while(j >= 0 && v[j] > auxiliar) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = auxiliar;
        }
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
