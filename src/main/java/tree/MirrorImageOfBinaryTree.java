package tree;

import java.util.Stack;

public class MirrorImageOfBinaryTree {

  public TreeNode mirrorTree(TreeNode root) {
    if (root == null) return null;
    TreeNode temp = root.left;
    root.left = mirrorTree(root.right);
    root.right = mirrorTree(temp);
    return root;
  }

  // 使用栈/队列
  public TreeNode mirrorTree1(TreeNode root) {
    if (root == null) return null;
    Stack<TreeNode> newStack = new Stack<>();
    newStack.push(root);
    while (!newStack.isEmpty()) {
      TreeNode current = newStack.pop();
      if (current.left != null) newStack.add(current.left);
      if (current.right != null) newStack.add(current.right);
      TreeNode swap = current.left;
      current.left = current.right;
      current.right = swap;
    }
    return root;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
