package binaryTree;

public class MinDepth_111 {

  // 111. 二叉树的最小深度

  // 和求最大深度相反

  // 求最小深度时将Math.max换成Math.min即可，但要注意如果根节点的左或右子树为空的话是构不成子树的。
  // 而最小深度是要求从根节点到子树的。当左或右子树为空时，不符合要求。

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    // if(root.left==null&&root.right==null) return 1;
    int l = minDepth(root.left);
    int r = minDepth(root.right);
    if (l == 0 && r > 0) return r + 1;
    if (r == 0 && l > 0) return l + 1;
    return Math.min(l, r) + 1;
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
