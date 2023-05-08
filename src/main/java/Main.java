import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    f(4, 4);
  }

  public static void f(int n, int m) {
    Stack<Integer> s = new Stack<>();
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        if (i + j % 2 == 0) {
          s.add(i + j);
          q.add(s.peek());
          // System.out.println(s);
          // System.out.println(q);
        }
        if (i * 2 + j % 3 == 0) {
          int t = q.peek();
          q.add(s.pop());
          s.add(t);
          q.poll();
          // System.out.println(s);
          // System.out.println(q);
        }
      }
    }

    // // print size of s and q
    System.out.println(s.size() + " " + q.size());
    System.out.println(s);
    System.out.println(q);
  }
}
