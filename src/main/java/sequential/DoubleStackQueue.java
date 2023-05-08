package sequential;

import java.util.Stack;

public class DoubleStackQueue<T> {

  private Stack<T> stack1 = new Stack<>();
  private Stack<T> stack2 = new Stack<>();

  public DoubleStackQueue() {
  }

  public void push(T x) {
    stack1.push(x);
  }

  public T pop() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  public T peek() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  public boolean empty() {
    return stack1.empty() && stack2.empty();
  }
}
