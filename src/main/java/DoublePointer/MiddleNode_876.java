package DoublePointer;

public class MiddleNode_876 {

  public static ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) { // 后面这个条件很重要 123 应该返回2 而不是3
      System.out.println("qq");
      fast = fast.next;
      if (fast != null) fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode a1 = new ListNode(1);
    ListNode a2 = new ListNode(2);
    ListNode a3 = new ListNode(3);
    a1.next = a2;
    a2.next = a3;
    System.out.println(middleNode(a1).val);
  }

  public static class ListNode {
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
