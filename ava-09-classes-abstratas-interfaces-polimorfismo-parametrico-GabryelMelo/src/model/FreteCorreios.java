package model;

public class FreteCorreios extends Frete {

  public FreteCorreios(Produto... produtos) {
    super(Tipo.Correios, produtos);
  }

}
