package sequential;

public interface List<T> extends Iterable<T> {
  void add(T e);

  void add(int index, T e);

  void clear();

  boolean contains(T e);

  T get(int index);

  int indexOf(T e);

  boolean isEmpty();

  T remove(int index);

  boolean remove(T e);

  int size();
}
;
