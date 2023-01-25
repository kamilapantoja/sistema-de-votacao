package com.trybe.acc.java.sistemadevotacao;

/**
 * classe PessoaCandidata.
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * construtor pessoaCandidata.
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    votos++;
  }
}
