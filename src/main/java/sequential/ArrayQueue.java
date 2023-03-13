package sequential;

import java.util.Iterator;

/** ArrayQueue */
public class ArrayQueue<T> extends Queue<T> {
  private T[] list;
  private int read;
  private int write;

  public ArrayQueue(int capacity) {
    this.list = (T[]) new Object[capacity];
    this.read = 0;
    this.write = 0;
  }

  public ArrayQueue() {
    this(10);
  }

  @Override
  public void add(T e) {
    // Check if the queue is full
    if (next(write) == read) {
      throw new Error("Queue is full");
    }

    this.list[write] = e;
    this.write = next(write);
  }

  @Override
  public T peek() {
    if (empty()) {
      throw new Error("Queue is empty");
    }
    return this.list[read];
  }

  @Override
  public T poll() {
    T e = peek();
    read = next(read);
    return e;
  }

  @Override
  public boolean empty() {
    return read == write;
  }

  @Override
  public int search(T e) {
    throw new UnsupportedOperationException("Unimplemented method 'search'");
  }

  private int next(int i) {
    return (i + 1) % list.length;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      int i = read;

      @Override
      public boolean hasNext() {
        return i != write;
      }

      @Override
      public T next() {
        T e = list[i];
        i = ArrayQueue.this.next(i);
        return e;
      }
    };
  }
}
