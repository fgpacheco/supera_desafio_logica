package Desafio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Resolucao {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite a quantidade de casos de testes: ");
        int qtdEntradas = lerValor(1);

        SCANNER.nextLine();
        for (int i = 0; i < qtdEntradas; i++) {
            System.out.println("Informe uma frase:");
            String entrada = lerFrase(2, 100);
            String entradaDecifrada = decifrar(entrada.toUpperCase());
            System.out.println(entradaDecifrada);
        }
        
        SCANNER.close();
    }

    private static int lerValor(int valorComparativo) {
        int valor = -1;
        while (valor < valorComparativo) {
            try {
                valor = SCANNER.nextInt();
                if (valor < valorComparativo) {
                    System.out.println("Informe um valor válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Informe um valor válido.");
                SCANNER.next();
            }
        }
        return valor;
    }

    private static String lerFrase(int minimoCaracteres, int maximoCaracteres) {
        String frase = "";
        while (frase.length() < minimoCaracteres || frase.length() > maximoCaracteres) {
            frase = SCANNER.nextLine();
            if (frase.length() < minimoCaracteres || frase.length() > maximoCaracteres) {
                System.out.printf("Informe uma frase válida entre %d e %d caracteres.%n", minimoCaracteres, maximoCaracteres);
            }
        }
        return frase;
    }

    private static String decifrar(String entradaCifrada) {
        int metadeEntrada = entradaCifrada.length() / 2;
        String primeiraParte = entradaCifrada.substring(0, metadeEntrada);
        String segundaParte = entradaCifrada.substring(metadeEntrada);

        char[] caracteresPrimeiraParte = primeiraParte.toCharArray();
        char[] caracteresSegundaParte = segundaParte.toCharArray();

        String resultado = "";
        for (int i = caracteresPrimeiraParte.length - 1; i >= 0; i--) {
            resultado += caracteresPrimeiraParte[i];
        }

        for (int i = caracteresSegundaParte.length - 1; i >= 0; i--) {
            resultado += caracteresSegundaParte[i];
        }

        return resultado;
    }
}
