package sequential;

public abstract class Queue<T> implements Iterable<T> {
  public abstract void add(T e);

  public abstract T peek();

  public abstract T poll();

  public abstract boolean empty();

  public abstract int search(T e);

  /**
   * @return String representation of the list
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (T e : this) {
      sb.append(e);
      sb.append("\u2190");
    }
    if (sb.length() > 0) sb.replace(sb.length() - 1, sb.length(), "");
    return sb.toString();
  }
}
