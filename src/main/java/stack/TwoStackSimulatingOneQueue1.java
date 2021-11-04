package stack;

import java.util.Stack;

public class TwoStackSimulatingOneQueue1 {

  Stack<Integer> A, B;
  /** Initialize your data structure here. */
  public TwoStackSimulatingOneQueue1() {
    A = new Stack<>();
    B = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    A.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (!B.isEmpty()) {
      return B.pop();
    }
    if (A.isEmpty()) {
      return -1;
    }
    while (!A.isEmpty()) {
      B.push(A.pop());
    }
    return B.pop();
  }

  /** Get the front element. */
  public int peek() {
    if (!B.isEmpty()) {
      return B.peek();
    }
    if (A.isEmpty()) {
      return -1;
    }
    while (!A.isEmpty()) {
      B.push(A.pop());
    }
    return B.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return A.isEmpty() && B.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
