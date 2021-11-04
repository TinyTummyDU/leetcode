package linkedList;

public class IntersectionNode {

  //    输入两个链表，找出它们的第一个公共节点。

  // 双指针，浪漫相遇
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    ListNode p1, p2;
    p1 = headA;
    p2 = headB;

    while (p1 != p2) { // 如果没有相交，就会在最后走了两趟后都等于null，退出

      if (p1 == null) {
        p1 = headB;
      } else {
        p1 = p1.next;
      }
      //            p1 = p1 != null ? p1.next: headB;
      if (p2 == null) {
        p2 = headA;
      } else {
        p2 = p2.next;
      }
    }
    return p1;
  }

  // 先算长度，再走双指针
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

    // 统计链表A和链表B的长度
    int lenA = length(headA), lenB = length(headB);

    // 如果节点长度不一样，节点多的先走，直到他们的长度一样为止
    while (lenA != lenB) {
      if (lenA > lenB) {
        // 如果链表A长，那么链表A先走
        headA = headA.next;
        lenA--;
      } else {
        // 如果链表B长，那么链表B先走
        headB = headB.next;
        lenB--;
      }
    }

    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }

  public int length(ListNode headA) {
    int res = 0;
    while (headA != null) {
      res++;
      headA = headA.next;
    }
    return res;
  }

  //    Definition for singly-linked list
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
