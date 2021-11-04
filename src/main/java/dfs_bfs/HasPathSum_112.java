package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum_112 {

  // 路径总和，这道题四种解法，背会

  // dfs
  public boolean hasPathSum_dfs(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.val == targetSum && root.left == null && root.right == null) {
      return true;
    }
    return hasPathSum_dfs(root.left, targetSum - root.val)
        || hasPathSum_dfs(root.right, targetSum - root.val);
  }

  public boolean hasPathSum_dfs_official(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    return hasPathSum_dfs_official(root.left, sum - root.val)
        || hasPathSum_dfs_official(root.right, sum - root.val);
  }

  // bfs
  public boolean hasPathSum_bfs(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<Integer> vals = new LinkedList<>();
    nodes.offer(root);
    vals.offer(root.val);
    while (!nodes.isEmpty()) {
      TreeNode node = nodes.poll();
      int val = vals.poll();
      if (node.left == null && node.right == null) {
        if (val == targetSum) {
          return true;
        }
        continue;
      }
      if (node.left != null) {
        nodes.offer(node.left);
        vals.offer(node.left.val + val);
      }
      if (node.right != null) {
        nodes.offer(node.right);
        vals.offer(node.right.val + val);
      }
    }
    return false;
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
