package aula06;

public class Ordenacao {

    public static double[] insere(double[] ordenado, double[] desordenado) {
        double[] auxiliar = new double[ordenado.length + desordenado.length];

        //Preenchendo o vetor auxiliar
        for (int i = 0; i < ordenado.length; i++) {
            auxiliar[i] = ordenado[i];
        }

        for (int i = ordenado.length; i < auxiliar.length; i++) {
            auxiliar[i] = desordenado[i - ordenado.length];
        }

        //Ordenando o vetor completo
        double numAuxiliar;
        for (int i = 0; i < auxiliar.length - 1; i++) {
            for (int j = i; j < auxiliar.length; j++) {
                if(auxiliar[j] < auxiliar[i]) {
                    numAuxiliar = auxiliar[j];
                    auxiliar[j] = auxiliar[i];
                    auxiliar[i] = numAuxiliar;
                }
            }
        }

        return auxiliar; //Retornando o vetor ordenado
    }

}
