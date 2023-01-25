package com.trybe.acc.java.sistemadevotacao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.trybe.acc.java.sistemadevotacao.GerenciamentoVotacao;

public class GerenciamentoVotacaoTest {
  @Test
  @DisplayName("10 - Testando cadastro de pessoa candidata e eleitora e testando o método votar")
  public void testarCadastrarPessoaCandidataPessoaEleitoraMetodoVotar() {
    GerenciamentoVotacao objetoTeste = new GerenciamentoVotacao();

    // testando cadastro de pessoa candidata e eleitora
    objetoTeste.cadastrarPessoaCandidata("Pessoa Candidata", 1);
    objetoTeste.cadastrarPessoaEleitora("Pessoa Eleitora", String.valueOf(1));


    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    // testando o método votar
    objetoTeste.votar(String.valueOf(1), 1);
    objetoTeste.mostrarResultado();

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(",", linha);

    assertTrue(saida.contains("Pessoa Candidata"));

  }

  @Test
  @DisplayName("11 - Testando cadastro de número pessoa candidata repetido")
  public void testarCadastrarPessoaCandidataDuasVezes() {
    GerenciamentoVotacao objetoTeste = new GerenciamentoVotacao();
    objetoTeste.cadastrarPessoaCandidata("Pessoa Candidata 1", 1);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    objetoTeste.cadastrarPessoaCandidata("Pessoa Candidata 2", 1);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(",", linha);

    assertTrue(saida.contains("utilizado"));


  }


  @Test
  @DisplayName("12 - Testando cadastro de pessoa eleitora repetido")
  public void testarCadastrarPessoaEleitoraDuasVezes() {
    GerenciamentoVotacao objetoTeste = new GerenciamentoVotacao();
    objetoTeste.cadastrarPessoaEleitora("Pessoa eleitora 1", String.valueOf(1));

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    objetoTeste.cadastrarPessoaEleitora("Pessoa eleitora 1", String.valueOf(1));

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(",", linha);

    assertTrue(saida.contains("eleitora"));

  }

  @Test
  @DisplayName("13 - Testando voto de pessoa eleitora pela segunda vez")
  public void testarVotarPessoaEleitoraDuasVezes() {
    GerenciamentoVotacao objetoTeste = new GerenciamentoVotacao();

    objetoTeste.cadastrarPessoaCandidata("Pessoa Candidata", 1);
    objetoTeste.cadastrarPessoaEleitora("Pessoa Eleitora", String.valueOf(1));
    objetoTeste.votar(String.valueOf(1), 1);


    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    objetoTeste.votar(String.valueOf(1), 1);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(",", linha);

    assertTrue(saida.contains("eleitora"));

  }


  @Test
  @DisplayName("14 - Testando método mostarResultado e calcularPorcentagemVotos")
  public void testarMostrarResultado() {
    GerenciamentoVotacao objetoTeste = new GerenciamentoVotacao();

    // testando cadastro de pessoa candidata e eleitora
    objetoTeste.cadastrarPessoaCandidata("Pessoa Candidata 1", 1);
    objetoTeste.cadastrarPessoaCandidata("Pessoa Candidata 2", 2);

    objetoTeste.cadastrarPessoaEleitora("Pessoa Eleitora 1", String.valueOf(1));
    objetoTeste.cadastrarPessoaEleitora("Pessoa Eleitora 2", String.valueOf(2));
    objetoTeste.cadastrarPessoaEleitora("Pessoa Eleitora 3", String.valueOf(3));


    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    objetoTeste.votar(String.valueOf(1), 1);
    objetoTeste.votar(String.valueOf(2), 2);
    objetoTeste.votar(String.valueOf(3), 2);

    objetoTeste.mostrarResultado();

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(",", linha);

    assertTrue(saida.contains("33"));

  }
}
