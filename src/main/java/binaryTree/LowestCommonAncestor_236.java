package binaryTree;

public class LowestCommonAncestor_236 {

  // 注意和 BST 237作区分

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null && right == null) { // 1
      return null;
    }
    if (left == null) return right; // 3
    if (right == null) return left; // 4
    return root; // 2. if(left != null and right != null) 存在于两边
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
