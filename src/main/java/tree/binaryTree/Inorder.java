package tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {

  // 递归版
  public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    iterateInorder(root, res);
    return res;
  }

  public void iterateInorder(TreeNode root, ArrayList<Integer> res) {
    if (root == null) {
      return;
    }
    iterateInorder(root.left, res);
    res.add(root.val);
    iterateInorder(root.right, res);
  }

  public List<Integer> inorderTraversal1(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    Stack<TreeNode> stk = new Stack();

    while (!stk.isEmpty() || root != null) {
      while (root != null) {
        stk.push(root);
        root = root.left;
      }
      root = stk.pop();
      res.add(root.val);
      root = root.right;
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
