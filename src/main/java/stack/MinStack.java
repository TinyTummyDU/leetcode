package stack;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

  // 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

  // 辅助栈的使用

  Stack<Integer> A, B;

  /** initialize your data structure here. */
  public MinStack() {
    A = new Stack<>();
    B = new Stack<>();
  }

  public static void main(String[] args) {
    ArrayList<Integer> test = new ArrayList<>();
    test.add(1);
    test.add(2);
    test.add(3);
    //        System.out.println(test.get(-1));
    // 没有-1索引

    Stack<Integer> test1 = new Stack<>();
    //        System.out.println(test1.peek()); //EmptyStackException
    //        test1.pop(); //EmptyStackException

  }

  public void push(int x) {
    A.push(x);
    if (B.empty() || B.peek() >= x) {
      // 短路效应
      //           这里的等号用的好：B.peek() >= x 避免了重复最小值被弹出
      B.add(x);
    }
  }

  public void pop() {
    if (A.pop().equals(B.peek())) {
      B.pop();
    }
  }

  public int top() {
    return A.peek();
  }

  public int min() {
    return B.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.min();
 */
