package sequential;

import java.util.Iterator;

public class ArrayStack<T> extends Stack<T> {
  private T[] list;

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public T next() {
        return null;
      }
    };
  }
}
