package linkedList;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePrint_jianzhi_06 {

  //    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
  // 剑指 Offer 06. 从尾到头打印链表

  ArrayList<Integer> tmp = new ArrayList<Integer>();
  // 递归2 补充一个递归代码，不需要重新遍历ArrayList，时间100%。
  int[] res;
  int i = 0;
  int j = 0;

  // 栈
  public int[] reversePrint(ListNode head) {
    //        if(head==null) return new int[];
    Stack<Integer> stack = new Stack<>();
    int len = 0;
    while (head != null) {
      stack.push(head.val);
      head = head.next;
      len++;
    }
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      res[i] = stack.pop();
    }
    return res;
  }

  // 递归1
  public int[] reversePrint1(ListNode head) {
    recur(head);
    int[] res = new int[tmp.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = tmp.get(i);
    }
    return res;
  }

  public void recur(ListNode head) {
    if (head == null) return;
    recur(head.next);
    tmp.add(head.val);
  }

  public int[] reversePrint2(ListNode head) {
    solve(head);
    return res;
  }

  public void solve(ListNode head) {
    if (head == null) {
      res = new int[i];
      return;
    }
    i++;
    solve(head.next);
    res[j] = head.val;
    j++;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
