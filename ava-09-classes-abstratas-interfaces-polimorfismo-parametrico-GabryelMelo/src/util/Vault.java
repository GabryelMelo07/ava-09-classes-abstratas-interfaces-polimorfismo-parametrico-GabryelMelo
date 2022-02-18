package util;

public class Vault<T, K> implements IVault<T, K> {

  private T objeto;
  private K password;

  @Override
  public void store(T object, K password, IPasswordConstraints<K> constraints) {
    if (constraints.isStrong(password)) {
      this.objeto = object;
      this.password = password;
    } else {
      throw new WeakPasswordException();
    }
  }

  @Override
  public T retrieve(K password) {
    if (!password.equals(this.password)) {
      throw new WrongPasswordException();
    }
    return this.objeto;
  }

}
