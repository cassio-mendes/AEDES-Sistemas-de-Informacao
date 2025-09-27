package aula04;

public class Fila {

    private static Object[] fila;
    private static int fim;

    public static void criarFila(int tamanho) {
        fila = new Object[tamanho];
        fim = 0;
    }

    public static void enfileirar(Object elemento) {
        if(fila == null) {
            System.out.println("Erro: a fila não existe :(");

        } else if(fim >= fila.length) {
            System.out.println("Erro: a fila está cheia :(");

        } else {
            fila[fim] = elemento;
            fim++;
        }
    }

    public static Object desenfileirar() {
        if(fila == null) {
            System.out.println("Erro: a fila não existe :(");
            return null;
        }

        if(fim == 0) {
            System.out.println("Erro: a fila está vazia :(");
            return null;
        }

        return reenfileirar(); //Reorganiza a fila e retorna quem saiu
    }

    private static Object reenfileirar() {
        Object elementoRemovido = fila[0];
        fim--;

        for (int i = 0; i < fila.length - 1; i++) {
            fila[i] = fila[i + 1];
        }

        if(fila[fila.length - 1] != null) {
            fila[fila.length - 1] = null;
        }

        return elementoRemovido;
    }

    public static void imprimirFila() {
        if(fila == null) {
            System.out.println("Erro: a fila não existe :(");

        } else if(fim == 0) {
            System.out.println("Erro: a fila está vazia :(");

        } else {
            String retorno = "Fila[";

            for (int i = 0; i < fila.length; i++) {
                retorno += fila[i] == null ? "<Vazio>" : fila[i];

                if(i < fila.length - 1) { retorno += ", "; }
            }

            retorno += "]\n";
            System.out.println(retorno);
        }
    }

}
