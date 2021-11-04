package binaryTree.BST;

public class LowestCommonAncestor_BST_235 {

  // bst的中序遍历是递增序列

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 4种情况逐一分析很容易写出来
    if (root == p || root == q) return root; // 1
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q); // 2
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q); // 3
    return root; // 4
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
