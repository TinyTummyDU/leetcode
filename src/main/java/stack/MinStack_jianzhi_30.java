package stack;

import java.util.Stack;

public class MinStack_jianzhi_30 {

  // 剑指 Offer 30. 包含min函数的栈

  // 使用辅助栈

  private Stack<Integer> s1;
  private Stack<Integer> s2;

  public MinStack_jianzhi_30() {
    s1 = new Stack();
    s2 = new Stack();
  }

  public void push(int x) {
    if (s2.isEmpty() || s2.peek() >= x) { // 短路 妙啊
      s2.push(x);
    }
    s1.push(x);
  }

  public void pop() {
    if (s2.peek().equals(s1.pop())) { // 注意 是equals
      s2.pop();
    }
  }

  public int top() {
    return s1.peek();
  }

  public int min() {
    return s2.peek();
  }
}
