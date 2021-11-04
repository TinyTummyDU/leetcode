package stack;

import java.util.LinkedList;

public class TwoStackSimulatingOneQueue {

  //    用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
  //    分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )

  LinkedList<Integer> A, B;

  public TwoStackSimulatingOneQueue() {
    A = new LinkedList<>();
    B = new LinkedList<>();
  }

  public void appendTail(int value) {
    A.add(value);
  }

  public int deleteHead() {

    // 思考的时候就走一遍： 一开始A有B没有，如何删除头部，全部倒过去，变成了A没有B有，B.removeLast
    // A有B也有，加直接在A上加，删除头部还是删B
    // A没有B没有 : -1

    //        删除的时候有三种情况：
    //        1 B非空，那就直接删除B的尾，其实就是A的头
    if (!B.isEmpty()) {
      return B.removeLast();
    }
    //        2 B空，A也空，那就返回-1
    if (A.isEmpty()) {
      return -1;
    }
    //        3 B空，A不空，那就把A的转到B（逆序），再删除B的尾
    while (!A.isEmpty()) {
      B.addLast(A.removeLast());
    }
    return B.removeLast();
  }
}

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new CQueue();
 * obj.appendTail(value); int param_2 = obj.deleteHead();
 */
