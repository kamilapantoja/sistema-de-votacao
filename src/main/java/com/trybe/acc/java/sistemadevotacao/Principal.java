
package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {

  private static GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

  /**
   * Método Principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("-----Bem Vindo-----");
    cadastrarPessoaCandidata(scanner);
    cadastrarPessoaEleitora(scanner);
    votarOuMostrarResultado(scanner);
    scanner.close();
  }

  private static void cadastrarPessoaCandidata(Scanner scanner) {
    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      int opcaoDesejada = scanner.nextInt();

      if (opcaoDesejada == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomePessoaCandidata = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroPessoaCandidata = scanner.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nomePessoaCandidata, numeroPessoaCandidata);
      } else if (opcaoDesejada == 2) {
        break;
      }
    }
  }

  private static void cadastrarPessoaEleitora(Scanner scanner) {
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      int opcaoDesejada = scanner.nextInt();

      if (opcaoDesejada == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomePessoaEleitora = scanner.next();
        System.out.println("Entre com o número da pessoa eleitora:");
        String cpfPessoaEleitora = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nomePessoaEleitora, cpfPessoaEleitora);
      } else if (opcaoDesejada == 2) {
        break;
      }
    }
  }

  private static void votarOuMostrarResultado(Scanner scanner) {
    while (true) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      int opcaoDesejada = scanner.nextInt();

      if (opcaoDesejada == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfPessoaEleitora = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroPessoaCandidata = scanner.nextInt();
        gerenciamentoVotacao.votar(cpfPessoaEleitora, numeroPessoaCandidata);
      } else if (opcaoDesejada == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (opcaoDesejada == 3) {
        gerenciamentoVotacao.mostrarResultado();
        break;
      }
    }
  }
}
