package Desafio2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Resolucao {

    private static final List<Integer> NOTAS_DISPONIVEIS = List.of(100, 50, 20, 10, 5, 2);
    private static final List<Double> MOEDAS_DISPONIVEIS = List.of(1.0, 0.50, 0.25, 0.10, 0.05, 0.01);

    public static void main(String[] args) {
        System.out.print("Digite o valor: ");
        double dinheiro = lerValor(0, 100);

        int[] notasDecompostas = new int[NOTAS_DISPONIVEIS.size()];
        int[] moedasDecompostas = new int[MOEDAS_DISPONIVEIS.size()];

        for (int i = 0; i < NOTAS_DISPONIVEIS.size(); i++) {
            notasDecompostas[i] = (int) (dinheiro / NOTAS_DISPONIVEIS.get(i));
            notasDecompostas[i] = (int) (dinheiro / NOTAS_DISPONIVEIS.get(i));
            dinheiro -= notasDecompostas[i] * NOTAS_DISPONIVEIS.get(i);
        }

        for (int i = 0; i < MOEDAS_DISPONIVEIS.size(); i++) {
            moedasDecompostas[i] = (int) (dinheiro / MOEDAS_DISPONIVEIS.get(i));
            dinheiro -= moedasDecompostas[i] * MOEDAS_DISPONIVEIS.get(i);
        }

        mostrarQuantidadeDeNotas(notasDecompostas);
        mostrarQuantidadeDeMoedas(moedasDecompostas);
    }

    private static void mostrarQuantidadeDeNotas(int[] notasDecompostas) {
        System.out.println("NOTAS:");
        for (int i = 0; i < NOTAS_DISPONIVEIS.size(); i++) {
            System.out.printf("%d nota(s) de R$ %s%n", notasDecompostas[i], NOTAS_DISPONIVEIS.get(i));
        }
    }

    private static void mostrarQuantidadeDeMoedas(int[] moedasDecompostas) {
        System.out.println("MOEDAS:");
        for (int i = 0; i < MOEDAS_DISPONIVEIS.size(); i++) {
            System.out.printf("%d moeda(s) de R$ %s%n", moedasDecompostas[i], MOEDAS_DISPONIVEIS.get(i));
        }
    }

    private static double lerValor(double valorMinimo, double valorMaximo) {
        try (Scanner scanner = new Scanner(System.in)) {
            double valor = -1;
            while (valor < valorMinimo || valor > valorMaximo) {
                try {
                    valor = scanner.nextDouble();
                    if (valor < valorMinimo || valor > valorMaximo) {
                        System.out.println("Informe um valor válido.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Informe um valor válido.");
                    scanner.next();
                }
            }
            return valor;
        }
    }
}






