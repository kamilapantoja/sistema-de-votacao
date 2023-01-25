package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe GerencimentoVotação.
 */
public class GerenciamentoVotacao {
  private List<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private List<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private List<String> cpfComputado = new ArrayList<>();
  private int totalVotos;

  /**
   * método cadastrarPessoaCandidata.
   */
  
  // Sobre o uso do método .stream() . São tipo as HOFs do Javascript.
  // https://deviniciative.wordpress.com/2021/08/23/entendendo-o-java-stream-api/
  // https://www.devmedia.com.br/java-streams-api-manipulando-colecoes-de-forma-eficiente/37630#:~:text=A%20proposta%20em%20torno%20da,%2C%20mapeamento%2C%20transforma%C3%A7%C3%A3o%2C%20etc.
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (pessoasCandidatas.stream().anyMatch(candidato -> candidato.getNumero() == numero)) {
      System.out.println("Número pessoa candidata já utilizado!");
      return;
    }

    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * método cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras.stream().anyMatch(eleitora -> eleitora.getCpf().equals(cpf))) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  /**
   * método votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    PessoaCandidata candidato = pessoasCandidatas.stream()
        .filter(cand -> cand.getNumero() == numeroPessoaCandidata).findFirst().orElse(null);

    if (candidato == null) {
      System.out.println("Número de pessoa candidata não encontrado");
      return;
    }

    candidato.receberVoto();
    cpfComputado.add(cpfPessoaEleitora);
    totalVotos += 1;
  }

  /**
   * método mostrarResultado.
   */
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
      return;
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      int votos = candidato.getVotos();
      double porcentagem = (double) votos / totalVotos * 100;
      System.out.println(
          "Nome: " + candidato.getNome() + " - " + votos + " votos (" + porcentagem + "%)");
    }
    System.out.println("Total de votos: " + totalVotos);
  }
}
