package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSimulatingOneStack1 {

  //    方法：只使用1个队列
  //    思路：和使用两个队列一样，新来的必须在队列的下面
  //
  //    时间复杂度：入栈操作 O(n)，其余操作都是 O(1)。
  //    入栈操作需要将队列中的n 个元素出队，并入队 n+1 个元素到队列，共有2n+1 次操作，
  //    每次出队和入队操作的时间复杂度都是 O(1)，因此入栈操作的时间复杂度是
  //    O(n)。
  //
  //    空间复杂度：O(n)

  Queue<Integer> A;
  int num = 0; // 记录目前有多少个元素
  // C 用作 swap

  /** Initialize your data structure here. */
  public QueueSimulatingOneStack1() {

    A = new LinkedList<>();
  }

  // 从一开始开始想，栈的话就要每次新来的元素放在队列的最下方，才可以后进先出
  /** Push element x onto stack. */
  public void push(int x) {
    A.offer(x); // 先放到队列末尾，然后把前面的先出队，再进队
    // 这样最先进去的就可以最后出去，实现栈
    for (int i = 0; i < num; i++) {
      A.offer(A.poll());
    }
    num++;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    // 空 不需要管，因为题目说了
    return A.poll();
  }

  /** Get the top element. */
  public int top() {
    return A.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return A.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
 */
