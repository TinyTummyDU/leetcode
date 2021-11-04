package linkedList;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseLinkedList {
  // 反转链表

  public static void main(String[] args) {

    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;

    ListNode res = reverseList(n1);
    System.out.println(res.val);
    System.out.println(res.next.val);
    System.out.println(res.next.next.val);
  }

  public static ListNode reverseListDoublePointerByMyself(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = head;
    ListNode cur = null;
    ListNode swap = null;
    while (pre.next != null) {
      swap = pre.next;
      pre.next = cur;
      cur = pre;
      pre = swap;
    }
    pre.next = cur;
    return pre;
  }

  public static ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ArrayList<ListNode> lists = new ArrayList<>();
    lists.add(head);
    ListNode cur = head;
    while (cur.next != null) {
      lists.add(cur.next);
      cur = cur.next;
    }
    int length = lists.size();
    ListNode tail = lists.get(length - 1);
    cur = tail;
    ListNode swap = null;
    for (int i = length - 2; i >= 0; i--) {
      swap = lists.get(i);
      cur.next = swap;
      cur = swap;
      if (i == 0) {
        cur.next = null;
      }
    }
    return tail;
  }

  // 使用栈
  public ListNode reverseListStack(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    // 把链表节点全部摘掉放到栈中
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    if (stack.isEmpty()) return null;
    ListNode node = stack.pop();
    ListNode dummy = node;
    // 栈中的结点全部出栈，然后重新连成一个新的链表
    while (!stack.isEmpty()) {
      ListNode tempNode = stack.pop();
      node.next = tempNode;
      node = node.next;
    }
    // 最后一个结点就是反转前的头结点，一定要让他的next
    // 等于空，否则会构成环
    node.next = null;
    return dummy;
  }

  // 双指针同时向后走，
  public ListNode reverseListDoublePointer(ListNode head) {
    // 新链表
    ListNode newHead = null;
    while (head != null) {
      // 先保存访问的节点的下一个节点，保存起来
      // 留着下一步访问的
      ListNode temp = head.next;
      // 每次访问的原链表节点都会成为新链表的头结点，
      // 其实就是把新链表挂到访问的原链表节点的
      // 后面就行了
      head.next = newHead;
      // 更新新链表
      newHead = head;
      // 重新赋值，继续访问
      head = temp;
    }
    // 返回新链表
    return newHead;
  }

  public ListNode reverseList_iterate_from_head(ListNode head) {
    // 终止条件  终止条件就是链表为空，或者是链表没有尾结点的时候，直接返回
    if (head == null || head.next == null) return head;
    // 保存当前节点的下一个结点
    ListNode next = head.next;
    // 从当前节点的下一个结点开始递归调用
    ListNode reverse = reverseList(next);
    // reverse是反转之后的链表，因为函数reverseList
    // 表示的是对链表的反转，所以反转完之后next肯定
    // 是链表reverse的尾结点，然后我们再把当前节点
    // head挂到next节点的后面就完成了链表的反转。
    next.next = head;
    // 这里head相当于变成了尾结点，尾结点都是为空的，
    // 否则会构成环
    head.next = null;
    return reverse;
  }

  // 递归解决
  // 我们再来回顾一下递归的模板，终止条件，递归调用，逻辑处理。
  //    public ListNode reverseList(参数0) {
  //        if (终止条件)
  //            return;
  //
  //        逻辑处理（可能有，也可能没有，具体问题具体分析）
  //
  //        //递归调用
  //        ListNode reverse = reverseList(参数1);
  //
  //        逻辑处理（可能有，也可能没有，具体问题具体分析）
  //    }

  //    这种递归往下传递的时候基本上没有逻辑处理，当往回反弹的时候才开始处理，
  //    也就是从链表的尾端往前开始处理的。
  //
  //
  //    我们还可以再来改一下，在链表递归的时候从前往后处理，
  //    处理完之后直接返回递归的结果，这就是所谓的尾递归，这种运行效率要比上一种好很多
  public ListNode reverseList_iterate_from_tail(ListNode head) {
    return reverseListInt(head, null);
  }

  private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null) return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
  }

  //      Definition for singly-linked list.
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
