package util;

public interface IBag<T> {

  public static class FullBagException extends RuntimeException {
    public FullBagException(int cap) {
      super("A bolsa está na capacidade máxima de " + cap + " objetos");
    }
  }

  /**
   * Verifica se a bolsa está vazia.
   * @return true se a bolsa estiver vazia ou false caso contrário.
   */
  public boolean isEmpty();

  /**
   * Conta quantos objetos estão na bolsa.
   * @return a quantidade de objetos na bolsa.
   */
  public int count();

  /**
   * Adiciona um objeto à bolsa.
   * @param o O objeto.
   * @throws FullBagException se a bolsa estiver cheia.
   */
  public void add(T o) throws FullBagException;

  /**
   * Verifica se um dado objeto está na bolsa.
   * @param o objeto a ser verificado.
   * @return true se o objeto estiver na bolsa e false caso contrário.
   */
  public boolean has(T o);

  /**
   * Remove um objeto da bolsa.
   * @param o O objeto a ser removido.
   */
  public void remove(T o);

  /**
   * Converte a bolsa em um array de objetos.
   * @return um array com apenas os objetos da bolsa.
   */
  public Object[] toArray(); // Este método não é para ser generalizado

}
