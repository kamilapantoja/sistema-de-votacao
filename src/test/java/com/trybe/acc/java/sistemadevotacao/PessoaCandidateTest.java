package com.trybe.acc.java.sistemadevotacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.trybe.acc.java.sistemadevotacao.PessoaCandidata;

public class PessoaCandidateTest {
  @Test
  @DisplayName("6 - Testando método getNome da classe PessoaCandidata")
  public void testarGetNome() {
    PessoaCandidata objetoTeste = new PessoaCandidata("Pessoa Candidata", 1);

    assertEquals("Pessoa Candidata", objetoTeste.getNome());
  }

  @Test
  @DisplayName("7 - Testando método setNome da classe PessoaCandidata")
  public void testarSetNome() {
    PessoaCandidata objetoTeste = new PessoaCandidata("Pessoa Candidata", 1);
    objetoTeste.setNome("Pessoa Candidata Alterado");
    assertEquals("Pessoa Candidata Alterado", objetoTeste.getNome());
  }

  @Test
  @DisplayName("8 - Testando método getNumero da classe PessoaCandidata")
  public void testarGetNumero() {
    PessoaCandidata objetoTeste = new PessoaCandidata("Pessoa Candidata", 1);

    assertEquals(1, objetoTeste.getNumero());
  }

  @Test
  @DisplayName("9 - Testando método setNumero da classe PessoaCandidata")
  public void testarSetNumero() {
    PessoaCandidata objetoTeste = new PessoaCandidata("Pessoa Candidata", 1);
    objetoTeste.setNumero(2);
    assertEquals(2, objetoTeste.getNumero());
  }
}
