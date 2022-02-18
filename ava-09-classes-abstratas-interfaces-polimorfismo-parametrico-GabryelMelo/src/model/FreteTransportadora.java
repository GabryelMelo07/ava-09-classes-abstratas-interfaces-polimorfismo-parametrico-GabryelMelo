package model;

public class FreteTransportadora extends Frete {

  public FreteTransportadora(Produto... produtos) {
    super(Tipo.Transportadora, produtos);
  }

}
