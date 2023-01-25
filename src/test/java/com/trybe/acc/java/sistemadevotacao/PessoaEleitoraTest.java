package com.trybe.acc.java.sistemadevotacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.trybe.acc.java.sistemadevotacao.PessoaEleitora;

public class PessoaEleitoraTest {
  @Test
  @DisplayName("2 - Testando método getNome da classe PessoaEleitora")
  public void testarGetNome() {
    PessoaEleitora objetoTeste = new PessoaEleitora("Pessoa Eleitora", "1");

    assertEquals("Pessoa Eleitora", objetoTeste.getNome());
  }

  @Test
  @DisplayName("3 - Testando método setNome da classe PessoaEleitora")
  public void testarSetNome() {
    PessoaEleitora objetoTeste = new PessoaEleitora("Pessoa Eleitora", "1");
    objetoTeste.setNome("Pessoa Eleitora Alterado");
    assertEquals("Pessoa Eleitora Alterado", objetoTeste.getNome());
  }

  @Test
  @DisplayName("4 - Testando método getCpf da classe PessoaEleitora")
  public void testarGetNumero() {
    PessoaEleitora objetoTeste = new PessoaEleitora("Pessoa Eleitora", "1");

    assertEquals("1", objetoTeste.getCpf());
  }

  @Test
  @DisplayName("5 - Testando método setCpf da classe PessoaEleitora")
  public void testarSetNumero() {
    PessoaEleitora objetoTeste = new PessoaEleitora("Pessoa Eleitora", "1");
    objetoTeste.setCpf("2");
    assertEquals("2", objetoTeste.getCpf());
  }
}
