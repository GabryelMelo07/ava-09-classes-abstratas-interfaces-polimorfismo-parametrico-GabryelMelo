package model;

public abstract class Frete {

  public enum Tipo {
    Correios,
    Transportadora,
    Onibus
  }

  private Tipo tipo;
  private Produto[] produtos;

  public Frete(Tipo tipo, Produto... produtos) {
    this.tipo = tipo;
    this.produtos = produtos;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public Produto[] getProdutos() {
    return produtos;
  }

  public int getValor() {
    switch (this.tipo) {
      case Correios: {
        int valor = 2;
        for (Produto p : produtos) {
          if (p.getGramas() > 500) {
            valor += 2 * (p.getGramas() / 500);
          }
        }
        return valor;
      }
      case Onibus: return 4 * this.produtos.length;
      case Transportadora: {
        int valor = 0;
        for (Produto p : produtos) {
          valor += p.getGramas() / 100 + p.getValor() / 100;
        }
        return valor;
      }
      default: return 0;
    }
  }

}
