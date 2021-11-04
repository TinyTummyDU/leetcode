package binaryTree;

public class SumRootToLeaf {

  // 1022 从根到叶的二进制之和

  int sum;

  public int sumRootToLeaf(TreeNode root) {
    dfs(root, 0);
    return sum;
  }

  private void dfs(TreeNode root, int cur) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      sum += cur * 2 + root.val;
    }
    dfs(root.left, cur * 2 + root.val);
    dfs(root.right, cur * 2 + root.val);
  }

  // 用一个变量维护到达当前节点时所记录的十进制数，如果该节点是叶子节点，加入答案，结束该轮递归。
  // https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/solution/yong-shi-100nei-cun-9517-by-lzx_javaxiao-bai/
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
