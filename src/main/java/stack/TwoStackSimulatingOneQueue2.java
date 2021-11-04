package stack;

import java.util.Stack;

public class TwoStackSimulatingOneQueue2 {
  // 剑指offer 09
  private Stack<Integer> s1;
  private Stack<Integer> s2;

  public TwoStackSimulatingOneQueue2() {
    s1 = new Stack();
    s2 = new Stack();
  }

  public void appendTail(int value) {
    s1.push(value);
  }

  public int deleteHead() {
    if (!s2.isEmpty()) {
      return s2.pop();
    }
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    return s2.isEmpty() ? -1 : s2.pop();
  }
}
