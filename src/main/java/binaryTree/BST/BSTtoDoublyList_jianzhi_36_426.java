package binaryTree.BST;

public class BSTtoDoublyList_jianzhi_36_426 {

  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  Node pre, head;

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    dfs(root);
    head.left = pre;
    pre.right = head;
    return head;
  }

  public void dfs(Node root) {
    if (root == null) return;
    dfs(root.left);
    if (pre != null) {
      pre.right = root;
    } else {
      head = root; // pre==null 说明到了左边的底 那么就设置head
    }
    root.left = pre;
    pre = root;
    dfs(root.right);
  }
}
