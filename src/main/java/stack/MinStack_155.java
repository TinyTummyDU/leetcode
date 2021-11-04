package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_155 {

  Deque<Integer> xStack;
  Deque<Integer> minStack;

  public MinStack_155() {
    xStack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
    minStack.push(Integer.MAX_VALUE);
  }

  public static void main(String[] args) {
    Integer a1 = new Integer(1);
    Integer a2 = new Integer(1);
    System.out.println(a1.equals(a2));
  }

  public void push(int x) {
    xStack.push(x);
    minStack.push(Math.min(minStack.peek(), x));
  }

  public void pop() {
    xStack.pop();
    minStack.pop();
  }

  public int top() {
    return xStack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
