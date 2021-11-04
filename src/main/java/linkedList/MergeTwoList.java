package linkedList;

public class MergeTwoList {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode dum = new ListNode(-1);
    ListNode cur = dum;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        cur = cur.next;
        l1 = l1.next;
      } else {
        cur.next = l2;
        cur = cur.next;
        l2 = l2.next;
      }
    }

    //        cur.next = l1 != null ? l1 : l2;

    if (l1 == null) {
      cur.next = l2;
    } else {
      cur.next = l1;
    }
    return dum.next;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
