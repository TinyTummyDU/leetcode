package binaryTree.BalancedTree;

public class IsBalanced_110 {

  // 平衡二叉树
  //    给定一个二叉树，判断它是否是高度平衡的二叉树。
  //    本题中，一棵高度平衡二叉树定义为：
  //    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

  public boolean isBalanced(TreeNode root) {
    return height(root) == -1 ? false : true;
  }

  public int height(TreeNode root) {
    if (root == null) return 0;
    int l = height(root.left), r = height(root.right);
    if (l >= 0 && r >= 0 && Math.abs(l - r) <= 1) {
      return Math.max(l, r) + 1;
    } else {
      return -1;
    }
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
