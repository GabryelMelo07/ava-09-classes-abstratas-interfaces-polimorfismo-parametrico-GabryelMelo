package model;

public class FreteOnibus extends Frete {

  public FreteOnibus(Produto... produtos) {
    super(Tipo.Onibus, produtos);
  }

}
