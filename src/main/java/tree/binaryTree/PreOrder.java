package tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

  // 递归版
  public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    iteratePreorder(root, res);
    return res;
  }

  public void iteratePreorder(TreeNode root, ArrayList<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val);
    iteratePreorder(root.left, res);
    iteratePreorder(root.right, res);
  }

  // 非递归，迭代版，其实就是显式的栈
  public List<Integer> preorderTraversal1(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();

    Stack<TreeNode> stk = new Stack<>();

    while (!stk.isEmpty() || root != null) {
      while (root != null) {
        stk.push(root);
        res.add(root.val);
        root = root.left;
      }
      root = stk.pop().right;
    }
    return res;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
