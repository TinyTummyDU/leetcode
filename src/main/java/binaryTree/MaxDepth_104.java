package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {

  // 返回二叉树的最大高度

  // dfs
  public int maxDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftHeight = maxDepth(root.left);
      int rightHeight = maxDepth(root.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  // bfs

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0; // 广度优先有几层循环，那么最大深度就是几

    while (!queue.isEmpty()) {
      int size = queue.size(); // 当前层节点数
      while (size > 0) {
        TreeNode treeNode = queue.poll();
        if (treeNode.left != null) {
          queue.offer(treeNode.left);
        }
        if (treeNode.right != null) {
          queue.offer(treeNode.right);
        }
        size--;
      }
      ans++;
    }
    return ans;
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
