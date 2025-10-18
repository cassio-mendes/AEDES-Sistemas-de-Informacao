package aula06;

public class Ordenacao {

    public static double[] insere(double[] ordenado, double[] desordenado) {
        double[] auxiliar = new double[ordenado.length + desordenado.length];

        //Preenchendo o vetor auxiliar
        for (int i = 0; i < ordenado.length; i++) {
            auxiliar[i] = ordenado[i];
        }

        //Ordenando o auxiliar de acordo com os valores do vetor desordenado
        boolean inseriu = false;
        int indice = ordenado.length;

        for (int i = 0; i < desordenado.length; i++) {
            for (int j = indice; j > 0; j--) {
                if(desordenado[i] < auxiliar[j - 1]) {
                    auxiliar[j] = auxiliar[j - 1];
                    auxiliar[j - 1] = desordenado[i];
                    inseriu = true;
                }
            }

            if(!inseriu) { auxiliar[indice] = desordenado[i]; }
            inseriu = false;
            indice++;
        }

        return auxiliar; //Retornando o vetor ordenado com todos os valores
    }

}
