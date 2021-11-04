package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

  // https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/

  // 404
  // 左叶子之和

  public int sumOfLeftLeaves(TreeNode root) {
    return root != null ? dfs(root) : 0;
  }
  // dfs

  public int dfs(TreeNode node) {
    int ans = 0;
    if (node.left != null) {
      ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
    }
    if (node.right != null && !isLeafNode(node.right)) {
      ans += dfs(node.right);
    }
    return ans;
  }

  public boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }

  public int sumOfLeftLeaves1(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        if (isLeafNode(node.left)) {
          ans += node.left.val;
        } else {
          queue.offer(node.left);
        }
      }
      if (node.right != null) {
        if (!isLeafNode(node.right)) {
          queue.offer(node.right);
        }
      }
    }
    return ans;
  }

  // bfs

  // 节省时间的做法
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int S = 0;
    for (int x : A) if (x % 2 == 0) S += x;

    int[] ans = new int[queries.length];

    for (int i = 0; i < queries.length; ++i) {
      int val = queries[i][0], index = queries[i][1];
      if (A[index] % 2 == 0) S -= A[index];
      A[index] += val;
      if (A[index] % 2 == 0) S += A[index];
      ans[i] = S;
    }

    return ans;
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
