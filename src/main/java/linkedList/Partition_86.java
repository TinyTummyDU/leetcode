package linkedList;

public class Partition_86 {
  public ListNode partition(ListNode head, int x) {

    ListNode smallHead = new ListNode(); // 哑节点，用于处理头节点为空的边界条件
    ListNode bigHead = new ListNode();
    ListNode small = smallHead;
    ListNode big = bigHead;

    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        big.next = head;
        big = big.next;
      }
      head = head.next;
    }
    // 切断big辅助链表
    big.next = null;
    small.next = bigHead.next;
    return smallHead.next;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
