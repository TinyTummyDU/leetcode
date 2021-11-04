package linkedList;

import java.util.ArrayList;

public class GetKthFromEnd {

  public ListNode getKthFromEnd(ListNode head, int k) {

    ArrayList<ListNode> list = new ArrayList<>();
    list.add(head);
    ListNode swap = head;
    while (swap.next != null) {
      list.add(swap.next);
      swap = swap.next;
    }
    return list.get(list.size() - k);
  }

  //    第一时间想到的解法：
  //    先遍历统计链表长度，记为n

  //      Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  //    双指针共同移动
  class Solution {
    public ListNode getKthFromEnd1(ListNode head, int k) {
      ListNode former = head, latter = head;
      for (int i = 0; i < k; i++) former = former.next;
      while (former != null) {
        former = former.next;
        latter = latter.next;
      }
      return latter;
    }
  }
}
