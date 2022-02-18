import model.*;
import util.*;

class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    IBag<String> textos = new Bag<>(5);
    textos.add("um");
    textos.add("texto");
    textos.add("de");
    textos.add("exemplo");

    // Deveria sem restrito apenas a Strings, então ...
    // textos.add(5);
    // Parametrizar o tipo na classe Bag para que as seguintes instrução funcionem:
    // (decomente-as depois de pronto)
    IBag<String> nomes = new Bag<>(4);
    nomes.add("Pierre");
    nomes.add("Han");
    nomes.add("Björn");
    // nomes.add(5); // esta instrução não deve compilar, mantenha comentada.

    IBag<Integer> idades = new Bag<Integer>(4);
    idades.add(45);
    idades.add(54);
    idades.add(67);

    Produto p1 = new Produto("Produto 1", 150, 1500);
    Produto p2 = new Produto("Produto 2", 200, 2000);
    Produto p3 = new Produto("Produto 3", 400, 4000);

    //Frete f1 = new Frete(Tipo.Correios, p1, p2, p3);
    //System.out.println(f1.getValor()); // 32
    //Frete f2 = new Frete(Tipo.Onibus, p1, p2, p3);
    //System.out.println(f2.getValor()); // 12
    //Frete f3 = new Frete(Tipo.Transportadora, p1, p2, p3);
    //System.out.println(f3.getValor()); // 82

    // Reprojetar Frete com subclasses para que seja possível:
    Frete f1 = new FreteCorreios(p1, p2, p3);
    System.out.println(f1.getValor() == 32); // 32
    Frete f2 = new FreteOnibus(p1, p2, p3);
    System.out.println(f2.getValor() == 12); // 12
    Frete f3 = new FreteTransportadora(p1, p2, p3);
    System.out.println(f3.getValor() == 82); // 82
    // E que a seguinte linha seja impossível:
    // Frete f4 = new Frete(p1, p2, p3);

    IVault<String, Integer> cofre = new Vault<String, Integer>();
    cofre.store("Um texto secreto", 232323, (pwd) -> pwd > 100 & pwd % 11 != 0);

    String texto = cofre.retrieve(232323); // "Um texto secreto"

    // escreva testes 👇
    System.out.println(texto.equals("Um texto secreto"));

    Vault<String, String> vault1 = new Vault<>();
    vault1.store("Caneta", "ABCDE*", (pwd) -> pwd.length() >= 5 & pwd.contains("*"));

    System.out.println(vault1.retrieve("ABCDE*").equals("Caneta"));

    Vault<Integer, String> vault2 = new Vault<>();
    vault2.store(250000, "SenhaForte", (pwd) -> pwd.length() >= 5 & !pwd.isEmpty() & !pwd.isBlank());

    System.out.println(vault2.retrieve("SenhaForte") == 250000);

  }
}
