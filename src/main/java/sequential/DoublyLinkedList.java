package sequential;

import java.util.Iterator;
import util.Node;
import util.Util;

public class DoublyLinkedList<T> implements List<T> {

  private Node<T> head;
  private Node<T> tail;

  private int size;

  public DoublyLinkedList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  @Override
  public void add(T e) {
    this.add(this.size, e);
  }

  @Override
  public void add(int index, T e) {
    Util.checkIndexOpen(index, this.size);

    Node<T> newNode = new Node<>(e);

    if (index == 0) {
      newNode.setNext(this.head);
      this.head = newNode;

      if (this.head.getNext() != null) {
        this.head.getNext().setPrev(this.head);
      }

      if (this.tail == null) {
        this.tail = this.head;
      }
    } else if (index == this.size) {
      this.tail.setNext(newNode);
      newNode.setPrev(this.tail);
      this.tail = newNode;
    } else {
      Node<T> prev = this.head;
      for (int i = 0; i < index - 1; i++) {
        prev = prev.getNext();
      }
      newNode.setNext(prev.getNext());
      prev.getNext().setPrev(newNode);

      newNode.setPrev(prev);
      prev.setNext(newNode);
    }
    this.size++;
  }

  @Override
  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public boolean contains(T e) {
    return this.indexOf(e) != -1;
  }

  @Override
  public T get(int index) {
    Util.checkIndexClose(index, this.size);
    if (index == 0) return this.head.getKey();

    if (index == this.size - 1) return this.tail.getKey();

    Node<T> current = this.head;

    // if index is closer to the head than to the tail we start from the head otherwise we start
    // from the tail
    if (index < this.size / 2) {
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
    } else {
      current = this.tail;
      for (int i = this.size - 1; i > index; i--) {
        current = current.getPrev();
      }
    }
    return current.getKey();
  }

  @Override
  public int indexOf(T e) {
    int index = 0;
    Node<T> current = this.head;

    while (current != null) {
      if (current.getKey().equals(e)) {
        return index;
      }
      current = current.getNext();
      index++;
    }

    return -1;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public T remove(int index) {
    Util.checkIndexClose(index, this.size);

    T result;

    if (index == 0) {
      result = this.head.getKey();
      this.head = this.head.getNext();
      this.head.setPrev(null);
    } else if (index == this.size - 1) {
      result = this.tail.getKey();
      this.tail = this.tail.getPrev();
      this.tail.setNext(null);
    } else {
      Node<T> prev = this.head;
      for (int i = 0; i < index - 1; i++) {
        prev = prev.getNext();
      }
      result = prev.getNext().getKey();
      prev.setNext(prev.getNext().getNext());
      prev.getNext().setPrev(prev);
    }

    this.size--;
    return result;
  }

  @Override
  public boolean remove(T e) {
    int index = this.indexOf(e);
    if (index == -1) return false;

    this.remove(index);
    return true;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T result = current.getKey();
        current = current.getNext();
        return result;
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    this.forEach(e -> sb.append(e).append(","));
    if (sb.length() > 1) sb.replace(sb.length() - 1, sb.length(), "");
    sb.append("]");
    return sb.toString();
  }
}
