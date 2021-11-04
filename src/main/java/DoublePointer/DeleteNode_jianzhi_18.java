package DoublePointer;

public class DeleteNode_jianzhi_18 {

  //    剑指 Offer 18. 删除链表的节点
  //    给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
  //
  //    返回删除后的链表的头节点。
  //
  //    注意：此题对比原题有改动
  //            题目保证链表中节点的值互不相同
  //    若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点

  public ListNode deleteNode(ListNode head, int val) {
    if (head == null) return null;
    if (head.val == val) return head.next;
    ListNode left = head;
    ListNode right = head.next;
    while (right.val != val) {
      left = left.next;
      right = right.next;
    }
    left.next = right.next;
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
