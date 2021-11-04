package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSimulatingOneStack {

  //    你只能使用队列的基本操作-- 也就是push to back, peek/pop from front, size, 和is empty 这些操作是合法的。
  //    你所使用的语言也许不支持队列。你可以使用 list 或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
  //    你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

  Queue<Integer> A, B, C;
  // C 用作 swap

  /** Initialize your data structure here. */
  public QueueSimulatingOneStack() {

    A = new LinkedList<>();
    B = new LinkedList<>();
  }

  // 从一开始开始想，栈的话就要每次新来的元素放在队列的最下方，才可以后进先出
  /** Push element x onto stack. */
  public void push(int x) {
    // 不对。这样的话，一开始A为空，会造成A，B都有x
    //        if(A.isEmpty()){
    //            A.offer(x);
    //        }
    //        B.offer(x);

    B.offer(x);
    while (!A.isEmpty()) {
      B.offer(A.poll());
    }
    C = B;
    B = A; // 清空B
    A = C;

    //        时间复杂度：入栈操作 O(n)，其余操作都是 O(1)。
    //        入栈操作需要将queue1中n个元素出队，入队到queue2，
    //        出队入队O(1)，所以一共2n+1此操作，所以时间复杂度O(n)
    //
    //        空间复杂度：O(n)

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
