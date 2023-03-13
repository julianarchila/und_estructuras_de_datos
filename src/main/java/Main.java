import sequential.*;

public class Main {
  public static void main(String[] args) {
    Queue<Integer> q = new ArrayQueue<>();

    for (int i = 0; i < 9; i++) {
      q.add(i);
      System.out.println(q);
      q.peek();
    }
    // iterate over elements and logo

    try {
      q.add(9);
    } catch (Error e) {
      System.out.println("Queue is full");
    }

    for (int i = 0; i < 9; i++) {
      q.poll();
      if (i != 8) {
        q.peek();
      }
      System.out.println(q);
    }

    System.out.println("Queue is empty: " + q.empty());
    q.add(0);
    System.out.println(q.peek());
    System.out.println("Queue is empty: " + q.empty());

    // System.out.println(q);
  }
}
