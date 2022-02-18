package model;

public class Produto {

  private String descricao;
  private int valor;
  private int gramas;

  public Produto(String descricao, int valor, int gramas) {
    this.descricao = descricao;
    this.valor = valor;
    this.gramas = gramas;
  }

  public String getDescricao() {
    return descricao;
  }

  public int getGramas() {
    return gramas;
  }

  public int getValor() {
    return valor;
  }

  @Override
  public String toString() {
    return String.format("Produto %s no valor de R$ %5.2f e pesando %d gramas",
      this.descricao, this.valor, this.gramas);
  }
}
