package Desafio1;

import java.util.*;
import java.util.stream.Collectors;

public class Resolucao {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Informe a quantidade de números a serem digitados:");
        int n = lerValor(2);
        List<Integer> resultado = carregarValores(n);

        resultado.forEach(System.out::println);

        SCANNER.close();
    }

    private static List<Integer> carregarValores(int qtdEntradas) {
        List<Integer> listaPares = new ArrayList<>();
        List<Integer> listaImpares = new ArrayList<>();

        for (int i = 0; i < qtdEntradas; i++) {
            System.out.println("Informe um número par ou impar não negativo:");
            int valor = lerValor(0);
            if (valor % 2 == 0) {
                listaPares.add(valor);
            } else {
                listaImpares.add(valor);
            }
        }

        listaPares = ordenarCrescente(listaPares);
        listaImpares = ordenarDecrescente(listaImpares);
        listaPares.addAll(listaImpares);

        return listaPares;
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

    private static List<Integer> ordenarCrescente(List<Integer> lista) {
        return lista.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> ordenarDecrescente(List<Integer> lista) {
        return lista.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
