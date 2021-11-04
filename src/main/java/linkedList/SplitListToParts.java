package linkedList;

public class SplitListToParts {

  public static ListNode[] splitListToParts(ListNode root, int k) {

    if (root == null) {
      return new ListNode[k];
    }

    ListNode temp = root;
    int length = 1;
    while (temp.next != null) {
      length++;
      temp = temp.next;
    }
    System.out.println(length);

    int commonNum = length / k; // 每个分割部分应该几个 // 3  0
    //        System.out.println(commonNum);
    int differentNum = commonNum + 1; // 每个分割部分+1  // 4  1
    //        System.out.println(differentNum);
    int plusOneNum = length % k; // 前面 plusOneNum个应该在commonNum基础上+1 //1  3
    //        System.out.println(plusOneNum);
    int differentNodesNum = plusOneNum * differentNum; // 4 3
    //        System.out.println(differentNodesNum);

    int commonNodesNum = length - differentNodesNum; // 6 2

    ListNode[] res = new ListNode[k];
    int index = 1; // 第一个节点
    int resIndex = 0;
    while (root != null) {
      res[resIndex] = root;
      if (index <= differentNodesNum) {
        for (int i = 0; i < differentNum - 1; i++) {
          root = root.next;
        }
        temp = root.next; // 5 ， 在分割前先保存5
        root.next = null; // 分割 4.next = null;
        root = temp;
        index = index + differentNum; // 5
      } else {
        for (int i = 0; i < commonNum - 1; i++) {
          root = root.next;
        }
        temp = root.next;
        root.next = null;
        root = temp;
        index = index + commonNum; // 8
      }
      resIndex = resIndex + 1;
    }

    return res;
  }

  public static void main(String[] args) {
    ListNode a1 = new ListNode(1);
    ListNode a2 = new ListNode(2);
    ListNode a3 = new ListNode(3);
    //        ListNode a4 = new ListNode(4);
    //        ListNode a5 = new ListNode(5);
    //        ListNode a6 = new ListNode(6);
    //        ListNode a7 = new ListNode(7);
    //        ListNode a8 = new ListNode(8);
    //        ListNode a9 = new ListNode(9);
    //        ListNode a10 = new ListNode(10);
    a1.next = a2;
    a2.next = a3;
    //        a3.next = a4;
    //        a4.next = a5;
    //        a5.next = a6;
    //        a6.next = a7;
    //        a7.next = a8;
    //        a8.next = a9;
    //        a9.next = a10;
    ListNode[] res = splitListToParts(a1, 5);
    //        System.out.println(res.length);
    //        System.out.println(res[0].val);
    //        System.out.println(res[0].next.val);
    //        System.out.println(res[0].next.next.val);
    //        System.out.println(res[0].next.next.next.val);
    //        System.out.println(res[1].val);
    //        System.out.println(res[1].next.val);
    //        System.out.println(res[1].next.next.val);
    ////        System.out.println(res[1].next.next.next.val);

  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
