package util;

public class Bag<T> implements IBag<T> {

  private T[] objetos;

  /**
   * Cria uma bolsa de objetos.
   * @param capacidade Capacidade da bolsa.
   */
  @SuppressWarnings("unchecked")
  public Bag(int capacidade) {
    this.objetos = (T[]) new Object[capacidade];
  }

  public boolean isEmpty() {
    return this.count() == 0;
  }

  public int count() {
    int count = 0;
    for (T o : this.objetos) {
      if (o != null) {
        count++;
      }
    }
    return count;
  }

  public void add(T o) throws FullBagException {
    if (this.count() == this.objetos.length + 1) {
      throw new FullBagException(this.objetos.length + 1);
    }
    for (int i = 0; i < this.objetos.length; i++) {
      if (this.objetos[i] == null) { // procura a primeira posição vazia
        this.objetos[i] = o;
        return;
      }
    }
  }

  public boolean has(T o) {
    for (T e : this.objetos) {
      if (o.equals(e)) {
        return true;
      }
    }
    return false;
  }

  public void remove(T o) {
    for (int i = 0; i < objetos.length; i++) {
      if (this.objetos[i].equals(o)) {
        this.objetos[i] = null;
      }
    }
  }

  public Object[] toArray() { // Este método não é para ser generalizado
    Object[] array = new Object[this.count()];
    for (int i = 0, c = 0; i < this.objetos.length; i++) {
      if (this.objetos[i] != null) {
        array[c++] = this.objetos[i];
      }
    }
    return array;
  }

  @Override
  public String toString() {
    String s = "Bag content:\n";
    for (Object o : this.toArray()) {
      s += o.toString() + "\n";
    }
    return s;
  }
}
