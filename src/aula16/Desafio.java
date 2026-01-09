package aula16;

public class Desafio {

    public static void main(String[] args) {
        String expressao = "1-(12/6)";

        System.out.println(resolver(expressao));
    }

    static int resolver(String expressao) {
        char[] caracteres = expressao.toCharArray();

        int[] operandos = new int[2];
        int indice = 0;

        char operador = '+';

        for (int i = 0; i < caracteres.length; i++) {
            if(caracteres[i] != '(') {
                if(caracteres[i] != ')') {
                    try { //É um número ou um operador?

                        int numero = Integer.parseInt(String.valueOf(caracteres[i]));

                            try { //Verificação para números com mais de dois dígitos:
                                int numAtual, proxNum;

                                if(i == 0) {
                                    Integer.parseInt(String.valueOf(caracteres[i]));
                                    numAtual = caracteres[i];
                                    proxNum = caracteres[i + 1];
                                } else {
                                    Integer.parseInt(String.valueOf(caracteres[i - 1]));
                                    numAtual = caracteres[i - 1];
                                    proxNum = caracteres[i];
                                }

                                //Número com mais de um dígito
                                String numeroCompleto = String.valueOf(numAtual);
                                numeroCompleto += String.valueOf(proxNum);

                                //Verifica próximo número
                                if(i != caracteres.length - 1) { //Só precisa continuar testando se não for o último
                                    boolean acabou = false;
                                    int indiceAuxiliar = i + 1;

                                    while(!acabou) {
                                        if(indiceAuxiliar == caracteres.length) break;

                                        try {
                                            int proximoNumero = Integer.parseInt(String.valueOf(caracteres[indiceAuxiliar]));
                                            numeroCompleto += String.valueOf(proximoNumero);

                                            indiceAuxiliar++;

                                        } catch (NumberFormatException e3) {
                                            acabou = true;
                                        }
                                    }
                                }

                                operandos[indice] = Integer.parseInt(numeroCompleto);

                            } catch (NumberFormatException e2) {
                                //Número de dígito único
                                operandos[indice] = numero;
                            }

                        operandos[indice] = numero;
                        indice++;

                    } catch(NumberFormatException e) {
                        operador = caracteres[i];
                    }
                }
            } else {
                String substring = expressao.substring(i + 1, indexOfParenteses(expressao));

                operandos[indice] = resolver(substring);
                break;
            }
        }

        //Resolver expressão completa
        switch (operador) {
            case '+': return operandos[0] + operandos[1];

            case '-': return operandos[0] - operandos[1];

            case '*': return operandos[0] * operandos[1];

            case '/': return operandos[0] / operandos[1];

            default: return 0;
        }
    }

    static int indexOfParenteses(String expressao) {
        for(int i = 0; i < expressao.length(); i++) {
            if(expressao.charAt(i) == ')')
                return i;
        }

        return -1;
    }

}
