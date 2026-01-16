package aula17;

public class ShellSort {

    public static void main(String[] args) {
        int[] vetor = {1, 4, 2, 6};
        shellSort(vetor, vetor.length);
        System.out.println(java.util.Arrays.toString(vetor));
    }

    public static void shellSort(int[] v , int n) {
        int h = 1; //Lacuna entre os índices avaliados
        do
            h = h * 3 + 1; //Define o h
        while (h < n); //n é o tamanho do vetor

        do {
            h /= 3;
            for ( int i = h + 1; i <= n; i ++) {
                int x = v[i];
                int j = i;

                while (v[j - h] > x) {
                    v[j] = v[j - h] ;
                    j -= h;
                    if ( j <= h) break;
                }
                v[j] = x;
            }
        } while (h != 1);
    }


}
