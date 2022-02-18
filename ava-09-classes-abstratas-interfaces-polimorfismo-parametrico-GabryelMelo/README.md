# Atividade 09 Classes Abstratas, Interfaces e Polimorfismo Paramétrico

Link do Classroom: <https://classroom.github.com/a/DQJjKT4n>

> Não foi uma ou duas vezes que alguém
> me jogou na cara que as faculdades privadas
> de ADS formam mais do que nós do IFRS.
> Eu costumo responder com "veja bem,"
> ["eu trouxe mais soldados do que eles."](https://youtu.be/Hgg8_OHMaAs).



## Implementar e testar segundo as especificações

- O esforço estimado desta atividade está entre 6 e 12h.
- Os Casos de Teste podem ser corrigidos se estiverem mal escritos, mas **a especificação dos objetos não pode ser alterada**.
- As classes do modelo devem ficar no pacote `model` e utilitários em `util`.
- E, por fim, assegure-se de **assistir as videoaulas antes de começar**, pois lá estão explicados todos os conceitos e práticas presentes nesta atividade.



### Refatorar a interface `IBag` e a classe `Bag` para aceitarem a parametrização do tipo

Há uma classe [Bag](src/util/Bag.java) em [util](src/util/). É a mesma usada na Atividade 08. No entanto, ela foi projetada para armazenar `Object`s. O objetivo desta atividade é torná-la genérica, adicionando a parametrização do tipo em ambas interface `IBag` e classe concreta `Bag`, conforme os casos de teste abaixo:

```java
IBag textos = new Bag(5);
textos.add("um");
textos.add("texto");
textos.add("de");
textos.add("exemplo");
// Deveria sem restrito apenas a Strings, então ...
textos.add(5);
// Parametrizar o tipo na classe Bag para que as seguintes instrução funcionem:
// (decomente-as depois de pronto)
// IBag<String> nomes = new Bag<>(4);
// nomes.add("Pierre");
// nomes.add("Han");
// nomes.add("Björn");
// nomes.add(5); // esta instrução não deve compilar, mantenha comentada.

// IBag<Integer> idades = new Bag<Integer>(4);
// idades.add(45);
// idades.add(54);
// idades.add(67);
```



### Refatorar o Sistema de Frete

Em [model](src/model/) há duas classes, [Frete](src/model/Frete.java) e [Produto](src/model/Produto.java), para um sistema de frete _rudimentar_. Reprojete para que o `enum Tipo` torne-se desnecessário e possa ser excluído. Faça isto subclassificando `Frete` conforme os testes a seguir. **Importante:** o `Frete` não poderá ser instanciado senão por uma de suas subclasses, portanto torne-o abstrato. Altere as instruções para a forma de Casos de Teste.

```java
// Estas linhas devem ser comentadas depois de refatorar frete.
Frete f1 = new Frete(Tipo.Correios, p1, p2, p3);
System.out.println(f1.getValor()); // 32
Frete f2 = new Frete(Tipo.Onibus, p1, p2, p3);
System.out.println(f2.getValor()); // 12
Frete f3 = new Frete(Tipo.Transportadora, p1, p2, p3);
System.out.println(f3.getValor()); // 82

// Reprojetar Frete com subclasses para que seja possível:
// Frete f1 = new FreteCorreios(p1, p2, p3);
// System.out.println(f1.getValor()); // 32
// Frete f2 = new FreteOnibus(p1, p2, p3);
// System.out.println(f2.getValor()); // 12
// Frete f3 = new FreteTransportadora(p1, p2, p3);
// System.out.println(f3.getValor()); // 82
// E que a seguinte linha seja impossível, frete (superclasse) não deve ser instanciado:
// Frete f4 = new Frete(p1, p2, p3);
```



### Implemente a interface `IVault` (ICofre) 🔒

Considere a interface [IVault](src/util/IVault.java) onde um objeto pode ser guardado com uma senha e ser recuperado apenas com a senha correta. Implemente `Vault` com base nesta interface e escreva testes.



* * *

> Computers are useless. They can only give you answers.
>
> -- Pablo Picasso.
