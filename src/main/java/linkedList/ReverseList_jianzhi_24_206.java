package linkedList;

import java.util.Stack;

public class ReverseList_jianzhi_24_206 {

  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    Stack<ListNode> stack = new Stack();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }

    head = stack.pop();
    ListNode cur = head;
    while (!stack.isEmpty()) {
      cur.next = stack.pop();
      cur = cur.next;
    }
    cur.next = null;
    return head;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
