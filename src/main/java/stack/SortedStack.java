package stack;

import java.util.Stack;

public class SortedStack {
  // 面试题 03.05. 栈排序

  private Stack<Integer> stk, help;

  public SortedStack() {
    this.stk = new Stack<>();
    this.help = new Stack<>();
  }

  public static void main(String[] args) {
    SortedStack s = new SortedStack();
    s.push(1);
    s.push(2);
    s.push(0);
    System.out.println(s.peek());
  }

  public void push(int val) {
    while (!stk.isEmpty() && stk.peek() < val) {
      help.push(stk.peek());
      stk.pop();
    }
    stk.push(val);
    while (!help.isEmpty()) {
      stk.push(help.peek());
      help.pop();
    }
  }

  public void pop() {
    if (!stk.isEmpty()) stk.pop();
  }

  public int peek() {
    return stk.isEmpty() ? -1 : stk.peek();
  }

  public boolean isEmpty() {
    return stk.isEmpty();
  }
}
