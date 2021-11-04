package linkedList;

public class DeleteOneNode {

  public ListNode deleteNode(ListNode head, int val) {
    ListNode header = new ListNode(-1);
    header.next = head;
    ListNode curHeader = header;
    while (curHeader.next != null) {
      if (curHeader.next.val == val) {
        //                ListNode cur = curHeader.next.next;
        //                curHeader.next = cur;
        curHeader.next = curHeader.next.next;
        break;
      }
      curHeader = curHeader.next; // 必须break，不然如果删除最后一个节点的情况下，会出现空指针
    }
    return header.next;
  }

  // 递归
  public ListNode deleteNode1(ListNode head, int val) {
    if (head == null) return null;
    if (head.val == val) return head.next;
    head.next = deleteNode1(head.next, val);
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
