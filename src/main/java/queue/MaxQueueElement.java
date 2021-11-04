package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueueElement {

  //    请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
  //    若队列为空，pop_front 和 max_value需要返回 -1

  // 方法 辅助队列：单调队列：本质还是队列 尾进 头出， 但维护一个重要的特性：单调性

  Queue<Integer> A;
  Queue<Integer> B;

  public MaxQueueElement() {
    //        队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
    //        LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
    A = new LinkedList<>();
    B = new LinkedList<>();
  }

  public static void main(String[] args) {
    MaxQueueElement maxQueueElement = new MaxQueueElement();
    System.out.println(maxQueueElement.max_value());
    maxQueueElement.push_back(15);
    maxQueueElement.push_back(10);
    maxQueueElement.push_back(11);
    maxQueueElement.push_back(16);
    System.out.println(maxQueueElement.max_value());
    maxQueueElement.push_back(9);
    System.out.println(maxQueueElement.max_value());
  }

  public int max_value() {
    if (B.isEmpty()) {
      //        if(B.peek()==null){
      return -1;
    } else {
      return B.peek();
    }
  }

  public void push_back(int value) {
    A.offer(value);
    // 移除单调队列中比value小的元素，可以维护整个单调队列单调递减（可以相等）
    Iterator<Integer> iterator = B.iterator();
    while (iterator.hasNext()) {
      if (iterator.next() < value) {
        iterator.remove();
      }
    }
    B.offer(value);
  }

  //    offer，add 区别：
  //    一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
  //    这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
  //
  //    poll，remove 区别：
  //    remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll()
  // 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
  //
  //    peek，element区别：
  //    element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。

  // 为什么不能得到rear，当然了，因为linkedlist实现的是queue接口，先进先出，怎么会有get_rear的方法

  public int pop_front() {

    if (A.isEmpty()) {
      return -1;
    }

    //        int ans = A.poll();
    //        if (ans == B.peek()) {
    //            B.poll();
    //        }
    //        return ans;

    // int 可以直接和 Integer 比较
    // Integer和Integer 必须用 equals
    //        if(A.peek()==B.peek()){
    if (A.peek().equals(B.peek())) {
      B.poll();
    }

    return A.poll();
  }
}

/**
 * Your MaxQueue object will be instantiated and called as such: MaxQueue obj = new MaxQueue(); int
 * param_1 = obj.max_value(); obj.push_back(value); int param_3 = obj.pop_front();
 */

// 使用双端队列

// class MaxQueue {
//    Queue<Integer> q;
//    Deque<Integer> d;
// public MaxQueue() {
//    q = new LinkedList<Integer>();
//    d = new LinkedList<Integer>();
// }
//
//    public int max_value() {
//        if (d.isEmpty()) {
//            return -1;
//        }
//        return d.peekFirst();
//    }
//
//    public void push_back(int value) {
//        while (!d.isEmpty() && d.peekLast() < value) {
//            d.pollLast();
//        }
//        d.offerLast(value);
//        q.offer(value);
//    }
//
//    public int pop_front() {
//        if (q.isEmpty()) {
//            return -1;
//        }
//        int ans = q.poll();
//        if (ans == d.peekFirst()) {
//            d.pollFirst();
//        }
//        return ans;
//    }
// }

// 时间复杂度：
//
//        O(1)（插入，删除，求最大值）
//        删除操作于求最大值操作显然只需要 O(1) 的时间。
//        而插入操作虽然看起来有循环，做一个插入操作时最多可能会有
//        n 次出队操作。但要注意，由于每个数字只会出队一次，因此对于所有的 n 个数字的插入过程，对应的所有出队操作也不会大于
//        n 次。因此将出队的时间均摊到每个插入操作上，时间复杂度为
//        O(1)。
//        空间复杂度：
//        O(n)，需要用队列存储所有插入的元素。

// O(1)表示的是常数时间的操作，不管这个常数项有多大，只要和数据规模无关均可叫做O(1)
// 为什么这么多人吐槽均摊复杂度的，这个其实很好理解啊。 你可以理解成一个元素本来应该入队后立即就出队了（O（1）时间）。
// 但是他们并没有立即出队，把出队的时间花的时间省下来了，然后比它们大的元素来了之后一起出队了。等于把之前省下来的时间全花掉了
