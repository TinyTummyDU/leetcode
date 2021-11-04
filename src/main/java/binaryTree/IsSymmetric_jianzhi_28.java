package binaryTree;

public class IsSymmetric_jianzhi_28 {

  /*    剑指 Offer 28. 对称的二叉树
  请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。*/

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return dfs(root.left, root.right);
  }

  public boolean dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    if (left.val != right.val) return false;
    return dfs(left.left, right.right) && dfs(left.right, right.left);
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
