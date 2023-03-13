package sequential;

import java.util.Iterator;
import util.Node;

public class LinkedListQueue<T> extends Queue<T> {

  private Node<T> head;
  private Node<T> tail;

  @Override
  public void add(T e) {
    Node<T> newNode = new Node<>(e);
    if (empty()) {
      head = tail = newNode;
      return;
    }
    tail.setNext(newNode);
    tail = newNode;
  }

  @Override
  public T peek() {
    return head.getKey();
  }

  @Override
  public T poll() {
    if (empty()) return null;
    T p = head.getKey();
    head = head.getNext();
    return p;
  }

  @Override
  public boolean empty() {
    return head == null;
  }

  @Override
  public int search(T e) {
    if (empty()) return -1;
    int index = 0;

    return -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<>() {
      Node<T> node = LinkedListQueue.this.tail;

      public boolean hasNext() {
        return node != null;
      }
      ;

      public T next() {
        return null;
      }
      ;
    };
  }
  ;
}
