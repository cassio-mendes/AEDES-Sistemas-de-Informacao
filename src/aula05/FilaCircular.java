package aula05;

public class FilaCircular {

    private static Object[] fila;
    private static int frente, tras;

    public static void criarFila(int tamanho) {
        fila = new Object[tamanho];
        frente = tras = 0;
    }

    public static void enfileirar(Object elemento) {
        if(fila == null) {
            System.out.println("Erro: a fila não existe :(");

        } else if((tras + 1) % fila.length == frente) {
            System.out.println("Erro: a fila está cheia :(");

        } else {
            fila[tras] = elemento;
            tras = (tras + 1) % fila.length;
        }
    }

    public static Object desenfileirar() {
        if(fila == null) {
            System.out.println("Erro: a fila não existe :(");
            return null;
        }

        if(frente == tras) {
            System.out.println("Erro: a fila está vazia :(");
            return null;
        }

        Object elemento = fila[frente];
        frente = (frente + 1) % fila.length;

        return elemento;
    }

    public static int getTamanho() {
        int tamanho = 0;

        for(int i = frente; (i != tras); i++) {
            tamanho++;
        }

        return tamanho;
    }

    public static void imprimirFila() {
        if(fila == null) {
            System.out.println("Erro: a fila não existe :(");

        } else if(frente == tras) {
            System.out.println("Erro: a fila está vazia :(");

        } else {
            String retorno = "FilaCircular[";

            for (int i = frente; (i != tras); i++) {
                retorno += fila[i];

                if(i != tras - 1) { retorno += ", "; }
            }

            retorno += "]";
            System.out.println(retorno);
            System.out.println("Tamanho da fila circular: " + fila.length + "\n");
        }
    }

}
