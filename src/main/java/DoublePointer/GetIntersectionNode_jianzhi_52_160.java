package DoublePointer;

public class GetIntersectionNode_jianzhi_52_160 {

  //    剑指 Offer 52. 两个链表的第一个公共节点
  //    输入两个链表，找出它们的第一个公共节点。

  //    如果两个链表没有交点，返回 null.
  //    在返回结果后，两个链表仍须保持原有的结构。
  //    可假定整个链表结构中没有循环。
  //    程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

  // 双指针，浪漫相遇 时间o(M+N) 空间o(1)
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode l1 = headA;
    ListNode l2 = headB;
    while (l1 != l2) {
      l1 = l1 == null ? headB : l1.next;
      l2 = l2 == null ? headA : l2.next;
    }

    // 如果没有相交的话，两个指针都会走M+N然后都是null，跳出循环
    return l1;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // 可以用哈希集合
  //    思路和算法
  //
  //    判断两个链表是否相交，可以使用哈希集合存储链表节点。
  //
  //    首先遍历链表
  //            headA
  //    headA，并将链表
  //            headA
  //    headA 中的每个节点加入哈希集合中。然后遍历链表
  //            headB
  //    headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
  //
  //    如果当前节点不在哈希集合中，则继续遍历下一个节点；
  //    如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都是两个链表的公共节点，因此在链表
  //            headB
  //    headB 中遍历到的第一个在哈希集合中的节点就是两个链表的第一个公共节点，返回该节点。
  //    如果链表
  //            headB
  //    headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回
  // null
  //        null

}
