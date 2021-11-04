package dfs_bfs;

public class KthLargest_jianzhi_54 {
  // 剑指 Offer 54. 二叉搜索树的第k大节点
  // 1 ≤ k ≤ 二叉搜索树元素个数

  int res = 0; // 学会运用全局变量，不用纠结递归函数的return type了就
  int k = 0;

  public int kthLargest(TreeNode root, int k) {
    this.k = k;
    dfs(root);
    return res;
  }
  // bst 的 ldr 的 倒序就是 递减序列
  public void dfs(TreeNode root) {
    if (root == null) return;
    dfs(root.right);
    if (k == 0) return; // 提前结束，这个比较有用
    if (--k == 0) {
      res = root.val;
    }
    dfs(root.left);
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
