package DoublePointer;

public class KthToLast_02_02 {

  public int kthToLast(ListNode head, int k) {

    ListNode former = head;
    ListNode latter = head;

    for (int i = 0; i < k - 1; i++) {
      latter = latter.next;
    }
    while (latter.next != null) {
      former = former.next;
      latter = latter.next;
    }
    return former.val;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
