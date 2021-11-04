package DoublePointer;

public class RotatingLinkedList_61 {

  public static ListNode rotateRight(ListNode head, int k) {
    ListNode temp = head;
    int count = 0;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    System.out.println("count: " + count);
    // count=0
    if (count == 0) return null;
    // count>0
    int step = k % count;
    System.out.println("step: " + step);
    // step = 0
    if (step == 0) return head; // 这种可以是 k=0 或者 k是count的整数倍
    // step > 0;
    ListNode former = head;
    ListNode latter = head;
    for (int i = 0; i < step - 1; i++) {
      latter = latter.next;
    }
    System.out.println("latter: " + latter.val);

    // two pointers move together
    while (latter.next.next != null) {
      former = former.next;
      latter = latter.next;
    }
    System.out.println("former: " + former.val + " latter: " + latter.val);
    ListNode newHead = former.next;
    latter.next.next = head; // 先连接前后
    former.next = null; // 再断开中间链接
    return newHead;
  }

  public static void main(String[] args) {
    ListNode a1 = new ListNode(0);
    ListNode a2 = new ListNode(1);
    ListNode a3 = new ListNode(2);
    a1.next = a2;
    a2.next = a3;
    rotateRight(a1, 4);
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
