package aula01;

import java.util.Scanner;

public class Convidados {
    public static void main(String[] args) {
        String[] vetor = new String[5]; // 0,1,2,3,4
        int contaPessoas = 0;

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        char resposta = ' ';

        while(true){
            vetor = adicionarConvidado(in, vetor, contaPessoas);
            contaPessoas++;

            if (contaPessoas >= vetor.length){
                String[] aux = new String[vetor.length*2];
                for (int i = 0; i < contaPessoas; i++){
                    aux[i] = vetor[i];
                }
                vetor = aux;
            }

            resposta = escolherOpcao(in2);

            if(resposta == 'S'){
                break;
            } else if(resposta == 'E') {
                System.out.println("Deseja excluir o primeiro(1), o último(2), ou algum índice específico(3)?");
                int opcao2 = in.nextInt();
                in.skip("\n");

                switch(opcao2) {
                    case 1: vetor = excluirConvidado1(vetor); break;
                    case 2: vetor = excluirConvidado2(vetor); break;
                    case 3:
                        System.out.print("Informe o índice do convidado a ser excluído: ");
                        int indice = in.nextInt();
                        in.skip("\n");

                        vetor = excluirConvidadoQualquer(vetor, indice);
                }

                if(vetor == null) {
                    System.out.println("A lista está vazia");
                } else {
                    contaPessoas--;
                }
            }

        }

        imprimeLista(vetor);
        
        System.out.print("Pesquisa: ");
        String convidado = in.nextLine();
        String nome = pesquisaConvidado(convidado, vetor);
        

        if (nome == null){
            System.out.println(convidado + " não convidado!");
        }else{
            System.out.println(convidado + " está na lista");
        }    

        in.close();
        in2.close();
    }
    
    static char escolherOpcao(Scanner in2) {
        System.out.println("Deseja parar?(S/N), ou excluir algum convidado?(E) ");
        return in2.next().toUpperCase().charAt(0);
    }

    static String[] adicionarConvidado(Scanner in, String[] vetor, int contaPessoas) {
        System.out.print("Dê o nome: ");
        vetor[contaPessoas] = in.nextLine();

        return vetor;
    }

    static void imprimeLista(String[] vetor) {
        System.out.println("aula02.Lista de aula01.Convidados ");

        for(int i = 0; i < vetor.length; i++){
            System.out.println(i + "- " + vetor[i]);
        }
    }

    static String pesquisaConvidado(String convidado, String[] vetor) {
        for(int i = 0; i < vetor.length; i++){
           if(convidado.equalsIgnoreCase(vetor[i])){
              return convidado;
           }
        }

        return null;
    }

    static String[] excluirConvidado1(String[] vetor) {
        if(vetor[0] == null) {
            return null;
        }

        String[] retorno = new String[vetor.length - 1];

        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = vetor[i + 1];
        }

        return retorno;
    }

    static String[] excluirConvidado2(String[] vetor) {
        if(vetor[0] == null) {
            return null;
        }

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == null) {
                vetor[i - 1] = null;
            }
        }

        return vetor;
    }

    static String[] excluirConvidadoQualquer(String[] vetor, int indice) {
        if(vetor == null) {
            return null;
        }

        vetor[indice] = null;
        return vetor;
    }

}
