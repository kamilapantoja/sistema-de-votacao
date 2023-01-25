package com.trybe.acc.java.sistemadevotacao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.trybe.acc.java.sistemadevotacao.Principal;

public class PrincipalTest {

  @Test
  @DisplayName("1 - Testando o método Principal")
  public void testePrincipal() {

    String userInput =
        String.format("1%sPessoaCandidata%s1%s2%s1%sPessoaEleitora%s1%s2%s1%s1%s1%s3",
            System.lineSeparator(), System.lineSeparator(), System.lineSeparator(),
            System.lineSeparator(), System.lineSeparator(), System.lineSeparator(),
            System.lineSeparator(), System.lineSeparator(), System.lineSeparator(),
            System.lineSeparator(), System.lineSeparator());

    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(bais);

    String esperado = "Total de votos: 1";

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    Principal.main(null);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = linha[linha.length - 1];

    assertEquals(esperado, saida);

  }


}
