package tree.BST;

public class IsBST {

  private Long min = Long.MIN_VALUE;

  // 方法一：对每一棵树 设置 左右边界
  public boolean isValidBST(TreeNode root) {

    return boundary(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean boundary(TreeNode node, long lower, long higher) {
    if (node == null) {
      return true;
    }
    if (node.val <= lower || node.val >= higher) {
      return false;
    }
    return boundary(node.left, lower, node.val) && boundary(node.right, node.val, higher);
  }

  // 方法二：中序遍历
  public boolean inorder(TreeNode node) {
    if (node == null) {
      return true;
    }
    boolean l = inorder(node.left);
    if (node.val >= min) {
      return false;
    }
    min = Long.valueOf(node.val);
    boolean r = inorder(node.right);
    return l && r;
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
