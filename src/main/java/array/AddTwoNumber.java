package array;

public class AddTwoNumber {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    l1.next = l2;
    l2.next = l3;

    ListNode n1 = new ListNode(5);
    ListNode n2 = new ListNode(6);
    ListNode n3 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;

    ListNode o = addTwoNumbers(l1, n1);
    System.out.println(o.val);
    System.out.println(o.next.val);
    System.out.println(o.next.next.val);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    StringBuffer stringBuffer1 = new StringBuffer();
    stringBuffer1.append(l1.val);
    while (l1.next != null) {
      stringBuffer1.append(l1.next.val);
      l1 = l1.next;
    }
    stringBuffer1.reverse();

    StringBuffer stringBuffer2 = new StringBuffer();
    stringBuffer2.append(l2.val);
    while (l2.next != null) {
      stringBuffer2.append(l2.next.val);
      l2 = l2.next;
    }
    stringBuffer2.reverse();

    String str1 = stringBuffer1.toString();
    String str2 = stringBuffer2.toString();

    int num1 = Integer.valueOf(str1);
    int num2 = Integer.valueOf(str2);
    int sum = num1 + num2;
    System.out.println(sum);

    String str_sum = String.valueOf(sum);
    StringBuffer stringBuffer_sum = new StringBuffer(str_sum);
    stringBuffer_sum.reverse();
    char[] ch = new char[stringBuffer_sum.length()];
    stringBuffer_sum.getChars(0, stringBuffer_sum.length(), ch, 0);

    ListNode newL = new ListNode(ch[0] - 48);
    ListNode swap = newL;
    for (int i = 1; i < ch.length; i++) {
      swap.next = new ListNode(ch[i] - '0');
      swap = swap.next;
    }

    return newL;
  }

  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
