package aula02;

public class Lista {

    private static String[] lista;
    private static int ultimo;

    public static void criaListaVazia(int tamanho) {
        lista = new String[tamanho];
        ultimo = 0;
    }

    public static void inserir(String elemento) {
        if(lista == null) {
            System.out.println("Erro: lista não existe :(");
        } else {
            lista[ultimo] = elemento;
            ultimo++;
        }
    }

    public static void inserirEm(String elemento, int indice) {
        if(lista == null) {
            System.out.println("Erro: lista não existe :(");
        } else {
            String[] listaAuxiliar;

            if(indice > lista.length - 1) { //Se o índice for maior doq o último índice atual
                listaAuxiliar = new String[indice + 1]; //Aumenta o tamanho da lista e preenche

                for (int i = 0; i < listaAuxiliar.length; i++) {
                    if(i != indice) { //Ainda não chegou no índice do novo elemento
                        listaAuxiliar[i] = i <= lista.length - 1 ? lista[i] : null;
                    } else {
                        listaAuxiliar[i] = elemento; //Adiciona o novo elemento
                    }
                }
            } else { //O índice já existe na lista atual (só precisa deslocar tudo 1 espaço adiante)
                listaAuxiliar = new String[lista.length + 1];
                String itemAuxiliar = "";

                for (int i = 0; i < listaAuxiliar.length; i++) {
                    if(i < indice) { //Ainda não chegou no indice
                        listaAuxiliar[i] = lista[i]; //Apenas copia o item atual
                    } else { //i >= indice
                        if(i == indice) { //Achou o item a ser trocado
                            itemAuxiliar = lista[i];
                            listaAuxiliar[i] = elemento; //Troca os valores
                        } else { //i > indice --> Corrige os espaços adiante
                            listaAuxiliar[i + 1] = itemAuxiliar; //Troca os valores
                            if(i + 1 < lista.length) { //Se ainda não acabaram os elementos da lista
                                itemAuxiliar = lista[i + 1]; //Atualiza o itemAuxiliar com o próximo valor
                            } else {
                                break; //Acabaram os elementos da lista
                            }
                        }
                    }
                }
            }

            lista = listaAuxiliar; //Atualiza a lista com seu novo tamanho
        }
    }

    //Apaga o primeiro elemento
    public static String retirar() {
        if(lista == null || ultimo == 0) {
            System.out.println("Erro: lista não existe ou está vazia :(");
            return null;
        }

        String removido = lista[0];
        ultimo --;

        //Reorganizing the array's elements
        for (int i = 0; i < lista.length - 1; i++) {
            lista[i] = lista[i + 1];
        }

        if(lista[lista.length - 1] != null) {
            lista[lista.length - 1] = null;
        }

        return removido;
    }

    //Apaga um elemento numa posição qualquer
    public static String retirarEm(int indice) {
        if(lista == null || ultimo == 0) {
            System.out.println("Erro: lista não existe ou está vazia :(");
            return null;
        }

        String elemento = lista[indice];
        lista[indice] = null;

        String[] listaAuxiliar = new String[lista.length - 1];
        for (int i = 0; i < listaAuxiliar.length; i++) {
            listaAuxiliar[i] = i < indice ? lista[i] : lista[i + 1];
        }

        lista = listaAuxiliar;
        return elemento;
    }

    public static String pesquisar(String elemento) {
        if(lista == null || ultimo == 0) {
            System.out.println("Erro: lista não existe ou está vazia :(");
            return null;
        }

        for (String s : lista) { //(int i = 0; i < lista.length; i++)
            if(s != null && (s.equals(elemento) || s.contains(elemento))) {
                return s;
            }
        }

        return elemento + " não está na lista :(";
    }

    public static int pesquisarPosicao(String elemento) {
        if(lista == null || ultimo == 0) {
            System.out.println("Erro: lista não existe ou está vazia :(");
            return -1;
        }

        for (int i = 0; i < lista.length; i++) {
            if(lista[i] != null && lista[i].equals(elemento)) {
                return i;
            }
        }

        return -2;
    }

    public static void imprimeLista() {
        String retorno = "Lista[";

        for(int i = 0; i < lista.length; i++) {
            retorno += lista[i] == null ? "<Vazio>" : lista[i];

            if(i != lista.length - 1) { retorno += ", "; }
        }

        retorno += "]\n";
        System.out.println(retorno);
    }

    public static int getTamanho() {
        return lista.length;
    }

}
