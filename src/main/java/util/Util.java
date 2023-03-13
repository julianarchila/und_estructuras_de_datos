package util;

public class Util {
  private Util() {}

  public static void checkIndexOpen(int index, int size) {
    if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index not valid");
  }

  public static void checkIndexClose(int index, int size) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index not valid");
  }
}
