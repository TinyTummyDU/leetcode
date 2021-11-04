package DoublePointer;

public class HasCycle_142 {
  // 环形列表2

  public ListNode detectCycle(ListNode head) {

    boolean hasCycle = false;
    if (head != null && head.next == null) {
      return null;
    }
    // first meet
    ListNode s = head;
    ListNode f = head;
    while (f != null) {
      f = f.next;
      if (f != null) {
        f = f.next;
      }
      s = s.next;
      if (f == s) {
        hasCycle = true;
        break;
      }
    }
    if (hasCycle) {
      // set f = head  velocity = 1
      f = head;
      while (f != s) {
        f = f.next;
        s = s.next;
      }
      return f;
    } else {
      return null;
    }
  }

  // f = 2s   f = s + nb
  // s = nb, f = 2nb   meet
  // a+nb = 入口

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
