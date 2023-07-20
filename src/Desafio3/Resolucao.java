package Desafio3;

import java.util.*;
import java.util.stream.Collectors;

public class Resolucao {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite um valor alvo (K): ");
        int k = lerValor(1);

        System.out.println("Digite uma quantidade de entradas (N): ");
        int n = lerValor(1);
        List<Integer> entrada = carregarValores(n);

        entrada = ordenarDecrescente(entrada);

        int count = 0;
        for (int i = 0; i < entrada.size() - 1; i++) {
            int valorAtual = entrada.get(i);
            for (int j = i + 1; j < entrada.size(); j++) {
                if (valorAtual - entrada.get(j) == k) {
                    count++;
                }
            }
        }

        System.out.println();
        System.out.println("Quantidade: " + count);

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

    private static List<Integer> carregarValores(int qtdEntradas) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < qtdEntradas; i++) {
            System.out.println("Informe um número positivo:");
            int valor = lerValor(0);
            numeros.add(valor);
        }

        return numeros;
    }

    private static List<Integer> ordenarDecrescente(List<Integer> lista) {
        return lista.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
