package DoublePointer;

public class HasCycle_141 {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null) { // 链表出不出现异常，其实就是a.next的时候 a不为null就行
      fast = fast.next;
      if (fast != null) { // 快指针有可能这次只动了一下，但是没关系，因为是先比较fast和原slow，才再更新slow
        fast = fast.next; // 所以其实在这个判断环的问题里，快指针就一次动3下也行，无所谓，关键是追击问题
      }
      if (fast == slow) { // 11
        return true;
      }
      slow = slow.next; // 22  22必须在11后面， 防止 [1] -1 ，这种情况的话，就会判断为有环
    }
    return false;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
