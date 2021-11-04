package DoublePointer;

public class MergeTwoLists_jianzhi_25 {

  //    剑指 Offer 25. 合并两个排序的链表
  //    输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(-1);
    ListNode cur = head;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }

    // cur.next = l1 != null ? l1 : l2;
    if (l1 == null) {
      cur.next = l2;
    } else {
      cur.next = l1;
    }
    return head.next;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
